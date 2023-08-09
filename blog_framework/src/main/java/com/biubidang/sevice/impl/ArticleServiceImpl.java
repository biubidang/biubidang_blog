package com.biubidang.sevice.impl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.biubidang.Utils.BeanCopyUtils;
import com.biubidang.domain.ResponseResult;
import com.biubidang.domain.entity.Article;
import com.biubidang.domain.entity.Category;
import com.biubidang.domain.vo.ArticleDetailVo;
import com.biubidang.domain.vo.ArticleVo;
import com.biubidang.domain.vo.HotArticleVo;
import com.biubidang.domain.vo.PageVo;
import com.biubidang.mapper.ArticleMapper;
import com.biubidang.sevice.ArticleService;
import com.biubidang.sevice.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article>implements ArticleService {

    @Autowired
    private CategoryService categoryService;
    @Override
    public ResponseResult hotArticleList(){
        //将文章按照浏览量降序排列，仅传入id，标题与浏览量参数，仅需浏览量高的前十篇文章
        LambdaQueryWrapper<Article> queryWrapper=new LambdaQueryWrapper<>();
        //当且仅当文章状态为0，即已发表状态才展示
        queryWrapper.eq(Article::getStatus,0);
        queryWrapper.orderByDesc(Article::getViewcounts);
        //最多十条
        Page<Article> page =new Page<>(1,10);
        page(page,queryWrapper);

        List<Article> articles=page.getRecords();

        List<HotArticleVo> articleVos = new ArrayList<>();
        //使用Bean拷贝进行vo优化，仅处理hotArticle需要的属性
        for (Article article : articles) {
            HotArticleVo vo = new HotArticleVo();
            //将每个article赋值给vo
            BeanUtils.copyProperties(article,vo);
            articleVos.add(vo);
        }

        return ResponseResult.okResult(articleVos);
    }

    @Override
    public ResponseResult articleList(Integer pageNum,Integer pageSize,Long categoryId) {
        //目标：将文章信息在首页以及分类页面分别上传，仅上传已发布的文章；要求分页
        LambdaQueryWrapper<Article> queryWrapper=new LambdaQueryWrapper<>();
        //判断是否传入categoryId，根据是否判断文章列表应如何传入前端
        queryWrapper.eq(Objects.nonNull(categoryId)&&categoryId>0,Article::getCategoryId,categoryId);
        //保证已发表状态
        queryWrapper.eq(Article::getStatus,0);

        //使用分页查询
        Page<Article> page=new Page<>(pageNum,pageSize);
        page(page,queryWrapper);

        List<Article> articles=page.getRecords();
        //使用for循环获取分类名称
        for(Article article:articles){
           Category category= categoryService.getById(article.getCategoryId());
        //  String name = category.getName();
            article.setCategoryname(category.getName());
        }
        //使用Vo优化
        List<ArticleVo> articleVos= BeanCopyUtils.copyBeanList(page.getRecords(),ArticleVo.class);
        PageVo pageVo=new PageVo(articleVos,page.getTotal());
        //返回封装
        return ResponseResult.okResult(pageVo);
    }

    @Override
    public ResponseResult articleDetail(Long id) {
        //目标：根据文章id返回文章内容等信息，需要根据分类id显示上传分类名称
        //查询目标文章
        Article article=getById(id);
        //vo封装
        ArticleDetailVo articleDetailVo=BeanCopyUtils.copyBean(article,ArticleDetailVo.class);

        //加入Categoryname
        Category category=categoryService.getById(article.getCategoryId());
        if(category!=null){
            articleDetailVo.setCategoryname(category.getName());
        }
        //返回所需值
        return ResponseResult.okResult(articleDetailVo);
    }

}

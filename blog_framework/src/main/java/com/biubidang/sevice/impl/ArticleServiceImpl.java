package com.biubidang.sevice.impl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.biubidang.domain.ResponseResult;
import com.biubidang.domain.entity.Article;
import com.biubidang.domain.vo.HotArticleVo;
import com.biubidang.mapper.ArticleMapper;
import com.biubidang.sevice.ArticleService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article>implements ArticleService {

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

}

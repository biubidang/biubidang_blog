package com.biubidang.sevice.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.biubidang.Utils.BeanCopyUtils;
import com.biubidang.domain.ResponseResult;
import com.biubidang.domain.entity.Category;
import com.biubidang.domain.vo.CategoryListVo;
import com.biubidang.mapper.CategoryMapper;
import com.biubidang.sevice.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * (Category)表服务实现类
 *
 * @author makejava
 * @since 2023-08-05 15:42:18
 */
@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {


    @Autowired
    @Lazy
    private CategoryService categoryService;
    @Override
    public ResponseResult getCategoryList() {
        //目标：传入每个可用分类
//        //获取所有已发表的文章
//        LambdaQueryWrapper<Article> queryWrapper=new LambdaQueryWrapper<>();
//        queryWrapper.eq(Article::getStatus,0);
//        List<Article> articleList=articleService.list();
        //传入分类必须可用
        List<Category> categoryList=categoryService.list();
        categoryList=categoryList.stream().
                filter(category -> category.getStatus().equals("0"))
                .collect(Collectors.toList());
        //使用Vo封装Category信息
        List<CategoryListVo> categoryListVo= BeanCopyUtils.copyBeanList(categoryList,CategoryListVo.class);
        //返回统一格式
        return ResponseResult.okResult(categoryListVo);

    }
}

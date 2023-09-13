package com.biubidang.sevice;

import com.baomidou.mybatisplus.extension.service.IService;
import com.biubidang.domain.ResponseResult;
import com.biubidang.domain.entity.Article;

public interface ArticleService extends IService<Article> {
    ResponseResult hotArticleList();

    ResponseResult articleList(Integer pageNum,Integer pageSize,Long categoryId);

    ResponseResult articleDetail(Long id);

    ResponseResult updateViewcount(Long id);
}

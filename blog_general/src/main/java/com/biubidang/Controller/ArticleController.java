package com.biubidang.Controller;

import com.biubidang.domain.ResponseResult;
import com.biubidang.sevice.ArticleService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/article")
@Api(tags = "博客",description = "文章列表相关接口")
public class ArticleController {
  @Autowired
    private ArticleService articleService;
//  @GetMapping("list")
//  public List<Article> test(){
//      return articleService.list();

//  }
  @GetMapping("/hotArticleList")
      public ResponseResult hotArticleList(){
    return articleService.hotArticleList();
  }
  @GetMapping("/articleList")
  public ResponseResult articleList(Integer pageNum,Integer pageSize,Long categoryId){
    return articleService.articleList(pageNum, pageSize,categoryId);
  }
  @GetMapping("/{id}")
  public ResponseResult articleDetail(@PathVariable("id") Long id){

    return articleService.articleDetail(id);
  }

  @PutMapping("/updateViewCount/{id}")
  public ResponseResult updateViewcount(@PathVariable ("id") Long id){
    return articleService.updateViewcount(id);
  }
}

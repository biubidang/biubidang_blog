package com.biubidang.Controller;

import com.biubidang.domain.ResponseResult;
import com.biubidang.sevice.CategoryService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
@Api(tags = "分类",description = "分类相关接口")
public class CategoryController {
    @Autowired
        private CategoryService categoryService;
    @GetMapping("/categoryList")
        public ResponseResult getCategoryList(){
        return categoryService.getCategoryList();
    }
}

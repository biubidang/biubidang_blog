package com.biubidang.sevice;

import com.baomidou.mybatisplus.extension.service.IService;
import com.biubidang.domain.ResponseResult;
import com.biubidang.domain.entity.Category;


/**
 * (Category)表服务接口
 *
 * @author makejava
 * @since 2023-08-05 15:42:18
 */
public interface CategoryService extends IService<Category> {

    ResponseResult getCategoryList();
}

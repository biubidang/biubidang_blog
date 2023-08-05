package com.biubidang.sevice.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.biubidang.domain.entity.Category;
import com.biubidang.mapper.CategoryMapper;
import com.biubidang.sevice.CategoryService;
import org.springframework.stereotype.Service;

/**
 * (Category)表服务实现类
 *
 * @author makejava
 * @since 2023-08-05 15:42:18
 */
@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

}

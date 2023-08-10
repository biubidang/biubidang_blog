package com.biubidang.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.biubidang.domain.entity.User;
import org.springframework.stereotype.Repository;


/**
 * (User)表数据库访问层
 *
 * @author makejava
 * @since 2023-08-10 14:59:03
 */
@Repository(value = "userMapper")
public interface UserMapper extends BaseMapper<User> {

}

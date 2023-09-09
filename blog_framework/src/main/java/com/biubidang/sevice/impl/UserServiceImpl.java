package com.biubidang.sevice.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.biubidang.Utils.BeanCopyUtils;
import com.biubidang.Utils.SecurityUtils;
import com.biubidang.domain.ResponseResult;
import com.biubidang.domain.entity.User;
import com.biubidang.domain.vo.UserInfoVo;
import com.biubidang.mapper.UserMapper;
import com.biubidang.sevice.UserService;

import org.springframework.stereotype.Service;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2023-09-09 20:48:06
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl< UserMapper, User> implements UserService {

    @Override
    public ResponseResult getUserInfo() {
        //获取id
        Long userId= SecurityUtils.getUserId();
        //根据id查个人信息
        User user =getById(userId);
        //封装
        UserInfoVo userInfoVo= BeanCopyUtils.copyBean(user,UserInfoVo.class);
        return ResponseResult.okResult(userInfoVo);
    }
}

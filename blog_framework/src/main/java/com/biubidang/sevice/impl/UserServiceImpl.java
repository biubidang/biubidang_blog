package com.biubidang.sevice.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.biubidang.Utils.BeanCopyUtils;
import com.biubidang.Utils.SecurityUtils;
import com.biubidang.domain.ResponseResult;
import com.biubidang.domain.entity.User;
import com.biubidang.domain.vo.UserInfoVo;
import com.biubidang.enums.HttpCodeEnum;
import com.biubidang.excption.SystemException;
import com.biubidang.mapper.UserMapper;
import com.biubidang.sevice.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2023-09-09 20:48:06
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl< UserMapper, User> implements UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;
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

    @Override
    public ResponseResult updateUserInfo(User user) {

//        if(nickNameExist(user.getNickName())){
//            throw new SystemException(HttpCodeEnum.NICKNAME_EXIST);
//        }
        updateById(user);
        return ResponseResult.okResult();
    }

    @Override
    public ResponseResult register(User user) {
        //对数据进行非空判断
        if(!StringUtils.hasText(user.getUserName())){
            throw new SystemException(HttpCodeEnum.USERNAME_NOT_NULL);
        }
        if(!StringUtils.hasText(user.getPassword())){
            throw new SystemException(HttpCodeEnum.PASSWORD_NOT_NULL);
        }
        if(!StringUtils.hasText(user.getEmail())){
            throw new SystemException(HttpCodeEnum.EMAIL_NOT_NULL);
        }
        if(!StringUtils.hasText(user.getNickName())){
            throw new SystemException(HttpCodeEnum.NICKNAME_NOT_NULL);
        }
        //对数据进行是否存在的判断
        if(userNameExist(user.getUserName())){
            throw new SystemException(HttpCodeEnum.USERNAME_EXIST);
        }
        if(nickNameExist(user.getNickName())){
            throw new SystemException(HttpCodeEnum.NICKNAME_EXIST);
        }
        //对密码进行加密
        String encodePassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodePassword);
        //存入数据库
        save(user);
        return ResponseResult.okResult();
    }

    private boolean nickNameExist(String nickName) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getNickName,nickName);
        return count(queryWrapper)>0;
    }

    private boolean userNameExist(String userName) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUserName,userName);
        return count(queryWrapper)>0;
    }
}

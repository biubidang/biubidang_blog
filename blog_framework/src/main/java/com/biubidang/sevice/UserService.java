package com.biubidang.sevice;

import com.baomidou.mybatisplus.extension.service.IService;
import com.biubidang.domain.ResponseResult;
import com.biubidang.domain.entity.User;


/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2023-09-09 20:48:05
 */
public interface UserService extends IService<User> {

    ResponseResult getUserInfo();

    ResponseResult updateUserInfo(User user);

    ResponseResult register(User user);
}

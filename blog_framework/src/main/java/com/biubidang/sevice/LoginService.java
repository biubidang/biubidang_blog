package com.biubidang.sevice;

import com.biubidang.domain.ResponseResult;
import com.biubidang.domain.entity.User;

public interface LoginService
{
    ResponseResult login(User user);

    ResponseResult logout();
}

package com.biubidang.Controller;

import com.biubidang.domain.ResponseResult;
import com.biubidang.domain.entity.User;
import com.biubidang.sevice.LoginService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "登录",description = "登入登出相关接口")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public ResponseResult login(@RequestBody User user){
        return loginService.login(user);
    }

    @PostMapping("/logout")
    public ResponseResult logout(){
        return loginService.logout();
    }
}

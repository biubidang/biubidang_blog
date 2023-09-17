package com.biubidang.Controller;

import com.biubidang.domain.ResponseResult;
import com.biubidang.domain.entity.User;
import com.biubidang.sevice.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Api(tags = "用户",description = "个人信息&注册相关接口")
public class UserController {
   @Autowired
      private UserService userService;
   @GetMapping("/userinfo")
      public ResponseResult getUserInfo(){
          return userService.getUserInfo();

  }
   @PutMapping("/userinfo")
      public  ResponseResult updateUserInfo(@RequestBody User user){
          return userService.updateUserInfo(user);
  }
  @PostMapping("/register")
    public ResponseResult register(@RequestBody User user){
       return  userService.register(user);
  }
}

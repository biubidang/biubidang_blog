package com.biubidang.Controller;

import com.biubidang.domain.ResponseResult;
import com.biubidang.domain.entity.User;
import com.biubidang.sevice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
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

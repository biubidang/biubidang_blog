package com.biubidang.Controller;

import com.biubidang.domain.ResponseResult;
import com.biubidang.sevice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
   @Autowired
      private UserService userService;
   @GetMapping("/userinfo")
      public ResponseResult getUserInfo(){
          return userService.getUserInfo();

  }
}

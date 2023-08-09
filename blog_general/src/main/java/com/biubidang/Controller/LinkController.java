package com.biubidang.Controller;

import com.biubidang.domain.ResponseResult;
import com.biubidang.sevice.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/friendlink")
public class LinkController {
    @Autowired
    private LinkService linkService;
    @GetMapping("/allLink")
    public ResponseResult getAllLink(){
        return linkService.getAllLink();
    }
}

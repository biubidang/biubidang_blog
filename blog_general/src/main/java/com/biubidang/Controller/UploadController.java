package com.biubidang.Controller;

import com.biubidang.domain.ResponseResult;
import com.biubidang.sevice.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadController {
    @Autowired
    private UploadService uploadService;
    @PostMapping("/upload")
    public ResponseResult uploadimg(MultipartFile img){
        return uploadService.uploadimg(img);
    }
}

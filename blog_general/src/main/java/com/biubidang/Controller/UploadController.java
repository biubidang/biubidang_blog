package com.biubidang.Controller;

import com.biubidang.domain.ResponseResult;
import com.biubidang.sevice.UploadService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Api(tags = "上传",description = "图片上传相关接口")
public class UploadController {
    @Autowired
    private UploadService uploadService;
    @PostMapping("/upload")
    public ResponseResult uploadimg(MultipartFile img){
        return uploadService.uploadimg(img);
    }
}

package com.biubidang.sevice;

import com.biubidang.domain.ResponseResult;
import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
    ResponseResult uploadimg(MultipartFile img);
}

package com.biubidang.sevice;

import com.baomidou.mybatisplus.extension.service.IService;
import com.biubidang.domain.ResponseResult;
import com.biubidang.domain.entity.Link;


/**
 * (Link)表服务接口
 *
 * @author makejava
 * @since 2023-08-09 15:38:07
 */
public interface LinkService extends IService<Link> {

    ResponseResult getAllLink();
}

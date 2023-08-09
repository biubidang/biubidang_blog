package com.biubidang.sevice.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.biubidang.Utils.BeanCopyUtils;
import com.biubidang.domain.ResponseResult;
import com.biubidang.domain.entity.Link;
import com.biubidang.domain.vo.LinkVo;
import com.biubidang.mapper.LinkMapper;
import com.biubidang.sevice.LinkService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Link)表服务实现类
 *
 * @author makejava
 * @since 2023-08-09 15:38:07
 */
@Service("linkService")
public class LinkServiceImpl extends ServiceImpl<LinkMapper, Link> implements LinkService {

    @Override
    public ResponseResult getAllLink() {
        //目标：获取所有通过审核的友情链接
        //筛选出状态为0（即正常）的友情链接
        LambdaQueryWrapper<Link> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(Link::getStatus,0);
        //Vo封装
        List<LinkVo> linkVos= BeanCopyUtils.copyBeanList(list(queryWrapper),LinkVo.class);
        //返回统一结果
        return ResponseResult.okResult(linkVos);
    }
}

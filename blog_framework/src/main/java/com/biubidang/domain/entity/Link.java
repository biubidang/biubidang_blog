package com.biubidang.domain.entity;

import java.util.Date;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * (Link)表实体类
 *
 * @author makejava
 * @since 2023-08-09 15:38:06
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("link")
public class Link {
    @TableId
    private Long id;


    private String name;
    //图片地址
    private String logo;
    //网站地址
    private String address;

    private String description;
    //0表示通过，1表示未通过,2表示未处理
    private String status;

    private Date createtime;

    private Long createby;

    private Date updatetime;

    private Long updateby;
    //0未删除，1已删除
    private Integer delFlag;

}

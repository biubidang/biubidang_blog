package com.biubidang.domain.entity;

import java.util.Date;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * (Category)表实体类
 *
 * @author makejava
 * @since 2023-08-05 15:42:12
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("category")
public class Category  {
    @TableId
    private Long id;

    //父分类id
    private Long pid;
    //0表示启用，1表示禁用
    private String status;

    private String name;

    private String description;

    private Date createtime;

    private String createby;

    private Date updatetime;

    private String updateby;
    //0未删除，1已经删除
    private Integer delFlag;
    }



package com.biubidang.domain.entity;

import java.util.Date;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * (User)表实体类
 *
 * @author makejava
 * @since 2023-08-10 14:59:04
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
public class User {
    @TableId
    private Long id;


    private String userName;

    private String nickName;

    private String password;
    //0正常，1停用
    private String status;
    //0表示普通用户，1表示管理员用户
    private String type;

    private String email;
    //头像
    private String avatar;

    private Date createtime;

    private Long createby;

    private Date updatetime;

    private Long updateby;

    private Integer delFlag;
}



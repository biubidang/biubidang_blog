package com.biubidang.domain.entity;

import java.util.Date;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * (Article)表实体类
 *
 * @author makejava
 * @since 2023-08-07 16:28:21
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("article")
public class Article {
    @TableId
    private Long id;


    private String title;

    private String content;

    private String discription;

    private String status;

    private Long viewcounts;

    private Long createby;

    private Date createtime;

    private Long updateby;

    private Date updatetime;
    //缩略图地址
    private String thumbnail;

    private Integer categoryId;
    @TableField(exist = false)
    private String categoryname;

    public Article(Long id, long viewcounts) {
        this.id = id;
        this.viewcounts = viewcounts;
    }
}



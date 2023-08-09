package com.biubidang.domain.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data// 注在类上，提供类的get、set、equals、hashCode、canEqual、toString方法
@NoArgsConstructor//注在类上，提供类的全参构造
@AllArgsConstructor//注在类上，提供类的无参构造
public class ArticleDetailVo
{
    private Long id;

    private String title;

    private String content;

    private Long viewcounts;

    private Long createby;

    private Date createtime;
    //缩略图地址
    private String thumbnail;

    private String categoryname;
}

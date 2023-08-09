package com.biubidang.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data// 注在类上，提供类的get、set、equals、hashCode、canEqual、toString方法
@NoArgsConstructor//注在类上，提供类的全参构造
@AllArgsConstructor//注在类上，提供类的无参构造
public class LinkVo {
    private Long id;

    private String name;
    //图片地址
    private String logo;
    //网站地址
    private String address;

    private String description;
    //0表示通过，1表示未通过,2表示未处理


}

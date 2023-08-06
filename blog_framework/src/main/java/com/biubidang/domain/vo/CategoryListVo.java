package com.biubidang.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data// 注在类上，提供类的get、set、equals、hashCode、canEqual、toString方法
@NoArgsConstructor//注在类上，提供类的全参构造
@AllArgsConstructor//注在类上，提供类的无参构造
public class CategoryListVo {
    private Long id;

    private String name;

    private String description;
}

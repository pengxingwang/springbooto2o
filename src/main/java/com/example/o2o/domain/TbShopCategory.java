package com.example.o2o.domain;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class TbShopCategory {
    private Integer shopCategoryId;

    private String shopCategoryName;

    private String shopCategoryDesc;

    private String shopCategoryImg;

    private Integer priority;

    private LocalDateTime createTime;

    private LocalDateTime lastEditTime;

    private Integer parentId;
}
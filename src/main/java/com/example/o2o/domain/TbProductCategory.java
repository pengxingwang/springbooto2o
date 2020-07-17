package com.example.o2o.domain;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class TbProductCategory {
    private Integer productCategoryId;

    private String productCategoryName;

    private Integer priority;

    private LocalDateTime createTime;

    private Integer shopId;
}
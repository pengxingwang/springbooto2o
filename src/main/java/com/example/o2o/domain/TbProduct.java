package com.example.o2o.domain;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class TbProduct {
    private Integer productId;

    private String productName;

    private String productDesc;

    private String imgAddr;

    private String normalPrice;

    private String promotionPrice;

    private Integer priority;

    private LocalDateTime createTime;

    private LocalDateTime lastEditTime;

    private Integer enableStatus;

    private Integer productCategoryId;

    private Integer shopId;
}
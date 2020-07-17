package com.example.o2o.params;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TbShopParmas {
    private Integer shopId;

    private Integer ownerId;

    private Integer areaId;

    private Integer shopCategoryId;

    private String shopName;

    private String shopDesc;

    private String shopAddr;

    private String phone;

    private String shopImg;

    private Integer priority;

    private String advice;

    private String verifyCodeActual;
}
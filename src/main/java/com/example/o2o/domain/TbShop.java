package com.example.o2o.domain;

import java.time.LocalDateTime;
import java.util.Date;

import lombok.Data;

@Data
public class TbShop {
    private Integer shopId;

    /**
    * 店铺创建人
    */
    private Integer ownerId;

    private Integer areaId;

    private Integer shopCategoryId;

    private String shopName;

    private String shopDesc;

    private String shopAddr;

    private String phone;

    private String shopImg;

    private Integer priority;

    private LocalDateTime createTime;

    private LocalDateTime lastEditTime;

    private Integer enableStatus;

    private String advice;
}
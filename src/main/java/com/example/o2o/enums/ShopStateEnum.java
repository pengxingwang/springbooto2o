package com.example.o2o.enums;

import lombok.Data;

/**
 * ShopStateEnum
 */
public enum ShopStateEnum {
    CHECK(0, "审核中"),
    OFFLINE(-1, "非法店铺"),
    SUCCESS(1,"操作成功"),
    PASS(2, "通过认证"),
    INNER_ERROR(-1001, "内部系统错误"),
    NULL_SHOPID(-1002, "shopId为空"),
    NULL_SHOP(-1003, "shop信息为空");

    private int state;
    private String stateInfo;



    // 为什么设置成私有的，因为不希望外部去改变枚举，只能内部调用，当做常量去使用
    private ShopStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }
}

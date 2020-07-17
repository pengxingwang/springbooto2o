package com.example.o2o.enums;


import lombok.Data;

public enum ResultEnum {
    SUCCESS(0,"成功" ),
    ERROR(-1,"失败" ),
    IMG_ISNULL(-10000,"图片为空" ),
    SHOP_ISNULL(-10001,"店铺为空" ),
    CODE_ERROR(-10002,"验证码错误" ),
    SHOPID_ISNULL(-10003,"店铺Id为空" );

    ;
    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}

package com.example.o2o.dto;

import com.example.o2o.domain.TbShop;
import com.example.o2o.enums.ShopStateEnum;
import lombok.Data;

import java.util.List;

@Data
public class ShopExecution extends Throwable {
    // 结果状态
    private int state;

    // 状态标识
    private String stateInfo;

    // 店铺数量
    private int count;

    // 操作的shop(增删改店铺的时候用得到)
    private TbShop shop;

    // shop 列表（查询的时候用得到）
    private List<TbShop> shopList;

    public ShopExecution() {
    }

    // 操作店铺失败的构造器
    public ShopExecution(ShopStateEnum shopStateEnum){
        this.state = shopStateEnum.getState();
        this.stateInfo = shopStateEnum.getStateInfo();
    }

    // 操作店铺成功的构造器
    public ShopExecution(ShopStateEnum shopStateEnum, TbShop shop){
        this.state = shopStateEnum.getState();
        this.stateInfo = shopStateEnum.getStateInfo();
        this.shop = shop;
    }

    // 操作店铺成功的构造器
    public ShopExecution(ShopStateEnum shopStateEnum, List<TbShop> shopList){
        this.state = shopStateEnum.getState();
        this.stateInfo = shopStateEnum.getStateInfo();
        this.shopList = shopList;
    }




}

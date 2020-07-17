package com.example.o2o.service;

import com.example.o2o.domain.TbShop;
import com.example.o2o.dto.ShopExecution;

import java.io.File;
import java.util.List;

public interface TbShopService{


    int deleteByPrimaryKey(Integer shopId);

    int insert(TbShop record);

    int insertSelective(TbShop record);

    TbShop selectByPrimaryKey(Integer shopId);

    int updateByPrimaryKeySelective(TbShop record);

    int updateByPrimaryKey(TbShop record);

    ShopExecution addShop(TbShop shop);

    List<TbShop> list(TbShop tbShop);

}

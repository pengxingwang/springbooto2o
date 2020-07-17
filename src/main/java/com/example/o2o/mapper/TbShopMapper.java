package com.example.o2o.mapper;
import org.apache.ibatis.annotations.Param;
import java.time.LocalDateTime;

import com.example.o2o.domain.TbShop;

import java.util.List;

public interface TbShopMapper {
    int deleteByPrimaryKey(Integer shopId);

    int insert(TbShop record);

    int insertSelective(TbShop record);

    TbShop selectByPrimaryKey(Integer shopId);

    int updateByPrimaryKeySelective(TbShop record);

    int updateByPrimaryKey(TbShop record);

    List<TbShop> findByAllOrderByPriority(TbShop tbShop);


}
package com.example.o2o.mapper;

import com.example.o2o.domain.TbProduct;

public interface TbProductMapper {
    int deleteByPrimaryKey(Integer productId);

    int insert(TbProduct record);

    int insertSelective(TbProduct record);

    TbProduct selectByPrimaryKey(Integer productId);

    int updateByPrimaryKeySelective(TbProduct record);

    int updateByPrimaryKey(TbProduct record);
}
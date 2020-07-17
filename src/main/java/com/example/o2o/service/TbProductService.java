package com.example.o2o.service;

import com.example.o2o.domain.TbProduct;
public interface TbProductService{


    int deleteByPrimaryKey(Integer productId);

    int insert(TbProduct record);

    int insertSelective(TbProduct record);

    TbProduct selectByPrimaryKey(Integer productId);

    int updateByPrimaryKeySelective(TbProduct record);

    int updateByPrimaryKey(TbProduct record);

}

package com.example.o2o.service;

import com.example.o2o.domain.TbProductCategory;
public interface TbProductCategoryService{


    int deleteByPrimaryKey(Integer productCategoryId);

    int insert(TbProductCategory record);

    int insertSelective(TbProductCategory record);

    TbProductCategory selectByPrimaryKey(Integer productCategoryId);

    int updateByPrimaryKeySelective(TbProductCategory record);

    int updateByPrimaryKey(TbProductCategory record);

}

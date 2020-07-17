package com.example.o2o.mapper;

import com.example.o2o.domain.TbProductCategory;

public interface TbProductCategoryMapper {
    int deleteByPrimaryKey(Integer productCategoryId);

    int insert(TbProductCategory record);

    int insertSelective(TbProductCategory record);

    TbProductCategory selectByPrimaryKey(Integer productCategoryId);

    int updateByPrimaryKeySelective(TbProductCategory record);

    int updateByPrimaryKey(TbProductCategory record);
}
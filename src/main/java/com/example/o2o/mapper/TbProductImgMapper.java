package com.example.o2o.mapper;

import com.example.o2o.domain.TbProductImg;

public interface TbProductImgMapper {
    int deleteByPrimaryKey(Integer productImgId);

    int insert(TbProductImg record);

    int insertSelective(TbProductImg record);

    TbProductImg selectByPrimaryKey(Integer productImgId);

    int updateByPrimaryKeySelective(TbProductImg record);

    int updateByPrimaryKey(TbProductImg record);
}
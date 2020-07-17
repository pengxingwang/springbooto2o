package com.example.o2o.service;

import com.example.o2o.domain.TbProductImg;
public interface TbProductImgService{


    int deleteByPrimaryKey(Integer productImgId);

    int insert(TbProductImg record);

    int insertSelective(TbProductImg record);

    TbProductImg selectByPrimaryKey(Integer productImgId);

    int updateByPrimaryKeySelective(TbProductImg record);

    int updateByPrimaryKey(TbProductImg record);

}

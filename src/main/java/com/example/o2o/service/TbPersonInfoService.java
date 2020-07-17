package com.example.o2o.service;

import com.example.o2o.domain.TbPersonInfo;
public interface TbPersonInfoService{


    int deleteByPrimaryKey(Integer userId);

    int insert(TbPersonInfo record);

    int insertSelective(TbPersonInfo record);

    TbPersonInfo selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(TbPersonInfo record);

    int updateByPrimaryKey(TbPersonInfo record);

}

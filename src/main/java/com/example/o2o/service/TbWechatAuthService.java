package com.example.o2o.service;

import com.example.o2o.domain.TbWechatAuth;
public interface TbWechatAuthService{


    int deleteByPrimaryKey(Integer wechatAuthId);

    int insert(TbWechatAuth record);

    int insertSelective(TbWechatAuth record);

    TbWechatAuth selectByPrimaryKey(Integer wechatAuthId);

    int updateByPrimaryKeySelective(TbWechatAuth record);

    int updateByPrimaryKey(TbWechatAuth record);

}

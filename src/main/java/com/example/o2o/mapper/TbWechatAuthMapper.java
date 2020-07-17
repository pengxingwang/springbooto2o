package com.example.o2o.mapper;

import com.example.o2o.domain.TbWechatAuth;

public interface TbWechatAuthMapper {
    int deleteByPrimaryKey(Integer wechatAuthId);

    int insert(TbWechatAuth record);

    int insertSelective(TbWechatAuth record);

    TbWechatAuth selectByPrimaryKey(Integer wechatAuthId);

    int updateByPrimaryKeySelective(TbWechatAuth record);

    int updateByPrimaryKey(TbWechatAuth record);
}
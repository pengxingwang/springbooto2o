package com.example.o2o.mapper;

import com.example.o2o.domain.TbLocalAuth;

public interface TbLocalAuthMapper {
    int deleteByPrimaryKey(Integer localAuthId);

    int insert(TbLocalAuth record);

    int insertSelective(TbLocalAuth record);

    TbLocalAuth selectByPrimaryKey(Integer localAuthId);

    int updateByPrimaryKeySelective(TbLocalAuth record);

    int updateByPrimaryKey(TbLocalAuth record);
}
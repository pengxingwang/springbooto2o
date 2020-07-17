package com.example.o2o.mapper;

import com.example.o2o.domain.TbHeadLine;

public interface TbHeadLineMapper {
    int deleteByPrimaryKey(Integer lineId);

    int insert(TbHeadLine record);

    int insertSelective(TbHeadLine record);

    TbHeadLine selectByPrimaryKey(Integer lineId);

    int updateByPrimaryKeySelective(TbHeadLine record);

    int updateByPrimaryKey(TbHeadLine record);
}
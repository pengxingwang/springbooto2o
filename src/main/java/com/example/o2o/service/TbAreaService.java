package com.example.o2o.service;

import com.example.o2o.domain.TbArea;

import java.util.List;

public interface TbAreaService{


    int deleteByPrimaryKey(Integer areaId);

    int insert(TbArea record);

    int insertSelective(TbArea record);

    TbArea selectByPrimaryKey(Integer areaId);

    int updateByPrimaryKeySelective(TbArea record);

    int updateByPrimaryKey(TbArea record);

    List<TbArea> findByAll();

}

package com.example.o2o.mapper;
import org.apache.ibatis.annotations.Param;
import java.time.LocalDateTime;

import com.example.o2o.domain.TbArea;

import java.util.List;

public interface TbAreaMapper {
    int deleteByPrimaryKey(Integer areaId);

    int insert(TbArea record);

    int insertSelective(TbArea record);

    TbArea selectByPrimaryKey(Integer areaId);

    int updateByPrimaryKeySelective(TbArea record);

    int updateByPrimaryKey(TbArea record);

    List<TbArea> findByallOrderByPriorityDesc();



}
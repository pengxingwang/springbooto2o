package com.example.o2o.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.o2o.domain.TbArea;
import com.example.o2o.mapper.TbAreaMapper;
import com.example.o2o.service.TbAreaService;

import java.util.List;

@Service
public class TbAreaServiceImpl implements TbAreaService{


    @Resource
    private TbAreaMapper tbAreaMapper;

    @Override
    public int deleteByPrimaryKey(Integer areaId) {
        return tbAreaMapper.deleteByPrimaryKey(areaId);
    }

    @Override
    public int insert(TbArea record) {
        return tbAreaMapper.insert(record);
    }

    @Override
    public int insertSelective(TbArea record) {
        return tbAreaMapper.insertSelective(record);
    }

    @Override
    public TbArea selectByPrimaryKey(Integer areaId) {
        return tbAreaMapper.selectByPrimaryKey(areaId);
    }

    @Override
    public int updateByPrimaryKeySelective(TbArea record) {
        return tbAreaMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TbArea record) {
        return tbAreaMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<TbArea> findByAll() {
        return tbAreaMapper.findByallOrderByPriorityDesc();
    }

}

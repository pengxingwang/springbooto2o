package com.example.o2o.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.o2o.mapper.TbHeadLineMapper;
import com.example.o2o.domain.TbHeadLine;
import com.example.o2o.service.TbHeadLineService;
@Service
public class TbHeadLineServiceImpl implements TbHeadLineService{

    @Resource
    private TbHeadLineMapper tbHeadLineMapper;

    @Override
    public int deleteByPrimaryKey(Integer lineId) {
        return tbHeadLineMapper.deleteByPrimaryKey(lineId);
    }

    @Override
    public int insert(TbHeadLine record) {
        return tbHeadLineMapper.insert(record);
    }

    @Override
    public int insertSelective(TbHeadLine record) {
        return tbHeadLineMapper.insertSelective(record);
    }

    @Override
    public TbHeadLine selectByPrimaryKey(Integer lineId) {
        return tbHeadLineMapper.selectByPrimaryKey(lineId);
    }

    @Override
    public int updateByPrimaryKeySelective(TbHeadLine record) {
        return tbHeadLineMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TbHeadLine record) {
        return tbHeadLineMapper.updateByPrimaryKey(record);
    }

}

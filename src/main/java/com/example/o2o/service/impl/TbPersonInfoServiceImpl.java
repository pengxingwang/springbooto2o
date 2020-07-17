package com.example.o2o.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.o2o.domain.TbPersonInfo;
import com.example.o2o.mapper.TbPersonInfoMapper;
import com.example.o2o.service.TbPersonInfoService;
@Service
public class TbPersonInfoServiceImpl implements TbPersonInfoService{

    @Resource
    private TbPersonInfoMapper tbPersonInfoMapper;

    @Override
    public int deleteByPrimaryKey(Integer userId) {
        return tbPersonInfoMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public int insert(TbPersonInfo record) {
        return tbPersonInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(TbPersonInfo record) {
        return tbPersonInfoMapper.insertSelective(record);
    }

    @Override
    public TbPersonInfo selectByPrimaryKey(Integer userId) {
        return tbPersonInfoMapper.selectByPrimaryKey(userId);
    }

    @Override
    public int updateByPrimaryKeySelective(TbPersonInfo record) {
        return tbPersonInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TbPersonInfo record) {
        return tbPersonInfoMapper.updateByPrimaryKey(record);
    }

}

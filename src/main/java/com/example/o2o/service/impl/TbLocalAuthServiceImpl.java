package com.example.o2o.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.o2o.domain.TbLocalAuth;
import com.example.o2o.mapper.TbLocalAuthMapper;
import com.example.o2o.service.TbLocalAuthService;
@Service
public class TbLocalAuthServiceImpl implements TbLocalAuthService{

    @Resource
    private TbLocalAuthMapper tbLocalAuthMapper;

    @Override
    public int deleteByPrimaryKey(Integer localAuthId) {
        return tbLocalAuthMapper.deleteByPrimaryKey(localAuthId);
    }

    @Override
    public int insert(TbLocalAuth record) {
        return tbLocalAuthMapper.insert(record);
    }

    @Override
    public int insertSelective(TbLocalAuth record) {
        return tbLocalAuthMapper.insertSelective(record);
    }

    @Override
    public TbLocalAuth selectByPrimaryKey(Integer localAuthId) {
        return tbLocalAuthMapper.selectByPrimaryKey(localAuthId);
    }

    @Override
    public int updateByPrimaryKeySelective(TbLocalAuth record) {
        return tbLocalAuthMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TbLocalAuth record) {
        return tbLocalAuthMapper.updateByPrimaryKey(record);
    }

}

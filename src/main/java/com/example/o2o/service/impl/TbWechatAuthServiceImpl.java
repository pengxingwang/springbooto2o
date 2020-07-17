package com.example.o2o.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.o2o.mapper.TbWechatAuthMapper;
import com.example.o2o.domain.TbWechatAuth;
import com.example.o2o.service.TbWechatAuthService;
@Service
public class TbWechatAuthServiceImpl implements TbWechatAuthService{

    @Resource
    private TbWechatAuthMapper tbWechatAuthMapper;

    @Override
    public int deleteByPrimaryKey(Integer wechatAuthId) {
        return tbWechatAuthMapper.deleteByPrimaryKey(wechatAuthId);
    }

    @Override
    public int insert(TbWechatAuth record) {
        return tbWechatAuthMapper.insert(record);
    }

    @Override
    public int insertSelective(TbWechatAuth record) {
        return tbWechatAuthMapper.insertSelective(record);
    }

    @Override
    public TbWechatAuth selectByPrimaryKey(Integer wechatAuthId) {
        return tbWechatAuthMapper.selectByPrimaryKey(wechatAuthId);
    }

    @Override
    public int updateByPrimaryKeySelective(TbWechatAuth record) {
        return tbWechatAuthMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TbWechatAuth record) {
        return tbWechatAuthMapper.updateByPrimaryKey(record);
    }

}

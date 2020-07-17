package com.example.o2o.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.o2o.mapper.TbProductImgMapper;
import com.example.o2o.domain.TbProductImg;
import com.example.o2o.service.TbProductImgService;
@Service
public class TbProductImgServiceImpl implements TbProductImgService{

    @Resource
    private TbProductImgMapper tbProductImgMapper;

    @Override
    public int deleteByPrimaryKey(Integer productImgId) {
        return tbProductImgMapper.deleteByPrimaryKey(productImgId);
    }

    @Override
    public int insert(TbProductImg record) {
        return tbProductImgMapper.insert(record);
    }

    @Override
    public int insertSelective(TbProductImg record) {
        return tbProductImgMapper.insertSelective(record);
    }

    @Override
    public TbProductImg selectByPrimaryKey(Integer productImgId) {
        return tbProductImgMapper.selectByPrimaryKey(productImgId);
    }

    @Override
    public int updateByPrimaryKeySelective(TbProductImg record) {
        return tbProductImgMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TbProductImg record) {
        return tbProductImgMapper.updateByPrimaryKey(record);
    }

}

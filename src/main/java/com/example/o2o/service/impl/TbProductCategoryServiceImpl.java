package com.example.o2o.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.o2o.domain.TbProductCategory;
import com.example.o2o.mapper.TbProductCategoryMapper;
import com.example.o2o.service.TbProductCategoryService;
@Service
public class TbProductCategoryServiceImpl implements TbProductCategoryService{

    @Resource
    private TbProductCategoryMapper tbProductCategoryMapper;

    @Override
    public int deleteByPrimaryKey(Integer productCategoryId) {
        return tbProductCategoryMapper.deleteByPrimaryKey(productCategoryId);
    }

    @Override
    public int insert(TbProductCategory record) {
        return tbProductCategoryMapper.insert(record);
    }

    @Override
    public int insertSelective(TbProductCategory record) {
        return tbProductCategoryMapper.insertSelective(record);
    }

    @Override
    public TbProductCategory selectByPrimaryKey(Integer productCategoryId) {
        return tbProductCategoryMapper.selectByPrimaryKey(productCategoryId);
    }

    @Override
    public int updateByPrimaryKeySelective(TbProductCategory record) {
        return tbProductCategoryMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TbProductCategory record) {
        return tbProductCategoryMapper.updateByPrimaryKey(record);
    }

}

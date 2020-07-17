package com.example.o2o.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.o2o.mapper.TbProductMapper;
import com.example.o2o.domain.TbProduct;
import com.example.o2o.service.TbProductService;
@Service
public class TbProductServiceImpl implements TbProductService{

    @Resource
    private TbProductMapper tbProductMapper;

    @Override
    public int deleteByPrimaryKey(Integer productId) {
        return tbProductMapper.deleteByPrimaryKey(productId);
    }

    @Override
    public int insert(TbProduct record) {
        return tbProductMapper.insert(record);
    }

    @Override
    public int insertSelective(TbProduct record) {
        return tbProductMapper.insertSelective(record);
    }

    @Override
    public TbProduct selectByPrimaryKey(Integer productId) {
        return tbProductMapper.selectByPrimaryKey(productId);
    }

    @Override
    public int updateByPrimaryKeySelective(TbProduct record) {
        return tbProductMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TbProduct record) {
        return tbProductMapper.updateByPrimaryKey(record);
    }

}

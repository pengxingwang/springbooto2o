package com.example.o2o.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.o2o.domain.TbShopCategory;
import com.example.o2o.mapper.TbShopCategoryMapper;
import com.example.o2o.service.TbShopCategoryService;

import java.util.List;

@Service
public class TbShopCategoryServiceImpl implements TbShopCategoryService{

    @Resource
    private TbShopCategoryMapper tbShopCategoryMapper;

    @Override
    public int deleteByPrimaryKey(Integer shopCategoryId) {
        return tbShopCategoryMapper.deleteByPrimaryKey(shopCategoryId);
    }

    @Override
    public int insert(TbShopCategory record) {
        return tbShopCategoryMapper.insert(record);
    }

    @Override
    public int insertSelective(TbShopCategory record) {
        return tbShopCategoryMapper.insertSelective(record);
    }

    @Override
    public TbShopCategory selectByPrimaryKey(Integer shopCategoryId) {
        return tbShopCategoryMapper.selectByPrimaryKey(shopCategoryId);
    }

    @Override
    public int updateByPrimaryKeySelective(TbShopCategory record) {
        return tbShopCategoryMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TbShopCategory record) {
        return tbShopCategoryMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<TbShopCategory> findByParentIdOrderByPriorityDesc(Integer parentId) {
        return tbShopCategoryMapper.findByParentIdOrderByPriorityDesc(parentId);
    }
}

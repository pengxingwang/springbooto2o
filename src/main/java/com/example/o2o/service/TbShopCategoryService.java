package com.example.o2o.service;

import com.example.o2o.domain.TbShopCategory;

import java.util.List;

public interface TbShopCategoryService{


    int deleteByPrimaryKey(Integer shopCategoryId);

    int insert(TbShopCategory record);

    int insertSelective(TbShopCategory record);

    TbShopCategory selectByPrimaryKey(Integer shopCategoryId);

    int updateByPrimaryKeySelective(TbShopCategory record);

    int updateByPrimaryKey(TbShopCategory record);

    public List<TbShopCategory> findByParentIdOrderByPriorityDesc(Integer parentId);
}

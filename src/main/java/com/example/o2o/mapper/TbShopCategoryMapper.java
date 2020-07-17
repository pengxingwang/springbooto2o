package com.example.o2o.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.time.LocalDateTime;

import com.example.o2o.domain.TbShopCategory;

public interface TbShopCategoryMapper {
    int deleteByPrimaryKey(Integer shopCategoryId);

    int insert(TbShopCategory record);

    int insertSelective(TbShopCategory record);

    TbShopCategory selectByPrimaryKey(Integer shopCategoryId);

    int updateByPrimaryKeySelective(TbShopCategory record);

    int updateByPrimaryKey(TbShopCategory record);


    List<TbShopCategory> findByParentIdOrderByPriorityDesc(@Param("parentId")Integer parentId);



}
package com.example.o2o.service.impl;

import com.example.o2o.dto.ShopExecution;
import com.example.o2o.enums.ShopStateEnum;
import com.example.o2o.exception.ShopOperationException;
import com.example.o2o.util.ImageUtil;
import com.example.o2o.util.ImageUtil1;
import com.example.o2o.util.PathUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.o2o.domain.TbShop;
import com.example.o2o.mapper.TbShopMapper;
import com.example.o2o.service.TbShopService;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class TbShopServiceImpl implements TbShopService{

    @Resource
    private TbShopMapper tbShopMapper;

    @Override
    public int deleteByPrimaryKey(Integer shopId) {
        return tbShopMapper.deleteByPrimaryKey(shopId);
    }

    @Override
    public int insert(TbShop record) {
        return tbShopMapper.insert(record);
    }

    @Override
    public int insertSelective(TbShop record) {
        return tbShopMapper.insertSelective(record);
    }

    @Override
    public TbShop selectByPrimaryKey(Integer shopId) {
        return tbShopMapper.selectByPrimaryKey(shopId);
    }

    @Override
    public int updateByPrimaryKeySelective(TbShop record) {
        return tbShopMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TbShop record) {
        return tbShopMapper.updateByPrimaryKey(record);
    }

    /**
     * 添加店铺
     * @param shop
     * @return
     */
    @Override
    @Transactional
    public ShopExecution addShop(TbShop shop) {
        // 判断条件
        if(shop == null){
           return new ShopExecution(ShopStateEnum.NULL_SHOP);
        }

        // 更新店铺信息
        shop.setEnableStatus(0);
        shop.setLastEditTime(LocalDateTime.now());
        shop.setCreateTime(LocalDateTime.now());
        int insert = tbShopMapper.insert(shop);
        if(insert < 1){
            // 插入失败
            throw new ShopOperationException( "创建店铺失败", -1);
        }
        return new ShopExecution(ShopStateEnum.CHECK, shop);
    }

    @Override
    public List<TbShop> list(TbShop tbShop) {
        return tbShopMapper.findByAllOrderByPriority(tbShop);
    }

}

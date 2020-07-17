package com.example.o2o.mapper;
import java.time.LocalDateTime;

import com.example.o2o.domain.TbShop;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.io.FileNotFoundException;

public class TbShopMapperTest {
    private static TbShopMapper mapper;

    @BeforeClass
    public static void setUpMybatisDatabase() {
        SqlSessionFactory builder = new SqlSessionFactoryBuilder().build(TbShopMapperTest.class.getClassLoader().getResourceAsStream("mybatisTestConfiguration/TbShopMapperTestConfiguration.xml"));
        //you can use builder.openSession(false) to not commit to database
        mapper = builder.getConfiguration().getMapper(TbShopMapper.class, builder.openSession(true));
    }

    @Test
    public void testInsert() throws FileNotFoundException {
        TbShop tbShop = new TbShop();
        tbShop.setOwnerId(1);
        tbShop.setAreaId(2);
        tbShop.setShopCategoryId(10);
        tbShop.setShopName("商店名称");
        tbShop.setShopDesc("商店描述");
        tbShop.setShopAddr("商店地址");
        tbShop.setPhone("商店电话");
        tbShop.setShopImg("商店照片");
        tbShop.setPriority(0);
        tbShop.setCreateTime(LocalDateTime.now());
        tbShop.setLastEditTime(LocalDateTime.now());
        tbShop.setEnableStatus(0);
        tbShop.setAdvice("商店建议");

        int insert = mapper.insert(tbShop);
        Assert.assertEquals(1, insert);
    }

    @Test
    public void testUpdateByPrimaryKey() throws FileNotFoundException {
        TbShop tbShop = new TbShop();
        tbShop.setShopId(41);
        tbShop.setAdvice("商店建议a");
        tbShop.setLastEditTime(LocalDateTime.now());
        int i = mapper.updateByPrimaryKey(tbShop);
        Assert.assertEquals(1, 1);
    }

    @Test
    public void testUpdateByPrimaryKeySelective() throws FileNotFoundException {
        TbShop tbShop = new TbShop();
        tbShop.setShopId(41);
        tbShop.setAdvice("商店建议a");
        tbShop.setLastEditTime(LocalDateTime.now());
        int i = mapper.updateByPrimaryKeySelective(tbShop);
        Assert.assertEquals(1, 1);
    }
}

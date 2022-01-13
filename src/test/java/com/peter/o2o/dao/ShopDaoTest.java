package com.peter.o2o.dao;

import com.peter.o2o.BaseTest;
import com.peter.o2o.entity.Area;
import com.peter.o2o.entity.PersonInfo;
import com.peter.o2o.entity.Shop;
import com.peter.o2o.entity.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class ShopDaoTest extends BaseTest {
    @Autowired
    private ShopDao shopDao;

    @Test
    public void testInsertShop() {
        Shop shop = new Shop();
        PersonInfo owner = new PersonInfo();
        Area area = new Area();
        ShopCategory shopCategory = new ShopCategory();
        owner.setUserId(1L);
        area.setAreaId(2);
        shopCategory.setShopCategoryId(1L);
        shop.setOwner(owner);
        shop.setArea(area);
        shop.setShopCategory(shopCategory);
        shop.setShopName("mytest1");
        shop.setShopDesc("mytest1");
        shop.setShopAddr("testaddr1");
        shop.setPhone("13810524526");
        shop.setShopImg("test1");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(1);
        shop.setAdvice("审核中");
        int num = shopDao.insertShop(shop);
        assertEquals(1, num);
    }

    @Test
    public void testUpdateShop() {
        Shop shop = new Shop();
        shop.setShopId(1L);

        shop.setShopAddr("测试地址2");

        shop.setCreateTime(new Date());

        int num = shopDao.updateShop(shop);
        assertEquals(1, num);
    }

    @Test
    public void testQueryByShopId() {
        long shopId = 1;
        Shop shop = shopDao.queryByShopId(shopId);
        System.out.println(shop.getArea().getAreaName());
    }
}


package com.peter.o2o.service;

import com.peter.o2o.BaseTest;
import com.peter.o2o.dto.ShopExecution;
import com.peter.o2o.entity.Area;
import com.peter.o2o.entity.PersonInfo;
import com.peter.o2o.entity.Shop;
import com.peter.o2o.entity.ShopCategory;
import com.peter.o2o.enums.ShopStateEnum;
import com.peter.o2o.exception.ShopOperationException;
import org.junit.Test;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

import static junit.framework.TestCase.assertEquals;


public class ShopServiceTest extends BaseTest {
    @Resource
    private ShopService shopService;

//    @Test
//    public void testAddShop() throws Exception {
//        Shop shop = new Shop();
//        shop.setOwnerId(1L);
//        Area area = new Area();
//        area.setAreaId(1);
//        ShopCategory sc = new ShopCategory();
//        sc.setShopCategoryId(1L);
//        shop.setShopName("mytest1");
//        shop.setShopDesc("mytest1");
//        shop.setShopAddr("testaddr1");
//        shop.setPhone("13810524526");
//        shop.setShopImg("test1");
//        shop.setLongitude(1D);
//        shop.setLatitude(1D);
//        shop.setCreateTime(new Date());
//        shop.setLastEditTime(new Date());
//        shop.setEnableStatus(0);
//        shop.setAdvice("审核中");
//        shop.setArea(area);
//        shop.setShopCategory(sc);
//    }

    @Test
    public void testModifyShop() throws ShopOperationException, FileNotFoundException {
        Shop shop = new Shop();
        shop.setShopId(1L);
        shop.setShopName("修改后的");
        File shopImg = new File("C:\\Users\\Peter\\Desktop\\示意图.jpg");
        InputStream inputStream = new FileInputStream(shopImg);
        ShopExecution shopExecution = shopService.modifyShop(shop, inputStream, "watermark.jpg");
        System.out.println(shopExecution.getShop().getShopImg());
    }

    @Test
    public void testGetShopList() {
        Shop shop = new Shop();
        ShopCategory shopCategory = new ShopCategory();
        shopCategory.setShopCategoryId(1l);
        shop.setShopCategory(shopCategory);
        ShopExecution se = shopService.getShopList(shop, 0, 2);
        System.out.println(se.getShopList().size());
    }
}

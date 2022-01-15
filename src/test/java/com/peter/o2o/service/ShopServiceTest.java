package com.peter.o2o.service;

import com.peter.o2o.BaseTest;
import com.peter.o2o.dto.ShopExecution;
import com.peter.o2o.entity.Area;
import com.peter.o2o.entity.PersonInfo;
import com.peter.o2o.entity.Shop;
import com.peter.o2o.entity.ShopCategory;
import com.peter.o2o.enums.ShopStateEnum;
import com.peter.o2o.exception.ShopOperationException;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import java.io.*;
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
    public void testModifyShop() throws IOException {
        Shop shop = new Shop();
        shop.setShopId(1L);
        shop.setShopName("修改店铺测试");
        String filePath = "D:\\luffy.jpg";
        shopService.modifyShop(shop, path2MultipartFile(filePath));
        System.out.println("修改后图片：" + shop.getShopImg());
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

    @Test
    public void testAddShop() throws IOException {
        Shop shop = new Shop();
        PersonInfo owner = new PersonInfo();
        ShopCategory shopCategory = new ShopCategory();
        Area area = new Area();
        owner.setUserId(1L);
        area.setAreaId(1);
        shopCategory.setShopCategoryId(1L);
        shop.setOwner(owner);
        shop.setShopCategory(shopCategory);
        shop.setArea(area);
        shop.setShopAddr("testService");
        shop.setShopName("test店铺Service");
        shop.setShopDesc("testService");
        shop.setShopImg("testService");
        shop.setPhone("testService");
        shop.setPriority(1);
        shop.setCreateTime(new Date());
        shop.setAdvice("审核中");
        String filePath = "D:\\soft\\luffy.jpg";
        ShopExecution se = shopService.addShop(shop, path2MultipartFile(filePath));
        System.out.println("ShopExecution.state" + se.getState());
        System.out.println("ShopExecution.stateInfo" + se.getStateInfo());
    }

    /**
     * filePath to MultipartFile
     *
     * @param filePath
     * @throws IOException
     */
    private MultipartFile path2MultipartFile(String filePath) throws IOException {
        File file = new File(filePath);
        FileInputStream input = new FileInputStream(file);
        MultipartFile multipartFile = new MockMultipartFile("file", file.getName(), "text/plain",
                IOUtils.toByteArray(input));
        return multipartFile;
    }
}

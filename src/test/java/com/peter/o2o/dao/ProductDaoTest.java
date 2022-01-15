package com.peter.o2o.dao;

import com.peter.o2o.BaseTest;
import com.peter.o2o.entity.Product;
import com.peter.o2o.entity.ProductCategory;
import com.peter.o2o.entity.Shop;
import com.peter.o2o.enums.EnableStatusEnum;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * @Description: 商品测试
 * @author: peter
 * @date: 2018年10月27日
 */
public class ProductDaoTest extends BaseTest {

    @Autowired
    private ProductDao productDao;

    @Test
    public void testInsertProduct() {
        Shop shop = new Shop();
        shop.setShopId(1L);
        ProductCategory productCategory = new ProductCategory();
        productCategory.setProductCategoryId(1L);
        Product product = new Product();
        product.setCreateTime(new Date());
        product.setEnableStatus(EnableStatusEnum.AVAILABLE.getState());
        product.setProductName("1");
        product.setProductDesc("11");
        product.setImgAddr("111");
        product.setNormalPrice("1111");
        product.setPromotionPrice("11111");
        product.setPriority(1);
        product.setProductCategory(productCategory);
        product.setShop(shop);
        int effectNum = productDao.insertProduct(product);
        System.out.println("effectNum:" + effectNum);
    }


}

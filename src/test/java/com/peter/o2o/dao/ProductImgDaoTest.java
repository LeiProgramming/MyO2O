package com.peter.o2o.dao;

import com.peter.o2o.BaseTest;
import com.peter.o2o.entity.ProductImg;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description: 商品图片测试
 * @author: peter
 * @date: 2018年10月27日
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductImgDaoTest extends BaseTest {

    @Autowired
    private ProductImgDao productImgDao;

    @Test
    public void testBatchInsertProductImg() {
        // 在productId为1的商品中添加两个图片记录
        ProductImg productImg1 = new ProductImg();
        productImg1.setCreateTime(new Date());
        productImg1.setImgAddr("图片1");
        productImg1.setImgDesc("测试图片1");
        productImg1.setPriority(1);
        productImg1.setProductId(1L);
        ProductImg productImg2 = new ProductImg();
        productImg2.setCreateTime(new Date());
        productImg2.setImgAddr("图片2");
        productImg2.setImgDesc("测试图片2");
        productImg2.setPriority(2);
        productImg2.setProductId(1L);
        List<ProductImg> productImgs = new ArrayList<>();
        productImgs.add(productImg1);
        productImgs.add(productImg2);
        int effectNum = productImgDao.batchInsertProductImg(productImgs);
        System.out.println("effectNum:" + effectNum);
    }

    @Test
    public void testDeleteProductImgByProductId() throws Exception {
        // 删除商品详情记录
        Long productId = 1L;
        int effectNum = productImgDao.deleteProductImgByProductId(productId);
        System.out.println("effectNum:" + effectNum);
    }

}

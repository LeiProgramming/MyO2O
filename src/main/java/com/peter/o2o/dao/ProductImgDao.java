package com.peter.o2o.dao;

import com.peter.o2o.entity.ProductImg;

import java.util.List;

/**
 * @Description: 商品图片数据接口
 * @author: tyron
 * @date: 2018年10月27日
 */

public interface ProductImgDao {

    /**
     * 批量插入商品图片
     *
     * @param productImgList 商品图片列表
     * @return
     */

    int batchInsertProductImg(List<ProductImg> productImgList);

    /**
     * 根据商品Id删除商品详情图
     *
     * @param productId
     * @return
     */
    int deleteProductImgByProductId(Long productId);

    /**
     * 根据商品Id获取商品详情图列表
     *
     * @param productId
     * @return
     */
    List<ProductImg> selectProductImgListByProductId(long productId);
}

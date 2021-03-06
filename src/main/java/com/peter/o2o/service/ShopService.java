package com.peter.o2o.service;

import com.peter.o2o.dto.ShopExecution;
import com.peter.o2o.entity.Shop;
import com.peter.o2o.exception.ShopOperationException;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

public interface ShopService {
    /**
     * 根据shopCondition返回对应店铺列表
     *
     * @param shopCondition
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public ShopExecution getShopList(Shop shopCondition, int pageIndex, int pageSize);

    /**
     * 通过店铺Id获取店铺信息
     *
     * @param shopId
     * @return
     */
    Shop getByShopId(long shopId);

    /**
     * 更新店铺信息，包括对图片的处理
     *
     * @param shop
     * @param
     * @return
     * @throws ShopOperationException
     */
    ShopExecution modifyShop(Shop shop, MultipartFile shopImg) throws ShopOperationException;


    ShopExecution addShop(Shop shop, MultipartFile shopImg) throws ShopOperationException;

}

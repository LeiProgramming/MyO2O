package com.peter.o2o.service.impl;

import com.peter.o2o.dao.ShopDao;
import com.peter.o2o.dto.ShopExecution;
import com.peter.o2o.entity.Shop;
import com.peter.o2o.enums.ShopStateEnum;
import com.peter.o2o.exception.ShopOperationException;
import com.peter.o2o.service.ShopService;
import com.peter.o2o.util.ImageUtil;
import com.peter.o2o.util.PageCalculator;
import com.peter.o2o.util.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopDao shopDao;

    @Override
    public ShopExecution getShopList(Shop shopCondition, int pageIndex, int pageSize) {
        int rowIndex = PageCalculator.calculateRowIndex(pageIndex, pageSize);
        List<Shop> shopList = shopDao.queryShopList(shopCondition, rowIndex, pageSize);
        int count = shopDao.queryShopCount(shopCondition);
        ShopExecution se = new ShopExecution();
        if (shopList != null) {
            se.setShopList(shopList);
            se.setCount(count);
        } else {
            se.setState(ShopStateEnum.INNER_ERROR.getState());
        }
        return se;
    }

    @Override
    public Shop getByShopId(long shopId) {
        return shopDao.queryByShopId(shopId);
    }

    @Override
    @Transactional
    public ShopExecution modifyShop(Shop shop, MultipartFile shopImg) throws ShopOperationException {
        if (shop == null || shop.getShopId() == null) {
            return new ShopExecution(ShopStateEnum.NULL_SHOP);
        } else {
            try {
                //1.判断是否需要处理图片
                // 判断是否要处理照片
                if (shopImg != null) {
                    Shop tempShop = shopDao.queryByShopId(shop.getShopId());
                    if (tempShop.getShopImg() != null) {
                        // 删除原先图片
                        ImageUtil.deleteFileOrPath(tempShop.getShopImg());
                    }
                    // 添加新照片
                    addShopImg(shop, shopImg);
                }
                //2.更新店铺信息
                shop.setLastEditTime(new Date());
                int effectedNum = shopDao.updateShop(shop);
                if (effectedNum <= 0) {
                    return new ShopExecution(ShopStateEnum.INNER_ERROR);
                } else {
                    shop = shopDao.queryByShopId(shop.getShopId());
                    return new ShopExecution(ShopStateEnum.SUCCESS);
                }
            } catch (Exception e) {
                throw new ShopOperationException("modifyShop error." + e.getMessage());
            }
        }

    }

    @Override
    @Transactional
    public ShopExecution addShop(Shop shop, MultipartFile shopImg) {
        // 空值判断
        if (shop == null) {
            return new ShopExecution(ShopStateEnum.NULL_SHOP);
        } else {
            try {
                // 初始化赋值
                shop.setCreateTime(new Date());
                shop.setEnableStatus(ShopStateEnum.SUCCESS.getState());
                // 添加店铺信息
                int effectedNum = shopDao.insertShop(shop);
                // 添加店铺失败
                if (effectedNum <= 0) {
                    return new ShopExecution(ShopStateEnum.INNER_ERROR);
                } else {
                    try {
                        // 空值判断
                        if (shopImg == null) {
                            return new ShopExecution(ShopStateEnum.INNER_ERROR);
                        } else {
                            // 存储图片
                            addShopImg(shop, shopImg);
                            effectedNum = shopDao.updateShop(shop);
                            if (effectedNum <= 0) {
                                return new ShopExecution(ShopStateEnum.INNER_ERROR);
                            }
                        }
                    } catch (Exception e) {
                        throw new ShopOperationException("addShop error." + e.getMessage());
                    }
                }
            } catch (Exception e) {
                throw new ShopOperationException("addShop error." + e.getMessage());
            }
            return new ShopExecution(ShopStateEnum.CHECK, shop);
        }
    }

    /**
     * 存储图片
     *
     * @param shop
     * @param shopImg
     */
    private void addShopImg(Shop shop, MultipartFile shopImg) {
        String dest = PathUtil.getShopImagePath(shop.getShopId());
        String shopImgAddr = ImageUtil.generateThumbnail(shopImg, dest);
        // 将图片路径存储用于更新店铺信息
        shop.setShopImg(shopImgAddr);
    }
}


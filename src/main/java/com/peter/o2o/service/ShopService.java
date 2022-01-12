package com.peter.o2o.service;

import com.peter.o2o.dto.ShopExecution;
import com.peter.o2o.entity.Shop;
import com.peter.o2o.exception.ShopOperationException;

import java.io.InputStream;

public interface ShopService {
    ShopExecution addShop(Shop shop, InputStream shopImgInputStream, String fileName) throws ShopOperationException;

}

package com.peter.o2o.service;

import com.peter.o2o.dto.ShopExecution;
import com.peter.o2o.entity.Shop;

import java.io.File;

public interface ShopService {
    ShopExecution addShop(Shop shop, File shopImg);

}

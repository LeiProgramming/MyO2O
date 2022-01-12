package com.peter.o2o.service;

import com.peter.o2o.dto.ShopExecution;
import com.peter.o2o.entity.Shop;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;

public interface ShopService {
    ShopExecution addShop(Shop shop, CommonsMultipartFile shopImg);

}

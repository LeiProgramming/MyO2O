package com.peter.o2o.web.superadmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "shopadmin", method = {RequestMethod.GET})
public class ShopAdminController {
    @RequestMapping(value = "/shopoperation")
    public String shopOperation() {
        return "shop/shopoperation";
    }

    @RequestMapping(value = "/shopmanagement")
    public String shopManagement() {
        return "shop/shopmanagement";
    }


    @RequestMapping(value = "/shoplist")
    public String shopList() {
        return "shop/shoplist";
    }
}

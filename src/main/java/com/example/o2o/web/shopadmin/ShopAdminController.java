package com.example.o2o.web.shopadmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 页面转发器，页面放WEB—INFO里访问不到，就不放里面了
 */
@Controller
@RequestMapping(value = "shopadmin")
public class ShopAdminController {

    @GetMapping("/shopoperation")
    public String shopOperation(){
        return "shop/shopoperation";
    }

    @GetMapping("/shoplist")
    public String shopList(){
        return "shop/shoplist";
    }

    @GetMapping("/productcategorymanagement")
    public String productCategoryManagement(){
        return "shop/productcategorymanagement";
    }

    @GetMapping("/shopmanagement")
    public String shopManagement(){
        return "shop/shopmanagement";
    }

}

package com.miracle.client;

import com.miracle.pojo.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @Author MaoWei
 * @Date 2019/7/24 19:31
 */
//FeignClient是对Ribbon的封装
@FeignClient(value = "PRODUCT-DATA-SERVICE")
//@Component
public interface ProductClientFeign {

    @GetMapping("/products")
    public List<Product> listProdcut();
}

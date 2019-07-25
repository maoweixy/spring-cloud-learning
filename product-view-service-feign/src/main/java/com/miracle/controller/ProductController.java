package com.miracle.controller;

import com.miracle.pojo.Product;
import com.miracle.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RefreshScope
public class ProductController {
	@Autowired
    private ProductService productService;
//	如果这里显示无法注入version，检查一下git配置文件名是否正确，文件名应该是此项目在spring里面application name+“-dev.properties”
//	在这里虽然maven项目名是ribbon，但是我实际用的技术是Feign，所以我在application.yml里面设置的application name为Feign
//	所以git配置文件名是：product-view-service-feign-dev.properties
    @Value("${version}")
    String version;
	
    @RequestMapping("/products")
    public Object products(Model m) {
    	List<Product> ps = productService.listProducts();
        m.addAttribute("version", version);
        m.addAttribute("ps", ps);
        return "products";
    }
}
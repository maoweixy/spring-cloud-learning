package com.miracle.client;

import com.miracle.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@Component
public class ProductClientRibbon {
    @Autowired
    private RestTemplate restTemplate;

	public List<Product> listProdcut() {
        return restTemplate.getForObject("http://PRODUCT-DATA-SERVICE/products", List.class);
    }

}

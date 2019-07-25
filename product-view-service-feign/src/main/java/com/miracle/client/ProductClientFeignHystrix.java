package com.miracle.client;

import com.miracle.pojo.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author MaoWei
 * @Date 2019/7/25 17:27
 */
@Component
public class ProductClientFeignHystrix implements ProductClientFeign{
    @Override
    public List<Product> listProduct() {
        List<Product> result = new ArrayList<>();
        result.add(new Product(0,"产品数据微服务不可用",0));
        return result;
    }
}

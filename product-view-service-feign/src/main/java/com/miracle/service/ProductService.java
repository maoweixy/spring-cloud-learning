package com.miracle.service;

import com.miracle.client.ProductClientFeign;
import com.miracle.client.ProductClientRibbon;
import com.miracle.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
	//	@Autowired
//    private ProductClientRibbon productClientRibbon;
//	public List<Product> listProducts(){
//		return productClientRibbon.listProdcut();
//	}
	@Autowired
	private ProductClientFeign productClientFeign;
	public List<Product> listProducts(){
		return productClientFeign.listProdcut();
	}
}

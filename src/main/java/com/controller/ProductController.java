package com.controller;

import java.util.List;
import com.entity.Product;
import com.service.ProductService;

public class ProductController {
	ProductService service = new ProductService();
	
	public String save(Product product) {
		return service.save(product);
	}
	
	public Product getProductById(int id) {
		return service.getProductById(id);
	}
	
	public List<Product> getAllProduct(){
		return service.getAllProduct();
	}
	
	public String update(Product product) {
		return service.update(product);
	}
	public String delete(int id) {
		return service.delete(id);
	}
}

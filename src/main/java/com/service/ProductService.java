package com.service;

import java.util.List;

import com.dao.ProductDao;

import com.entity.Product;
import com.exception.ProductNotFoundException;

public class ProductService {
	
	ProductDao dao = new ProductDao();
	
	public String save(Product product) {
		return dao.save(product);
	}
	
	public Product getProductById(int id) {
		Product product = dao.getProductById(id);
		if(product==null) {
			throw new ProductNotFoundException("Product not Found");
		}
		return product;
	}
	
	public List<Product> getAllProduct(){
		List<Product> products = dao.getAllProduct();
		if(products.size()<1) {
			throw new ProductNotFoundException("Product Not Availabel into the Database");
		}
		return products;
	}
	
	public String update(Product product) {
		return dao.update(product);
	}
	
	public String delete(int id) {
		return dao.delete(id);
	}
}

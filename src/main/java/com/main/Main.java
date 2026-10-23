package com.main;

import java.util.*;
import com.controller.ProductController;
import com.entity.Product;

public class Main {
	
	public static void main(String args[]) {
		ProductController controller = new ProductController();
		
		Product product = new Product();

		product.setProductId(1);
		product.setProductName("Tabla");
		product.setUnitPrice(999.00);
		product.setAvailableQuantity(10);
		product.setProductDescription("Tabla size is small");
		product.setAvailabilityStatus(true);
		
//		Insert
		String msg = controller.save(product);
		System.out.println(msg);	
		
		
		
//		Get Product By Id
//		Product product = controller.getProductById(4);
//		System.out.println(product);
//		
		//Get All Product 
		
		try {
			List<Product> products = controller.getAllProduct();
			for(Product p : products) {
				System.out.println(p);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		//Update Product
//		String msg = controller.update(product);
//		System.out.println(msg);
	
	
		//Delete Product
//		String message = controller.delete(5);
//		System.out.println(message);
	
	}	
}

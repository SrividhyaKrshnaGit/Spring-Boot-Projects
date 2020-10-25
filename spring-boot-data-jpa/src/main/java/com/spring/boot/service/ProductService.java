package com.spring.boot.service;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.spring.boot.model.Product;

public interface ProductService {
	
	Product createProduct(Product product);
	Product updateProduct(Product product);
	List<Product> getAllProduct();
	Product getProductById(int id);
	void deleteProduct(int id);
}

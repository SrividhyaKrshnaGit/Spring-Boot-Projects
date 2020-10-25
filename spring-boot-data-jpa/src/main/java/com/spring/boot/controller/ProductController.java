package com.spring.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.model.Product;
import com.spring.boot.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService service;
	
	@GetMapping("/allProducts")
	public ResponseEntity<List<Product>> getAllProducts(){
		return ResponseEntity.ok().body(service.getAllProduct());
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable int id){
		return ResponseEntity.ok().body(service.getProductById(id));
	}
	
	@PostMapping("/createProduct")
	public ResponseEntity<Product> createProduct(@RequestBody Product product){
		return ResponseEntity.ok().body(service.createProduct(product));
	}
	
    @PutMapping("/updateProducts/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable int id,@RequestBody Product product) {
        product.setId(id);
    	return ResponseEntity.ok().body(service.updateProduct(product));
    }
    
    @DeleteMapping("/deleteProduct/{id}")
    public HttpStatus  deleteProduct(@PathVariable int id) {
    	service.deleteProduct(id);
    	return HttpStatus.OK;
    }
}

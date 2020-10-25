package com.spring.boot.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.exceptions.ResourceNotFoundException;
import com.spring.boot.model.Product;
import com.spring.boot.repository.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository productRepository;

	@Override
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product updateProduct(Product product) {
		Optional<Product> option = productRepository.findById(product.getId());
		if(option.isPresent()) {
			Product updateProduct = option.get();
			updateProduct.setId(product.getId());
			updateProduct.setName(product.getName());
			updateProduct.setPrice(product.getPrice());
			updateProduct.setDescription(product.getDescription());
			productRepository.save(updateProduct);
			return updateProduct;
		}
		else {
			throw new ResourceNotFoundException("The given product is not available " +product.getId());
		}
	}


	@Override
	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(int id) {
		Optional<Product> product = productRepository.findById(id);
		if(product.isPresent()) {
		 return product.get();
		}else {
			throw new ResourceNotFoundException("The given product is not available " + id);
		}
	}

	@Override
	public void deleteProduct(int id) {
		Optional<Product> product = productRepository.findById(id);
		if(product.isPresent()) {
		 productRepository.delete(product.get());
	    }
		else {
			throw new ResourceNotFoundException("The given product is not available " + id);
		}
	}
}

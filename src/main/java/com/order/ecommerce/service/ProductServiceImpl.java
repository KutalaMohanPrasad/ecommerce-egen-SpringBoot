package com.order.ecommerce.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.ecommerce.dto.ProductDto;
import com.order.ecommerce.model.Product;
import com.order.ecommerce.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	public ProductRepository productRepository;

	public Product createProduct(ProductDto productDto) {
		// log.info("Creating Product with productId {}", productDto.productId)
		return productRepository.save(toProductEntity(productDto));

	}

	public Product getProduct(String productId) {
		// log.info("Get Product by productId {}", productId)
		return productRepository.findById(productId).orElseThrow();

	}

	public Product toProductEntity(ProductDto productDto) {
		Product product = new Product();
		product.setProductId(productDto.getProductId());
		product.setSku(productDto.getSku());
		product.setTitle(productDto.getTitle());
		product.setDescription(productDto.getDescription());
		product.setPrice(productDto.getPrice());
		product.setCreatedAt(LocalDate.now());
		product.setOrderItems(null);
		return product;
	}
}

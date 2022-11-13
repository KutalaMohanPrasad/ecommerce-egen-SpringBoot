package com.order.ecommerce.service;

import com.order.ecommerce.dto.ProductDto;
import com.order.ecommerce.model.Product;

public interface ProductService {
	public Product createProduct(ProductDto productDto);
	
	public Product getProduct(String productId);
}

/**
 * 
 */
package com.order.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.ecommerce.dto.ProductDto;
import com.order.ecommerce.model.Product;
import com.order.ecommerce.service.ProductService;

/**
 * @author Mohan
 *
 */

@RestController
@RequestMapping("/api/v1")
public class ProductController {
	@Autowired
	public ProductService productService;

	@PostMapping("/products")
	@ManagedOperation(description = "Create a product")
	public Product createOrder(@RequestBody ProductDto productDto) {
		return productService.createProduct(productDto);
	}

	@GetMapping("/products/{productId}")
	@ManagedOperation(description = "Get a product")
	public Product getProduct(@PathVariable(name = "productId") String productId) {
		return productService.getProduct(productId);
	}
}

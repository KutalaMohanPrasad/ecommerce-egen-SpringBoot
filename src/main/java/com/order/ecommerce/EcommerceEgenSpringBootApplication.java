package com.order.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = { "com.order.ecommerce", "com.order.ecommerce.repository" })
@EnableSwagger2
public class EcommerceEgenSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceEgenSpringBootApplication.class, args);
	}

}

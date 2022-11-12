/**
 * 
 */
package com.order.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.order.ecommerce.dto.OrderCreateResponse;
import com.order.ecommerce.dto.OrderDto;
import com.order.ecommerce.dto.OrderResponse;
import com.order.ecommerce.service.OrderService;

/**
 * @author Mohan
 *
 */
@RestController
@RequestMapping("/api/v1")
public class OrderController {

	@Autowired
	public OrderService orderService;

	@PostMapping("/orders")
	@ManagedOperation(description = "Create an order")
	public OrderCreateResponse createOrder(@RequestBody OrderDto orderDto) {
		return orderService.createOrder(orderDto);
	}

	@GetMapping("/orders/{orderId}")
	public OrderResponse findOrderById(@PathVariable(name = "orderId") String orderId) {
		
		OrderResponse obj=orderService.findOrderById(orderId);
		System.out.println(obj.toString());
		return obj;
	}

	@PatchMapping("/orders/{orderId}")
	public String updateOrderStatus(@PathVariable("orderId") String orderId,
			@RequestParam(name = "orderStatus") String orderStatus) {
		return orderService.updateOrderStatus(orderId, orderStatus);
	}
}

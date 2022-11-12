package com.order.ecommerce.service;

import com.order.ecommerce.dto.OrderCreateResponse;
import com.order.ecommerce.dto.OrderDto;
import com.order.ecommerce.dto.OrderResponse;
import com.order.ecommerce.model.Order;

public interface OrderService {
	public String updateOrderStatus(String orderId, String orderStatus);
	
	public OrderResponse findOrderById(String orderId);
	
	public OrderCreateResponse createOrder(OrderDto orderDto);

	
	
}

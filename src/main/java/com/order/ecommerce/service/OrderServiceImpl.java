package com.order.ecommerce.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.ecommerce.dto.OrderCreateResponse;
import com.order.ecommerce.dto.OrderDto;
import com.order.ecommerce.dto.OrderResponse;
import com.order.ecommerce.enums.OrderStatus;
import com.order.ecommerce.mapper.OrderDetailsMapper;
import com.order.ecommerce.model.Order;
import com.order.ecommerce.model.OrderItem;
import com.order.ecommerce.repository.OrderItemRepository;
import com.order.ecommerce.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private OrderDetailsMapper orderDetailsMapper;
	@Autowired
	private OrderItemRepository orderItemRepository;

	public String updateOrderStatus(String orderId, String orderStatus) {
		Order order = orderRepository.findById(orderId).orElseThrow();
		// order.orderStatus = orderStatus;
		order.setOrderStatus(orderStatus);
		
		return orderRepository.save(order).getOrderStatus();
		
	}

	public OrderResponse findOrderById(String orderId) {
		// Always return a dto - Need to map entity to dto to get all fields
		//System.out.println(orderRepository.findById(orderId).get().getCustomerId());
		return createOrderResponse(orderRepository.findById(orderId).get());
	}

	@Transactional
	public OrderCreateResponse createOrder(OrderDto orderDto) {
		// log.info("Creating Order for customer {}", orderDto.customerId)
		Order savedOrder = orderRepository.save(this.orderDto_toOrderEntity(UUID.randomUUID().toString(), orderDto));

		List<OrderItem> orderItemList = orderDetailsMapper.buildOrderItems(orderDto.getOrderItems(),
				savedOrder.getOrderId());
		orderItemRepository.saveAll(orderItemList);
		// Always return a dto - Need to map entity to dto
		OrderCreateResponse orderCreateResponse=new OrderCreateResponse();
		orderCreateResponse.setOrderId(savedOrder.getOrderId());
		orderCreateResponse.setOrderStatus(savedOrder.getOrderStatus());
		return orderCreateResponse;

	}

	public Order orderDto_toOrderEntity(String orderId, OrderDto orderDto) {
		Order order = new Order();

		order.setOrderId(orderId);
		order.setOrderStatus(OrderStatus.PROCESSING.toString());
		order.setCustomerId(orderDto.getCustomerId());
		order.setSubTotal(orderDto.getSubTotal());
		order.setTotalAmt(orderDto.getTotalAmt());
		order.setTax(orderDto.getTax());
		order.setShippingCharges(orderDto.getShippingCharges());
		order.setTitle(orderDto.getTitle());
		order.setShippingMode(orderDto.getShippingMode());
		order.setOrderItems(null);
		order.setCreatedAt(LocalDateTime.now());
		order.setPayment(orderDetailsMapper.buildAndLoadPayment(orderDto.getAmount(), orderDto.getPaymentMode()));
		order.setShippingAddress(orderDetailsMapper.buildAndLoadAddress(orderDto.getShippingAddress()));
		order.setBillingAddress(orderDetailsMapper.buildAndLoadAddress(orderDto.getBillingAddress()));

		return order;
	}
	
	public OrderResponse createOrderResponse(Order order) {
		OrderResponse orderResponse=new OrderResponse();
		
		orderResponse.setOrderId(order.getOrderId());
		orderResponse.setOrderStatus(OrderStatus.PROCESSING.toString());
		orderResponse.setCustomerId(order.getCustomerId());
		orderResponse.setSubTotal(order.getSubTotal());
		orderResponse.setTotalAmt(order.getTotalAmt());
		orderResponse.setTax(order.getTax());
		orderResponse.setShippingCharges(order.getShippingCharges());
		orderResponse.setTitle(order.getTitle());
		orderResponse.setShippingMode(order.getShippingMode());
		orderResponse.setOrderItems(null);
		orderResponse.setCreatedAt(LocalDateTime.now());
		orderResponse.setPayment(order.getPayment());
		orderResponse.setShippingAddress(order.getShippingAddress());
		orderResponse.setBillingAddress(order.getBillingAddress());

		
		return orderResponse;
	}

	
}

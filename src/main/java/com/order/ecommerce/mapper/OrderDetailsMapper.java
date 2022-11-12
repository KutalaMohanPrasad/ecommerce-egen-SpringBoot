package com.order.ecommerce.mapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.order.ecommerce.dto.AddressDto;
import com.order.ecommerce.dto.OrderItemDto;
import com.order.ecommerce.enums.PaymentStatus;
import com.order.ecommerce.model.Address;
import com.order.ecommerce.model.OrderItem;
import com.order.ecommerce.model.OrderItemPk;
import com.order.ecommerce.model.Payment;
import com.order.ecommerce.repository.AddressRepository;
import com.order.ecommerce.repository.OrderItemRepository;
import com.order.ecommerce.repository.PaymentRepository;

@Component
public class OrderDetailsMapper {
	@Autowired
	private OrderItemRepository orderItemRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private PaymentRepository paymentRepository;

	public Payment buildAndLoadPayment(Double amount, String paymentMode) {
		Payment payment = new Payment();
		payment.setPaymentId(UUID.randomUUID().toString());
		payment.setAmount(amount);
		payment.setPaymentMode(paymentMode);
		payment.setConfirmationNumber(UUID.randomUUID().toString());
		payment.setPaymentStatus(PaymentStatus.PROCESSING.toString());
		payment.setCreatedAt(LocalDate.now());
		payment.setOrder(null);
		paymentRepository.save(payment);
		return payment;
	}

	public Address buildAndLoadAddress(AddressDto addressDto) {
		Address addressEntity = new Address();
		addressEntity.setAddressId(UUID.randomUUID().toString());
		addressEntity.setAddress1(addressDto.getAddress1());
		addressEntity.setAddress2(addressDto.getAddress2());
		addressEntity.setCity(addressDto.getCity());
		addressEntity.setState(addressDto.getState());
		addressEntity.setEmail(addressDto.getEmail());
		addressEntity.setPhone(addressDto.getPhone());
		addressEntity.setZip(addressDto.getZip());
		addressEntity.setOrder(null);
		addressEntity.setCreatedAt(LocalDate.now());
		return addressRepository.save(addressEntity);
	}

	public List<OrderItem> buildOrderItems(List<OrderItemDto> orderItemsDtoList, String orderId) {
		List<OrderItem> orderItemList = new ArrayList<>();

		for (OrderItemDto orderItemDto : orderItemsDtoList) {
			OrderItemPk orderItemPk = new OrderItemPk();
			orderItemPk.setProductId(orderItemDto.getProductId());
			orderItemPk.setOrderId(orderId);
			OrderItem orderItem = new OrderItem();
			orderItem.setOrderItemPk(orderItemPk);
			orderItem.setOrder(null);
			orderItem.setProduct(null);
			orderItem.setQuantity(orderItemDto.getQuantity());
			orderItemList.add(orderItem);
		}
		return (List<OrderItem>) orderItemRepository.saveAll(orderItemList);
	}

}

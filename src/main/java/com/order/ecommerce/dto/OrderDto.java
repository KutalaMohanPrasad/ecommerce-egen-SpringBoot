package com.order.ecommerce.dto;

import java.util.List;

import org.springframework.lang.NonNull;

public class OrderDto {
	@NonNull
	private String customerId;
	@NonNull
	private Double subTotal;
	@NonNull
	private Double totalAmt;
	@NonNull
	private Double tax;
	@NonNull
	private Double shippingCharges;
	@NonNull
	private String title;
	@NonNull
	private String shippingMode;

	@NonNull
	Double amount;

	/**
	 * @return the customerId
	 */
	public String getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the subTotal
	 */
	public Double getSubTotal() {
		return subTotal;
	}

	/**
	 * @param subTotal the subTotal to set
	 */
	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}

	/**
	 * @return the totalAmt
	 */
	public Double getTotalAmt() {
		return totalAmt;
	}

	/**
	 * @param totalAmt the totalAmt to set
	 */
	public void setTotalAmt(Double totalAmt) {
		this.totalAmt = totalAmt;
	}

	/**
	 * @return the tax
	 */
	public Double getTax() {
		return tax;
	}

	/**
	 * @param tax the tax to set
	 */
	public void setTax(Double tax) {
		this.tax = tax;
	}

	/**
	 * @return the shippingCharges
	 */
	public Double getShippingCharges() {
		return shippingCharges;
	}

	/**
	 * @param shippingCharges the shippingCharges to set
	 */
	public void setShippingCharges(Double shippingCharges) {
		this.shippingCharges = shippingCharges;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the shippingMode
	 */
	public String getShippingMode() {
		return shippingMode;
	}

	/**
	 * @param shippingMode the shippingMode to set
	 */
	public void setShippingMode(String shippingMode) {
		this.shippingMode = shippingMode;
	}

	/**
	 * @return the amount
	 */
	public Double getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	/**
	 * @return the paymentMode
	 */
	public String getPaymentMode() {
		return paymentMode;
	}

	/**
	 * @param paymentMode the paymentMode to set
	 */
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	/**
	 * @return the billingAddress
	 */
	public AddressDto getBillingAddress() {
		return billingAddress;
	}

	/**
	 * @param billingAddress the billingAddress to set
	 */
	public void setBillingAddress(AddressDto billingAddress) {
		this.billingAddress = billingAddress;
	}

	/**
	 * @return the shippingAddress
	 */
	public AddressDto getShippingAddress() {
		return shippingAddress;
	}

	/**
	 * @param shippingAddress the shippingAddress to set
	 */
	public void setShippingAddress(AddressDto shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	/**
	 * @return the orderItems
	 */
	public List<OrderItemDto> getOrderItems() {
		return orderItems;
	}

	/**
	 * @param orderItems the orderItems to set
	 */
	public void setOrderItems(List<OrderItemDto> orderItems) {
		this.orderItems = orderItems;
	}

	@NonNull
	private String paymentMode;

	@NonNull
	private AddressDto billingAddress;
	@NonNull
	private AddressDto shippingAddress;

	@NonNull
	public List<OrderItemDto> orderItems;
}

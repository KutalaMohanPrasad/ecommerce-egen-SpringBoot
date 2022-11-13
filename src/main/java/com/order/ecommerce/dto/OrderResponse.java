package com.order.ecommerce.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.order.ecommerce.model.Address;
import com.order.ecommerce.model.OrderItem;
import com.order.ecommerce.model.Payment;
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderResponse  implements Serializable{
	private String orderId;

	private String orderStatus;

	private String customerId;

	private Double subTotal;

	private Double totalAmt;

	private Double tax;

	private Double shippingCharges;

	private String title;

	private String shippingMode;

	private LocalDateTime createdAt;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "payment_id", name = "payment_id")
	private Payment payment;

	@OneToOne
	@JoinColumn(referencedColumnName = "address_id", name = "billing_address_id")
	private Address billingAddress;

	@OneToOne
	@JoinColumn(referencedColumnName = "address_id", name = "shipping_address_id")
	private Address shippingAddress;

	@OneToMany(targetEntity = OrderItem.class, fetch = FetchType.LAZY, mappedBy = "order")
	@JsonBackReference
	private List<OrderItem> orderItems;

	@Override
	public String toString() {
		return "OrderResponse [orderId=" + orderId + ", orderStatus=" + orderStatus + ", customerId=" + customerId
				+ ", subTotal=" + subTotal + ", totalAmt=" + totalAmt + ", tax=" + tax + ", shippingCharges="
				+ shippingCharges + ", title=" + title + ", shippingMode=" + shippingMode + ", createdAt=" + createdAt
				+ ", payment=" + payment + ", billingAddress=" + billingAddress + ", shippingAddress=" + shippingAddress
				+ ", orderItems=" + orderItems + "]";
	}

	/**
	 * @return the orderId
	 */
	public String getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return the orderStatus
	 */
	public String getOrderStatus() {
		return orderStatus;
	}

	/**
	 * @param orderStatus the orderStatus to set
	 */
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

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
	 * @return the createdAt
	 */
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @return the payment
	 */
	public Payment getPayment() {
		return payment;
	}

	/**
	 * @param payment the payment to set
	 */
	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	/**
	 * @return the billingAddress
	 */
	public Address getBillingAddress() {
		return billingAddress;
	}

	/**
	 * @param billingAddress the billingAddress to set
	 */
	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	/**
	 * @return the shippingAddress
	 */
	public Address getShippingAddress() {
		return shippingAddress;
	}

	/**
	 * @param shippingAddress the shippingAddress to set
	 */
	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	/**
	 * @return the orderItems
	 */
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	/**
	 * @param orderItems the orderItems to set
	 */
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	
	
}

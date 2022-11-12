package com.order.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.order.ecommerce.model.OrderItem;
import com.order.ecommerce.model.OrderItemPk;
@Repository
public interface OrderItemRepository extends CrudRepository<OrderItem, OrderItemPk> {

}

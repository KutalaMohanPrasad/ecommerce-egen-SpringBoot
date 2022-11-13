package com.order.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.order.ecommerce.model.Address;
@Repository
public interface AddressRepository extends CrudRepository<Address, String> {

}

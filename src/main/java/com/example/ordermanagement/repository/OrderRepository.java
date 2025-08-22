package com.example.ordermanagement.repository;

import com.example.ordermanagement.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, String> {
}

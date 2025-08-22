package com.example.ordermanagement.service;

import com.example.ordermanagement.model.Order;
import com.example.ordermanagement.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Cacheable(value = "orders", key = "#id")
    public Optional<Order> getOrderById(String id) {
        return orderRepository.findById(id);
    }

    public Order createOrder(Order order) {
        order.setId(UUID.randomUUID().toString());
        return orderRepository.save(order);
    }

    @CacheEvict(value = "orders", key = "#id")
    public Order updateOrder(String id, Order order) {
        if (orderRepository.existsById(id)) {
            order.setId(id);
            return orderRepository.save(order);
        }
        return null; // Should throw exception
    }

    @CacheEvict(value = "orders", key = "#id")
    public void deleteOrder(String id) {
        orderRepository.deleteById(id);
    }
}
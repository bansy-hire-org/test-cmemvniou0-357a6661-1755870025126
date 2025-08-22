package com.example.ordermanagement;

import com.example.ordermanagement.model.Order;
import com.example.ordermanagement.repository.OrderRepository;
import com.example.ordermanagement.service.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService;

    @Test
    void testGetOrderById() {
        Order mockOrder = new Order();
        mockOrder.setId("123");
        mockOrder.setCustomerName("Test Customer");

        when(orderRepository.findById(anyString())).thenReturn(Optional.of(mockOrder));

        Optional<Order> order = orderService.getOrderById("123");

        assertEquals("Test Customer", order.get().getCustomerName());
    }
}

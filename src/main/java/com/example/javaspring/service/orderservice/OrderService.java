package com.example.javaspring.service.orderservice;

import com.example.javaspring.entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> allByUserId(Long userId);

    Order one(Long id);

    Order add(Order order);

    Order update(Order order, Long id);

    Order delete(Long id);
}

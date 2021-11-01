package com.example.javaspring.service.orderservice;

import com.example.javaspring.entity.Order;
import com.example.javaspring.repositories.OrderRepo;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.List;

@Log
@Service
public class OrderServiceImpl implements OrderService{

    private final OrderRepo repository;

    public OrderServiceImpl(OrderRepo repository) {
        this.repository = repository;
    }

    @Override
    public List<Order> allByUserId(Long userId) {
        try {
            return repository.findAllByUserId(userId);
        }catch (Exception exception){
            log.severe(exception.getMessage());
            return null;
        }

    }

    @Override
    public Order one(Long id) {
        try {
            return repository.getById(id);
        }catch (Exception exception){
            log.severe(exception.getMessage());
            return null;
        }
    }

    @Override
    public Order add(Order order) {
        if (order != null) {
            return repository.save(order);
        }
        return null;
    }

    @Override
    public Order update(Order order, Long id) {
        try {
            if (repository.findById(id).isPresent()){
                repository.update(order.getName(), order.getDescription(), order.getPrice(), id);
                return order;
            }
        }catch (Exception exception){
            log.severe(exception.getMessage());
            return null;
        }
        return null;
    }

    @Override
    public Order delete(Long id) {
        try {
            if (id != null){
                Order byId = repository.getById(id);
                repository.delete(byId);
                return byId;
            }
            return null;
        }catch (Exception exception){
            log.severe(exception.getMessage());
            return null;
        }
    }
}

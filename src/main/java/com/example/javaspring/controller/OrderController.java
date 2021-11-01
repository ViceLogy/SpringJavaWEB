package com.example.javaspring.controller;

import com.example.javaspring.dtoe.OrderDTO;
import com.example.javaspring.entity.Order;
import com.example.javaspring.entity.User;
import com.example.javaspring.service.orderservice.OrderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    final
    OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @ApiOperation("Get all with to user ID")
    @GetMapping(value = "/allOrderUser/{id}")
    public ResponseEntity<List<Order>> allOrderByUserId(@Valid @NotBlank @PathVariable Long id){
        return ResponseEntity.ok(service.allByUserId(id));
    }

    @ApiOperation("Get one")
    @GetMapping(value = "/get/{id}")
    public ResponseEntity<Order> one(@Valid @NotBlank @PathVariable Long id){
        return ResponseEntity.ok(service.one(id));
    }
    @ApiOperation("Save")
    @PostMapping
    public ResponseEntity<Order> save(@Valid @NotBlank @RequestBody com.example.javaspring.entity.Order order){
        return ResponseEntity.ok(service.add(order));
    }

    @ApiOperation("Update with to id and new data Order")
    @PutMapping
    public ResponseEntity<Order> update(@Valid @NotBlank @RequestBody OrderDTO orderDTO){
        return ResponseEntity.ok(service.update(orderDTO.getOrder(), orderDTO.getId()));
    }

    @ApiOperation("Delete Order by id")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Order> delete(@Valid @NotBlank @PathVariable Long id){
        return ResponseEntity.ok(service.delete(id));
    }
}

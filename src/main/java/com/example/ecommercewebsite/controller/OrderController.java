package com.example.ecommercewebsite.controller;

import com.example.ecommercewebsite.model.Order;
import com.example.ecommercewebsite.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/info")
    public List<Order> getAllOrders() {

        try {

            List<Order> orderList = orderService.findAllOrders();
            return orderList;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("/place-order")
    public ResponseEntity<Boolean> placeOrder(@RequestBody Order order) {
        try {
            orderService.placeOrder(order);
            return new ResponseEntity<Boolean>(true, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

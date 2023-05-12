package com.example.ecommercewebsite.service;

import com.example.ecommercewebsite.dao.OrderRepository;
import com.example.ecommercewebsite.model.Order;
import com.example.ecommercewebsite.model.Product;
import com.example.ecommercewebsite.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> findAllOrders() {
        return orderRepository.findAllByOrderByIdAsc();
    }

    public Order placeOrder(Order order) {
        return orderRepository.save(order);
    }

}

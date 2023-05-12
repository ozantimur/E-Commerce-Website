package com.example.ecommercewebsite.dao;

import com.example.ecommercewebsite.model.Order;
import com.example.ecommercewebsite.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {

    List<Order> findAllByOrderByIdAsc();

    Order save(Order order);

}

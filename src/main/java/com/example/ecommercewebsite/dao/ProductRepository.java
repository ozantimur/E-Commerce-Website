package com.example.ecommercewebsite.dao;

import com.example.ecommercewebsite.model.Product;
import com.example.ecommercewebsite.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

    List<Product> findAllOrderByIdAsc(); // List<Product> findAllByOrderByIdAsc();

    Product findByIdIs(Integer id);

    List<Product> findAllByBrandIs(String brand);

}

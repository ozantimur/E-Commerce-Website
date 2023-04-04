package com.example.ecommercewebsite.service;

import com.example.ecommercewebsite.dao.ProductRepository;
import com.example.ecommercewebsite.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAllByOrderByIdAsc();
    }

}

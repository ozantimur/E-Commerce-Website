package com.example.ecommercewebsite.controller;

import com.example.ecommercewebsite.model.Product;
import com.example.ecommercewebsite.model.User;
import com.example.ecommercewebsite.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/info")
    public List<Product> getAllProducts() {
        try {

            List<Product> productList = productService.findAll();
            return productList;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

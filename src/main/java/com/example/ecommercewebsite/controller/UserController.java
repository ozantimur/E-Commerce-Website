package com.example.ecommercewebsite.controller;


import com.example.ecommercewebsite.model.User;
import com.example.ecommercewebsite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/info")
    public List<User> getAllUsers() {

        try {

            List<User> users = userService.findAllByOrderByIdAsc();
            return users;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}

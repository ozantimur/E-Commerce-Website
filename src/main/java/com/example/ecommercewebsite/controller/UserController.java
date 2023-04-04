package com.example.ecommercewebsite.controller;


import com.example.ecommercewebsite.model.User;
import com.example.ecommercewebsite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/info")
    public List<User> getAllUsers() {

        try {

            List<User> users = userService.findAll();
            return users;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @PostMapping("/sing-in")
    public ResponseEntity<Boolean> createUser(@RequestBody User user) {
        try {
            userService.saveUser(user);
            return new ResponseEntity<Boolean>(true, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Boolean>(false, HttpStatus.NOT_ACCEPTABLE);
        }
    }


}

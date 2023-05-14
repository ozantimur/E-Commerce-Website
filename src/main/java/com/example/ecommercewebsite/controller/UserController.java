package com.example.ecommercewebsite.controller;


import com.example.ecommercewebsite.model.User;
import com.example.ecommercewebsite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

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

    @PostMapping("/sing-up")
    public ResponseEntity<Boolean> createUser(@RequestBody User user) {
        try {
            userService.saveUser(user);
            return new ResponseEntity<Boolean>(true, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String email, @RequestParam String password) {
        User user = userService.findByEmailAndPassword(email, password);
        if (user != null) {
            return new ResponseEntity<String>("User logged in successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Invalid email or password.", HttpStatus.UNAUTHORIZED);
        }
    }

}

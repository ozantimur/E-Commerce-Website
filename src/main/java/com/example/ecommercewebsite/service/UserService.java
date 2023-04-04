package com.example.ecommercewebsite.service;

import com.example.ecommercewebsite.dao.UserRepository;
import com.example.ecommercewebsite.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAllByOrderByIdAsc();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

}

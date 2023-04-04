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

    public List<User> findAllByOrderByIdAsc() {

        List<User> userList = userRepository.findAllByOrderByIdAsc();

        return userList;
    }

}

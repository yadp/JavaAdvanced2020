package com.example.bookStore.service;


import com.example.bookStore.model.User;
import org.springframework.stereotype.Service;


@Service
public interface UserService {
    User findUserByUsername(String username);
    User findUser(Long id);
    User saveUser(User user);
    void deleteUser(Long id);
    User updateUser(User user);


}

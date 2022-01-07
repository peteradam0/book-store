package com.example.bookstore.service;

import com.example.bookstore.entity.User;
import com.example.bookstore.exception.ServiceLayerException;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUser();
    User getUserById(Long id);
    void insertUser(User user) throws ServiceLayerException;
    boolean userExists(User user);
    Optional<User> getUserByEmail(String email) throws ServiceLayerException;
    boolean loginUser(String email, String password);
}

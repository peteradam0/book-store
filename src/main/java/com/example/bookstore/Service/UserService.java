package com.example.bookstore.Service;

import com.example.bookstore.Entity.User;
import com.example.bookstore.Exception.ServiceLayerException;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUser();
    User getUserById(Long id);
    void insertUser(User user) throws ServiceLayerException;
    boolean userExists(User user);
    Optional<User> getUserByEmail(String email) throws ServiceLayerException;
}

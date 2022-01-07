package com.example.bookstore.dao;

import com.example.bookstore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {

    public User getUserByEmail(String email);
}

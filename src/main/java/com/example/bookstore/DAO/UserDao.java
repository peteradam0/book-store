package com.example.bookstore.DAO;

import com.example.bookstore.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {

    public User getUserByEmail(String email);
}

package com.example.bookstore.dao;

public interface UserTemporaryDao {
    public boolean loginUser(String email, String hashedPassword);
}

package com.example.bookstore.dao;

import com.example.bookstore.entity.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookCategoryDao extends JpaRepository<BookCategory, Long> {
}

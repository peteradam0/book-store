package com.example.bookstore.service;

import com.example.bookstore.entity.BookCategory;
import com.example.bookstore.exception.ServiceLayerException;

import java.util.List;

public interface BookCategoryService {
    List<BookCategory> getAllBooks() throws ServiceLayerException;

    BookCategory getBook(Long id) throws ServiceLayerException;
}

package com.example.bookstore.service;

import com.example.bookstore.entity.Book;
import com.example.bookstore.exception.ServiceLayerException;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    Book getBook(Long id) throws ServiceLayerException;
    List<Book> getAllBooksByCategoryId(Long id);
    List<Book> getAllBooksByName(String name) throws ServiceLayerException;
}

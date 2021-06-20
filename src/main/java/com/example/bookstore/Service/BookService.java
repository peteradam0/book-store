package com.example.bookstore.Service;

import com.example.bookstore.Entity.Book;
import com.example.bookstore.Exception.ServiceLayerException;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    Book getBook(Long id) throws ServiceLayerException;
    List<Book> getAllBooksByCategoryId(Long id);
    List<Book> getAllBooksByName(String name) throws ServiceLayerException;
}

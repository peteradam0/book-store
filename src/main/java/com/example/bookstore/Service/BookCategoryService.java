package com.example.bookstore.Service;

import com.example.bookstore.Entity.BookCategory;
import com.example.bookstore.Exception.ServiceLayerException;

import java.util.List;

public interface BookCategoryService {
    List<BookCategory> getAllBooks() throws ServiceLayerException;

    BookCategory getBook(Long id) throws ServiceLayerException;
}

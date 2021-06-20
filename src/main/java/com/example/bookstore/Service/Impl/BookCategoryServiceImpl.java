package com.example.bookstore.Service.Impl;

import com.example.bookstore.DAO.BookCategoryDao;
import com.example.bookstore.Entity.BookCategory;
import com.example.bookstore.Exception.ServiceLayerException;
import com.example.bookstore.Service.BookCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Component
public class BookCategoryServiceImpl implements BookCategoryService {

    private static final Logger logger = Logger.getLogger(UserServiceImpl.class.getName());


    @Autowired
    private BookCategoryDao bookCategoryDao;

    @Override
    public List<BookCategory> getAllBooks() throws ServiceLayerException {
        List<BookCategory> bookCategories = bookCategoryDao.findAll();
        if (bookCategories.isEmpty()) {
            logger.severe("no books were found");
            throw new ServiceLayerException("no books were found");
        }
        return bookCategories;
    }

    @Override
    public BookCategory getBook(Long id) throws ServiceLayerException {
        BookCategory bookCategory = bookCategoryDao.getOne(id);

        if (bookCategory == null) {
            logger.severe("book not found");
            throw new ServiceLayerException("book not found");
        }
        return bookCategoryDao.getOne(id);
    }
}

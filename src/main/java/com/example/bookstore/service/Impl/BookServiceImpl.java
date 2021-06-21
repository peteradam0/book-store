package com.example.bookstore.service.Impl;

import com.example.bookstore.dao.BookDao;
import com.example.bookstore.entity.Book;
import com.example.bookstore.exception.ServiceLayerException;
import com.example.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Component
public class BookServiceImpl implements BookService {

    private static final Logger logger = Logger.getLogger(BookServiceImpl.class.getName());

    @Autowired
    private BookDao bookDao;

    @Override
    public List<Book> getAllBooks() {
        return bookDao.findAll();
    }

    @Override
    public Book getBook(Long id) throws ServiceLayerException {
        Book book = bookDao.getOne(id);
        if (book == null) {
            logger.severe("book not found");
            throw new ServiceLayerException("book not found");
        }
        return book;
    }

    @Override
    public List<Book> getAllBooksByCategoryId(Long id) {
        List<Book> allBooks = bookDao.findAll();
        List<Book> specIdBooks = new ArrayList<>();
        allBooks.forEach(book -> {
            if (book.getBookCategory().getId() == id) {
                specIdBooks.add(book);
            }
        });
        return specIdBooks;
    }

    @Override
    public List<Book> getAllBooksByName(String name) throws ServiceLayerException {
        List<Book> bookList = bookDao.findByNameContaining(name);

        if (bookList.isEmpty()) {
            logger.severe("book not found");
            throw new ServiceLayerException("book not found");
        }
        return bookDao.findByNameContaining(name);
    }
}

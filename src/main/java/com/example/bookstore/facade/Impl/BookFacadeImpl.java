package com.example.bookstore.facade.Impl;

import com.example.bookstore.converter.Impl.BookToBookDtoPopulator;
import com.example.bookstore.converter.Impl.BookWithoutCategoryDtoPopulator;
import com.example.bookstore.dto.BookDto;
import com.example.bookstore.dto.BookWithoutCategoryDto;
import com.example.bookstore.entity.Book;
import com.example.bookstore.exception.ServiceLayerException;
import com.example.bookstore.facade.BookFacade;
import com.example.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookFacadeImpl implements BookFacade {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookToBookDtoPopulator bookToBookDtoPopulator;

    @Autowired
    private BookWithoutCategoryDtoPopulator bookWithoutCategoryDtoPopulator;

    @Override
    public List<BookDto> getBookDtos() {
        List<Book> tempBooks = bookService.getAllBooks();
        List<BookDto> bookDto = new ArrayList<>();

        tempBooks.forEach(book -> {
            BookDto tempBookDto = new BookDto();
            bookToBookDtoPopulator.populate(book,tempBookDto);
            bookDto.add(tempBookDto);
        });
        return bookDto;

    }

    @Override
    public BookWithoutCategoryDto getBookDto(Long id) throws ServiceLayerException {
        Book book = bookService.getBook(id);
        BookWithoutCategoryDto bookDto = new BookWithoutCategoryDto();
        bookWithoutCategoryDtoPopulator.populate(book,bookDto);
        return bookDto;
    }

    @Override
    public List<BookDto> getBookDtoByCategoryId(Long id) {
        List<Book> tempBooks = bookService.getAllBooksByCategoryId(id);
        List<BookDto> bookDto = new ArrayList<>();

        tempBooks.forEach(book -> {
            BookDto tempBookDto = new BookDto();
            bookToBookDtoPopulator.populate(book,tempBookDto);
            bookDto.add(tempBookDto);
        });
        return bookDto;
    }

    @Override
    public List<BookWithoutCategoryDto> getBookDtoByName(String name) throws ServiceLayerException {
        List<Book> tempBooks = bookService.getAllBooksByName(name);
        List<BookWithoutCategoryDto> bookDto = new ArrayList<>();

        tempBooks.forEach(book -> {
            BookWithoutCategoryDto tempBookDto = new BookWithoutCategoryDto();
            bookWithoutCategoryDtoPopulator.populate(book,tempBookDto);
            bookDto.add(tempBookDto);
        });
        return bookDto;
    }
}

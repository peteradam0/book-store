package com.example.bookstore.Facade.Impl;

import com.example.bookstore.Converter.Impl.BookToBookDtoPopulator;
import com.example.bookstore.Converter.Impl.BookWithoutCategoryDtoPopulator;
import com.example.bookstore.Dto.BookDto;
import com.example.bookstore.Dto.BookWithoutCategoryDto;
import com.example.bookstore.Entity.Book;
import com.example.bookstore.Exception.ServiceLayerException;
import com.example.bookstore.Facade.BookFacade;
import com.example.bookstore.Service.BookService;
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

package com.example.bookstore.facade.Impl;

import com.example.bookstore.converter.Impl.BookCategoryToBookCategoryDtoPopualtor;
import com.example.bookstore.dto.BookCategoryDto;
import com.example.bookstore.entity.BookCategory;
import com.example.bookstore.exception.ServiceLayerException;
import com.example.bookstore.facade.BookCategoryFacade;
import com.example.bookstore.service.BookCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookCategoryFacadeImpl implements BookCategoryFacade {

    @Autowired
    private BookCategoryService bookCategoryService;

    @Autowired
    private BookCategoryToBookCategoryDtoPopualtor bookCategoryToBookCategoryDtoPopualtor;

    @Override
    public List<BookCategoryDto> getBookCategoryDtos() throws ServiceLayerException {
        List<BookCategory> bookCategories = bookCategoryService.getAllBooks();
        List<BookCategoryDto> bookCategoryDtoList = new ArrayList<>();

        bookCategories.forEach(bookCategory -> {
            BookCategoryDto bookCategoryDto = new BookCategoryDto();
            bookCategoryToBookCategoryDtoPopualtor.populate(bookCategory, bookCategoryDto);
            bookCategoryDtoList.add(bookCategoryDto);
        });
        return bookCategoryDtoList;
    }

    @Override
    public BookCategoryDto getBookCategoryDto(Long id) throws ServiceLayerException {
        BookCategory bookCategory = bookCategoryService.getBook(id);
        BookCategoryDto bookCategoryDto = new BookCategoryDto();

        bookCategoryToBookCategoryDtoPopualtor.populate(bookCategory, bookCategoryDto);
        return bookCategoryDto;
    }

}

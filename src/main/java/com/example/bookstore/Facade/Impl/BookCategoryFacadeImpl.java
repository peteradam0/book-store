package com.example.bookstore.Facade.Impl;

import com.example.bookstore.Converter.Impl.BookCategoryToBookCategoryDtoPopualtor;
import com.example.bookstore.Converter.Impl.BookWithoutCategoryDtoPopulator;
import com.example.bookstore.Dto.BookCategoryDto;
import com.example.bookstore.Entity.BookCategory;
import com.example.bookstore.Exception.ServiceLayerException;
import com.example.bookstore.Facade.BookCategoryFacade;
import com.example.bookstore.Service.BookCategoryService;
import com.example.bookstore.Service.BookService;
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

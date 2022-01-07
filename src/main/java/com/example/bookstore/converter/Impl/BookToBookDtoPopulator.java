package com.example.bookstore.converter.Impl;

import com.example.bookstore.converter.Populator;
import com.example.bookstore.dto.BookCategoryDto;
import com.example.bookstore.dto.BookDto;
import com.example.bookstore.entity.Book;
import com.example.bookstore.entity.BookCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookToBookDtoPopulator implements Populator<Book, BookDto> {

    @Autowired
    BookCategoryToBookCategoryDtoPopualtor bookToBookDtoPopulator;

    @Override
    public void populate(Book source, BookDto target) {

        BookCategory bookCategory = source.getBookCategory();
        BookCategoryDto bookCategoryDto = new BookCategoryDto();

        bookToBookDtoPopulator.populate(bookCategory,bookCategoryDto);

        target.setId(source.getId());
        target.setName(source.getName());
        target.setActive(source.isActive());
        target.setBookCategoryDto(bookCategoryDto);
        target.setDescription(source.getDescription());
        target.setUnitPrice(source.getUnitPrice());
        target.setImageUrl(source.getImageUrl());
    }
}

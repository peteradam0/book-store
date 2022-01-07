package com.example.bookstore.converter.Impl;

import com.example.bookstore.converter.Populator;
import com.example.bookstore.dto.BookCategoryNameDto;
import com.example.bookstore.entity.BookCategory;
import org.springframework.stereotype.Component;

@Component
public class BookCategoryNameDtoPopulator implements Populator<BookCategory, BookCategoryNameDto> {

    @Override
    public void populate(BookCategory source, BookCategoryNameDto target) {
        target.setCategoryName(source.getCategoryName());
    }
}

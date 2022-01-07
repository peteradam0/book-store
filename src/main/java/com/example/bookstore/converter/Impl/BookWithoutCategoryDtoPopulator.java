package com.example.bookstore.converter.Impl;

import com.example.bookstore.converter.Populator;
import com.example.bookstore.dto.BookWithoutCategoryDto;
import com.example.bookstore.entity.Book;
import org.springframework.stereotype.Component;

@Component
public class BookWithoutCategoryDtoPopulator implements Populator<Book, BookWithoutCategoryDto> {
    @Override
    public void populate(Book source, BookWithoutCategoryDto target) {
        target.setId(source.getId());
        target.setName(source.getName());
        target.setImageUrl(source.getImageUrl());
        target.setDescription(source.getDescription());
        target.setUnitPrice(source.getUnitPrice());
        target.setUnitsInStock(source.getUnitsInStock());
    }
}

package com.example.bookstore.facade;

import com.example.bookstore.dto.BookCategoryDto;
import com.example.bookstore.exception.ServiceLayerException;

import java.util.List;

public interface BookCategoryFacade {
    List<BookCategoryDto> getBookCategoryDtos() throws ServiceLayerException;

    BookCategoryDto getBookCategoryDto(Long id) throws ServiceLayerException;
}

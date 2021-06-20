package com.example.bookstore.Facade;

import com.example.bookstore.Dto.BookCategoryDto;
import com.example.bookstore.Exception.ServiceLayerException;

import java.util.List;

public interface BookCategoryFacade {
    List<BookCategoryDto> getBookCategoryDtos() throws ServiceLayerException;

    BookCategoryDto getBookCategoryDto(Long id) throws ServiceLayerException;
}

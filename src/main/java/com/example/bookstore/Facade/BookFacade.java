package com.example.bookstore.Facade;

import com.example.bookstore.Dto.BookDto;
import com.example.bookstore.Dto.BookWithoutCategoryDto;
import com.example.bookstore.Exception.ServiceLayerException;

import java.util.List;

public interface BookFacade {
    List<BookDto> getBookDtos();
    BookWithoutCategoryDto getBookDto(Long id) throws ServiceLayerException;
    List<BookDto> getBookDtoByCategoryId(Long id);
    List<BookWithoutCategoryDto> getBookDtoByName(String name) throws ServiceLayerException;

}

package com.example.bookstore.dto;

import java.util.List;

public class BookCategoryDto {

    private String categoryName;
    private List<BookWithoutCategoryDto> bookDtos;



    public BookCategoryDto() {
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public List<BookWithoutCategoryDto> getBookDtos() {
        return bookDtos;
    }

    public void setBookDtos(List<BookWithoutCategoryDto> bookDtos) {
        this.bookDtos = bookDtos;
    }
}

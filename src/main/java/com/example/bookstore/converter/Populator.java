package com.example.bookstore.converter;

public interface Populator<T,U>{
    void populate(T source, U target);
}

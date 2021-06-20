package com.example.bookstore.Controller;

import com.example.bookstore.Dto.BookCategoryDto;
import com.example.bookstore.Exception.ServiceLayerException;
import com.example.bookstore.Facade.Impl.BookCategoryFacadeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/books")
public class BookCategoryController {

    @Autowired
    private BookCategoryFacadeImpl bookCategoryFacade;


    @GetMapping("/search/category/{id}")
    public ResponseEntity getBooks(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(bookCategoryFacade.getBookCategoryDto(id));
        } catch (ServiceLayerException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}

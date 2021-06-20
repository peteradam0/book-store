package com.example.bookstore.Controller;

import com.example.bookstore.Exception.ServiceLayerException;
import com.example.bookstore.Facade.Impl.BookFacadeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/books")
@CrossOrigin(origins = "http://localhost:4200")
public class BookController {

    @Autowired
    private BookFacadeImpl bookFacade;

    @GetMapping("/")
    public ResponseEntity getBooks() {
        return ResponseEntity.ok(bookFacade.getBookDtos());
    }

    @GetMapping("/{id}")
    public ResponseEntity getBook(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(bookFacade.getBookDto(id));
        } catch (ServiceLayerException e) {
            return ResponseEntity.status(HttpStatus.OK).body(e.getMessage());
        }
    }


    @GetMapping("/search/{name}")
    public ResponseEntity getBooks(@PathVariable String name) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(bookFacade.getBookDtoByName(name));
        } catch (ServiceLayerException e) {
            return ResponseEntity.status(HttpStatus.OK).body(e.getMessage());
        }
    }

}

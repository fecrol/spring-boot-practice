package com.example.springbootpractice.controllers;

import com.example.springbootpractice.models.Book;
import com.example.springbootpractice.services.BooksService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "api/v1/books")
public class BooksController {

    private final BooksService booksService;

    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return booksService.getAllBooks();
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> getBookById(@PathVariable("id") String bookId) {
        return booksService.getBookById(bookId);
    }

    @PostMapping
    public ResponseEntity<Object> addNewBook(@RequestBody Map<String, String> reqBody) {
        return booksService.addNewBook(reqBody);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteBook(@PathVariable("id") String bookId) {
        return booksService.deleteBook(bookId);
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> updateBook(@PathVariable("id") String bookId, @RequestBody Map<String, String> reqBody) {
        return booksService.updateBook(bookId, reqBody);
    }
}

package com.example.springbootpractice.controllers;

import com.example.springbootpractice.models.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/books")
public class BooksController {

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {

    }
}

package com.example.springbootpractice.services;

import com.example.springbootpractice.data.Books;
import com.example.springbootpractice.models.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class BooksService {

    private final Books books;

    public BooksService(Books books) {
        this.books = books;
    }

    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> allBooks = books.findAll();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(allBooks);
    }

    public ResponseEntity<Object> getBookById(String bookId) {
        Optional<Book> book = books.findById(bookId);

        return book.isPresent() ?
                ResponseEntity
                        .status(HttpStatus.OK)
                        .body(book) :
                ResponseEntity.
                        status(HttpStatus.NOT_FOUND).
                        body(Map.of("error", "book with id of " + bookId + " not found"));
    }

    public ResponseEntity<Object> addNewBook(Map<String, String> reqBody) {
        List<String> bookFields = List.of("title", "author", "publisher", "publicationDate");

        for(String bookField : bookFields) {
            if(!reqBody.containsKey(bookField)) {
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(Map.of("error", bookField + " field required"));
            }
        }

        String bookId = UUID.randomUUID().toString();
        LocalDate publicationDate = LocalDate.parse(reqBody.get("publicationDate"));

        Book newBook = new Book(
                bookId,
                reqBody.get("title"),
                reqBody.get("author"),
                reqBody.get("publisher"),
                publicationDate
        );
        books.save(newBook);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(newBook);
    }

    public ResponseEntity<Object> deleteBook(String bookId) {
        if(!books.existsById(bookId)) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", "book with id of " + bookId + " not found"));
        }

        books.delete(bookId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("message", "book with id of " + bookId + " deleted successfully"));
    }
}

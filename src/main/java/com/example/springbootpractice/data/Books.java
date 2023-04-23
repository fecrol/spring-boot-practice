package com.example.springbootpractice.data;

import com.example.springbootpractice.models.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class Books {

    private List<Book> books;

    public Books() {
        this.books = new ArrayList<>();
    }

    public List<Book> findAll() {
        return this.books;
    }

    public void saveAll(List<Book> books) {
        this.books.addAll(books);
    }

    public void save(Book book) {
        this.books.add(book);
    }

    public Optional<Book> findById(String id) {
        Book matchingBook = this.books
                .stream()
                .filter(book -> Objects.equals(book.getId(), id))
                .findFirst()
                .orElse(null);

        return matchingBook == null ? Optional.empty() : Optional.of(matchingBook);
    }

    public boolean existsById(String id) {
        Optional<Book> book = findById(id);

        return book.isPresent();
    }

    public void delete(String id) {
        Book matchingBook = this.books
                .stream()
                .filter(book -> Objects.equals(book.getId(), id))
                .findFirst()
                .get();

        this.books.remove(matchingBook);
    }
}

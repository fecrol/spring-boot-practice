package com.example.springbootpractice.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Book {

    private String id;
    private String title;
    private String author;
    private String publisher;
    private LocalDate publicationDate;

    public Book() {}

    public Book(String id, String title, String author, String publisher, LocalDate publicationDate) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publicationDate = publicationDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublicationDate() {
        return publicationDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", releaseDate=" + publicationDate +
                '}';
    }
}

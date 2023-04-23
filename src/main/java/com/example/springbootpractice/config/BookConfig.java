package com.example.springbootpractice.config;

import com.example.springbootpractice.data.Books;
import com.example.springbootpractice.models.Book;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class BookConfig {

    @Bean
    CommandLineRunner commandLineRunner(Books books) {
        return args -> {
            Book theCountOfMonteCristo = new Book(
                    "1234-5678",
                    "The Count of Monte Cristo",
                    "Alexander Dumas",
                    "Simon & Schuster",
                    LocalDate.of(1846, Month.JANUARY, 15)
            );

            Book theHobbit = new Book(
                    "8765-4321",
                    "The Hobbit",
                    "J. R. R. Tolkien",
                    "George Allen & Unwin",
                    LocalDate.of(1937, Month.SEPTEMBER, 21)
            );

            books.saveAll(List.of(theCountOfMonteCristo, theHobbit));
        };
    }
}

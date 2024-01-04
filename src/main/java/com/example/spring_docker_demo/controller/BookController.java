package com.example.spring_docker_demo.controller;

import com.example.spring_docker_demo.entities.Book;
import com.example.spring_docker_demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

   // SaveBook Endpoint
    @PostMapping
    public Book saveBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    // GetBook Endpoint
    @GetMapping
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

}

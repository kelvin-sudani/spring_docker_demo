package com.example.spring_docker_demo.controller;

import com.example.spring_docker_demo.entities.Author;
import com.example.spring_docker_demo.entities.Book;
import com.example.spring_docker_demo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/authors")
@RestController
public class AuthorController {
    @Autowired
    private AuthorRepository authorRepository;

    // SaveAuthor Endpoint
    @PostMapping
    public Author saveAuthor(@RequestBody Author author) {
        return authorRepository.save(author);
    }


    // GetAuthor Endpoint
    @GetMapping
    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    //Get All the books by an author
    @GetMapping("/{authorName}/books")
    public List<Book> getBooksByAuthor(@PathVariable String authorName) {
        return authorRepository.findByName(authorName).getBooks();
    }

    // Update Author Endpoint
    @PutMapping("/{id}")
    public Author updateAuthor(@PathVariable Long id, @RequestBody Author authorDetails) {
        Author author = authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Author not found"));
        author.setName(authorDetails.getName());
        // Update other fields as necessary
        return authorRepository.save(author);
    }


    // Delete Author Endpoint
    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable Long id) {
        Author author = authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Author not found"));
        authorRepository.delete(author);
    }


}

package com.example.spring_docker_demo.controller;

import com.example.spring_docker_demo.entity.Author;
import com.example.spring_docker_demo.entity.Book;
import com.example.spring_docker_demo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    //Get All the books by an author name
    @GetMapping("/by-name/{authorName}/books")
    public List<Book> getBooksByAuthor(@PathVariable String authorName) {
        Author author = authorRepository.findAuthorByName(authorName).orElseThrow(() -> new RuntimeException("Author not found"));
        return author.getBooks();
    }
    //Get All the books by an author id
    @GetMapping("/{authorId}/books")
    public List<Book> getBooksByAuthorId(@PathVariable Long authorId) {
        Author author = authorRepository.findById(authorId).orElseThrow(() -> new RuntimeException("Author not found"));
        return author.getBooks();
    }
    // Update Author Endpoint
    @PutMapping("/{id}")
    public Author updateAuthor(@PathVariable Long id, @RequestBody Author authorDetails) {
        Author author = authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Author not found"));
        author.setName(authorDetails.getName());
        // Update other fields as necessary
        return authorRepository.save(author);
    }
   // Add book to an author
    @PostMapping("/{authorName}/books")
    public Author addBookToAuthor(@PathVariable String authorName, @RequestBody Book book) {
        Author author = authorRepository.findAuthorByName(authorName).orElseThrow(() -> new RuntimeException("Author not found"));
        book.setAuthor(author);
        author.getBooks().add(book);
        return authorRepository.save(author);
    }


    // Delete Author Endpoint
    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable Long id) {
        Author author = authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Author not found"));
        authorRepository.delete(author);
    }


}

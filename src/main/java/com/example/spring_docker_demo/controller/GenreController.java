package com.example.spring_docker_demo.controller;

import com.example.spring_docker_demo.entity.Genre;
import com.example.spring_docker_demo.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genres")
public class GenreController {

    @Autowired
    private GenreRepository genreRepository;

    // Create a new Genre
    @PostMapping
    public Genre createGenre(@RequestBody Genre genre) {
        return genreRepository.save(genre);
    }

    // Retrieve all Genres
    @GetMapping
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    // Retrieve a single Genre by ID
    @GetMapping("/{id}")
    public Genre getGenreById(@PathVariable Long id) {
        return genreRepository.findById(id).orElseThrow(() -> new RuntimeException("Genre not found"));
    }

    // Update a Genre
    @PutMapping("/{id}")
    public Genre updateGenre(@PathVariable Long id, @RequestBody Genre genreDetails) {
        Genre genre = genreRepository.findById(id).orElseThrow(() -> new RuntimeException("Genre not found"));
        genre.setName(genreDetails.getName());
        return genreRepository.save(genre);
    }

    // Delete a Genre
    @DeleteMapping("/{id}")
    public void deleteGenre(@PathVariable Long id) {
        Genre genre = genreRepository.findById(id).orElseThrow(() -> new RuntimeException("Genre not found"));
        genreRepository.delete(genre);
    }
}

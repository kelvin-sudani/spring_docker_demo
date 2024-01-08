package com.example.spring_docker_demo.repository;

import com.example.spring_docker_demo.entity.Author;
import com.example.spring_docker_demo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    Optional<Author> findAuthorByName(String name);

}

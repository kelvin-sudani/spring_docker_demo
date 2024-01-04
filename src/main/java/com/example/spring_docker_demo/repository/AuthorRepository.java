package com.example.spring_docker_demo.repository;

import com.example.spring_docker_demo.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {


    Author findByName(String authorName);
}

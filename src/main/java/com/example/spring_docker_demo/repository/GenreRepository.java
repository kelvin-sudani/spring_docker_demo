package com.example.spring_docker_demo.repository;

import com.example.spring_docker_demo.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {

}

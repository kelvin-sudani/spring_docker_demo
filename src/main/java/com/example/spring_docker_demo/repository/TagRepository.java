package com.example.spring_docker_demo.repository;

import com.example.spring_docker_demo.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {

}

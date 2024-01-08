package com.example.spring_docker_demo.entity;

import com.example.spring_docker_demo.DTO.BookDTO;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@lombok.Data
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
public class Author {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name = "id")
 private Long id;
 private String name;

 @OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
 @JsonManagedReference
 private List<Book> books;


}

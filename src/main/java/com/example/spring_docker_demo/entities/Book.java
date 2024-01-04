package com.example.spring_docker_demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {

 // id, Author, Title, Year
 @Id
  private Long id;
  private String author;
  private String title;
  private int year;
}

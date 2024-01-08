package com.example.spring_docker_demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {

 // id, Author, Title, Year
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name = "id")
  private Long id;

 @ManyToOne
 @JoinColumn(name = "author_id", referencedColumnName = "id")
 @JsonBackReference
 private Author author;

  private String title;
  private int year;

 @ManyToOne
 private Genre genre; // Unidirectional OneToMany

 @ManyToMany
 @JoinTable(
         name = "book_tag",
         joinColumns = @JoinColumn(name = "book_id"),
         inverseJoinColumns = @JoinColumn(name = "tag_id")
 )
 @JsonManagedReference // Or @JsonIgnoreProperties({"books"})
 private Set<Tag> tags = new HashSet<>(); // Bidirectional ManyToMany


}

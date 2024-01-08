package com.example.spring_docker_demo.controller;

import com.example.spring_docker_demo.entity.Tag;
import com.example.spring_docker_demo.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tags")
public class TagController {

    @Autowired
    private TagRepository tagRepository;

    // Create a new Tag
    @PostMapping
    public Tag createTag(@RequestBody Tag tag) {
        return tagRepository.save(tag);
    }

    // Retrieve all Tags
    @GetMapping
    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    // Retrieve a single Tag by ID
    @GetMapping("/{id}")
    public Tag getTagById(@PathVariable Long id) {
        return tagRepository.findById(id).orElseThrow(() -> new RuntimeException("Tag not found"));
    }

    // Update a Tag
    @PutMapping("/{id}")
    public Tag updateTag(@PathVariable Long id, @RequestBody Tag tagDetails) {
        Tag tag = tagRepository.findById(id).orElseThrow(() -> new RuntimeException("Tag not found"));
        tag.setName(tagDetails.getName());
        return tagRepository.save(tag);
    }

    // Delete a Tag
    @DeleteMapping("/{id}")
    public void deleteTag(@PathVariable Long id) {
        Tag tag = tagRepository.findById(id).orElseThrow(() -> new RuntimeException("Tag not found"));
        tagRepository.delete(tag);
    }
}

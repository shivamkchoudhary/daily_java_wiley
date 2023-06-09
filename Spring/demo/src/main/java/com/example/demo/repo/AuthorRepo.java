package com.example.demo.repo;

import com.example.demo.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepo extends JpaRepository<Author, Long> {
    Author findByAuthorName(String authorName);
}

package com.example.demo.service;
import com.example.demo.model.Author;

import java.util.List;

public interface AuthorService {
    Author createAuthor(Author author);
    List<Author> getAllAuthorsList();

}

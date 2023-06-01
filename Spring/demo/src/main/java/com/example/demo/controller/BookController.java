package com.example.demo.controller;

import com.example.demo.exception.BookNotFoundException;
import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/book")
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);

    }
    @GetMapping("/book/{id}")
    public Book getBook(@PathVariable Long id) throws BookNotFoundException {
        return bookService.getBookById(id);
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookService.getAllBooksList();
    }
}

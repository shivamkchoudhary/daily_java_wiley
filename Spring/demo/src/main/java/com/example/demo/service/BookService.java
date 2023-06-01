package com.example.demo.service;

import com.example.demo.exception.BookNotFoundException;
import com.example.demo.model.Book;

import java.util.List;

public interface BookService {
    Book createBook(Book book);
    List<Book> getAllBooksList();
    Book getBookById(Long bookId) throws BookNotFoundException;
    Book updateBook(Long bookId, Book book);
    void deleteBookById(Long bookId);
    Book getBookByName(String bookName);


}

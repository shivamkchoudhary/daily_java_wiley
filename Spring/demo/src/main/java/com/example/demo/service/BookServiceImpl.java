package com.example.demo.service;

import com.example.demo.exception.BookNotFoundException;
import com.example.demo.model.Book;
import com.example.demo.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookRepo bookRepo;
    @Override
    public Book createBook(Book book) {
        return bookRepo.save(book);
    }

    @Override
    public List<Book> getAllBooksList() {
        return bookRepo.findAll();
    }

    @Override
    public Book getBookById(Long bookId) throws BookNotFoundException {
        if(bookRepo.findById(bookId).isEmpty()){
            throw new BookNotFoundException("Book not found: " + bookId + "");
        }
        return bookRepo.findById(bookId).get();
    }

    @Override
    public Book updateBook(Long bookId, Book book) {
        return null;
    }

    @Override
    public void deleteBookById(Long bookId) {
        bookRepo.deleteById(bookId);
    }

    @Override
    public Book getBookByName(String bookName) {
        return bookRepo.findByBookName(bookName);
    }
}

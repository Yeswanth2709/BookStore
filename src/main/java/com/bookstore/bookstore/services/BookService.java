package com.bookstore.bookstore.services;

import com.bookstore.bookstore.models.Book;

import java.util.List;

public interface BookService {
    void save(Book book);
    List<Book> getAllBooks();
    Book getBookById(int id);
    void deleteById(int id);
}

package com.bookstore.bookstore.services;

import com.bookstore.bookstore.models.MyBookList;

import java.util.List;

public interface MyBookListService {
    void saveMyBook(MyBookList book);
    List<MyBookList> getAllMyBooks();
    void deleteById(int id);
}

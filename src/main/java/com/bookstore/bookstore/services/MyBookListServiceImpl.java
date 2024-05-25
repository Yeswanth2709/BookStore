package com.bookstore.bookstore.services;

import com.bookstore.bookstore.models.MyBookList;
import com.bookstore.bookstore.repositories.MyBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBookListServiceImpl implements MyBookListService{
    private MyBookRepository myBookRepository;
    @Autowired
    public MyBookListServiceImpl(MyBookRepository myBookRepository) {
        this.myBookRepository = myBookRepository;
    }

    @Override
    public void saveMyBook(MyBookList book) {
        myBookRepository.save(book);
    }

    @Override
    public List<MyBookList> getAllMyBooks() {
        return myBookRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        myBookRepository.deleteById(id);
    }
}

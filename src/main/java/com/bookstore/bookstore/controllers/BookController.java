package com.bookstore.bookstore.controllers;

import com.bookstore.bookstore.models.Book;
import com.bookstore.bookstore.models.MyBookList;
import com.bookstore.bookstore.services.BookService;
import com.bookstore.bookstore.services.MyBookListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {
    private BookService bookService;
    private MyBookListService myBookListService;

    @Autowired
    public BookController(BookService bookService,MyBookListService myBookListService) {
        this.bookService = bookService;
        this.myBookListService=myBookListService;
    }

    @GetMapping("/")
    public String home(){
        return "home";
    }
    @GetMapping("/book_register")
    public String bookRegister(){
        return "bookRegister";
    }
    @GetMapping("/available_books")
    public ModelAndView getAllBooks(){
        List<Book> books = bookService.getAllBooks();
        return new ModelAndView("bookList","book",books);
    }
    @PostMapping("/save")
    public String addBook(@ModelAttribute Book book){
        bookService.save(book);
        return "redirect:/available_books";
    }
    @GetMapping("/my_books")
    public ModelAndView getMyBooks(){
        List<MyBookList> allMyBooks = myBookListService.getAllMyBooks();

        return new ModelAndView("myBooks","book",allMyBooks);
    }
    @RequestMapping("/mylist/{id}")
    public String getMyList(@PathVariable("id") int id){
        Book book = bookService.getBookById(id);
        MyBookList myBookList=new MyBookList(book.getId(),book.getName(),book.getAuthor(),book.getPrice());
        myBookListService.saveMyBook(myBookList);
        return "redirect:/my_books";
    }
    @RequestMapping("/editBook/{id}")
    public ModelAndView editBook(@PathVariable("id") int id){
        Book book = bookService.getBookById(id);
        return new ModelAndView("bookEdit","book",book);
    }
    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") int id){
        bookService.deleteById(id);
        return "redirect:/available_books";
    }
}

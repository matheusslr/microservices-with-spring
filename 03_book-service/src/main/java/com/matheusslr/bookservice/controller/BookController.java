package com.matheusslr.bookservice.controller;

import com.matheusslr.bookservice.model.Book;
import com.matheusslr.bookservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("book-service")
public class BookController {
    @Autowired
    private BookService bookService;
    private Book book;

    @GetMapping("/{id}/{currency}")
    public Book findBook(
            @PathVariable(value = "id") Long id,
            @PathVariable(value = "currency") String currency
    ) {
        return bookService.findById(id, currency);
    }
}

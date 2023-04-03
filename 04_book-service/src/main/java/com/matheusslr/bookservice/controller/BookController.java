package com.matheusslr.bookservice.controller;

import com.matheusslr.bookservice.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;

@RestController
@RequestMapping("book-service")
public class BookController {
    @Autowired
    private Environment environment;
    private Book book;

    @GetMapping("/{id}/{currency}")
    public Book findBook(
            @PathVariable(value = "id") Long id,
            @PathVariable(value = "currency") String currency
            ){
        var port = environment.getProperty("local.server.port");

        return new Book(
                id,
                "aaa",
                new Date(),
                113.32,
                "dsds",
                currency,
                port
        );
    }
}

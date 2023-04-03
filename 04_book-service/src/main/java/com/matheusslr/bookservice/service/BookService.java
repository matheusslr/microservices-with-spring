package com.matheusslr.bookservice.service;

import com.matheusslr.bookservice.model.Book;
import com.matheusslr.bookservice.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private Environment environment;

    public Book findById(Long id, String currency){
        Book book = bookRepository.findById(id).get();
        if(book == null) throw new RuntimeException("Book not found");

        var port = environment.getProperty("local.server.port");
        book.setEnvironment(port);
        book.setCurrency(currency);
        return book;
    }
}

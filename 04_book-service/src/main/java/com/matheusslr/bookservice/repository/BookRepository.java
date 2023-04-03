package com.matheusslr.bookservice.repository;

import com.matheusslr.bookservice.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}

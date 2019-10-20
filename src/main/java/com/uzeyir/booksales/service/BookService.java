package com.uzeyir.booksales.service;

import com.uzeyir.booksales.model.Book;

import java.util.List;

public interface BookService {
    Book create(Book book);

    Book update(Book book);

    void delete(Long id);

    Book findById(Long id);

    List<Book> bookList();
}

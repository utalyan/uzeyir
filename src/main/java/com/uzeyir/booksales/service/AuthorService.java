package com.uzeyir.booksales.service;

import com.uzeyir.booksales.model.Author;

import java.util.List;

/**
 * Yazar servis işlemlerini içerir
 */
public interface AuthorService {

    Author create(Author author);

    Author update(Author author);

    void delete(Long id);

    Author findById(Long id);

    List<Author> authorList();
}

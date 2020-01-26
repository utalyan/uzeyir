package com.uzeyir.booksales.service;

import com.uzeyir.booksales.model.Author;
import com.uzeyir.booksales.repository.AuthorRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepositoryJpa authorRepositoryJpa;

    @Override
    public Author create(Author author) {
        return authorRepositoryJpa.save(author);
    }

    @Override
    public Author update(Author author) {
        return authorRepositoryJpa.save(author);
    }

    @Override
    public void delete(Long id) {
        authorRepositoryJpa.deleteById(id);
    }

    @Override
    public Author findById(Long id) {
        return authorRepositoryJpa.findById(id).get();
    }

    @Override
    public List<Author> authorList() {
        return authorRepositoryJpa.findAll();
    }
}

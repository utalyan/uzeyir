package com.uzeyir.booksales.service;

import com.uzeyir.booksales.model.Book;
import com.uzeyir.booksales.repository.BookRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Book servis
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepositoryJpa bookRepositoryJpa;

    /**
     *
     * Yeni Book oluşturur
     * @param book
     * @return
     */
    @Override
    @Transactional
    public Book create(Book book) {
        return bookRepositoryJpa.save(book);
    }

    @Override
    @Transactional
    public Book update(Book book) {
        return bookRepositoryJpa.save(book);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        bookRepositoryJpa.deleteById(id);
    }

    @Override
    public Book findById(Long id) {
        return bookRepositoryJpa.findById(id).get();
    }

    @Override
    public List<Book> bookList() {
        return bookRepositoryJpa.findAll();
    }
}

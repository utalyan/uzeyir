package com.uzeyir.booksales.repository;

import com.uzeyir.booksales.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepositoryJpa extends JpaRepository<Book, Long> {
}

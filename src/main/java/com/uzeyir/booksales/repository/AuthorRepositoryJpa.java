package com.uzeyir.booksales.repository;

import com.uzeyir.booksales.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface AuthorRepositoryJpa extends JpaRepository<Author, BigInteger> {
}

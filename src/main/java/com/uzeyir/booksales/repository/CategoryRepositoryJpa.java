package com.uzeyir.booksales.repository;

import com.uzeyir.booksales.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepositoryJpa extends JpaRepository<Category, Long> {
}

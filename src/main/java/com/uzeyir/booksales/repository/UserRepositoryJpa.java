package com.uzeyir.booksales.repository;

import com.uzeyir.booksales.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryJpa extends JpaRepository<User, Long> {
}

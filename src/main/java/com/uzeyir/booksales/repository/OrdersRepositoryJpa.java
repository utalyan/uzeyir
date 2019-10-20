package com.uzeyir.booksales.repository;

import com.uzeyir.booksales.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface OrdersRepositoryJpa extends JpaRepository<Orders, Long> {
    @Query(value = "SELECT ord FROM orders ord Where ord.user_id = ?1",nativeQuery = true)
    List<Orders> findByUserId(Long id);
}

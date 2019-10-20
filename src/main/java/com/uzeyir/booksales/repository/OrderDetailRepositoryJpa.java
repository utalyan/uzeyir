package com.uzeyir.booksales.repository;

import com.uzeyir.booksales.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface OrderDetailRepositoryJpa extends JpaRepository<OrderDetail, Long> {

    @Query(value = "SELECT * FROM order_detail where order_id = ?1",nativeQuery = true)
    List<OrderDetail> findByOrdersId(Long id);

}

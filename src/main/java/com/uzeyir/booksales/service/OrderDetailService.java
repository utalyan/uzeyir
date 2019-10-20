package com.uzeyir.booksales.service;

import com.uzeyir.booksales.model.OrderDetail;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderDetailService {

    /**
     * Order Detail inserts
     * @param orderDetails
     * @return
     */
    List<OrderDetail> create(List<OrderDetail> orderDetails);

    /**
     * OrderDetail sil.
     * @param id
     */
    void delete(Long id);

    /**
     * Order ile OrderDetail getir.
     * @param id
     * @return
     */
    List<OrderDetail> findByOrdersId(Long id);
}

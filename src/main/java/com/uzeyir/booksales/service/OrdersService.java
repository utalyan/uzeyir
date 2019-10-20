package com.uzeyir.booksales.service;

import com.uzeyir.booksales.model.Orders;

import java.util.List;

public interface OrdersService {

    /**
     * yeni OrderS
     * @param orders
     * @return
     */
    Orders create(Orders orders);

    /**
     * delete order
     * @param id
     */
    void delete(Long id);

    /**
     * find order by id
     * @param id
     * @return
     */
    Orders findById(Long id);

    /**
     * get all order
     * @return
     */
    List<Orders> ordersList(Long id);


}

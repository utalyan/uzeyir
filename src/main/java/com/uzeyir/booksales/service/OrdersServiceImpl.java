package com.uzeyir.booksales.service;

import com.uzeyir.booksales.model.Orders;
import com.uzeyir.booksales.repository.OrdersRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersRepositoryJpa ordersRepositoryJpa;
    /**
     * yeni OrderS
     *
     * @param orders
     * @return
     */
    @Override
    public Orders create(Orders orders) {
        return ordersRepositoryJpa.save(orders);
    }

    /**
     * delete order
     *
     * @param id
     */
    @Override
    public void delete(Long id) {
        ordersRepositoryJpa.deleteById(id);
    }

    /**
     * find order by id
     *
     * @param id
     * @return
     */
    @Override
    public Orders findById(Long id) {
        return ordersRepositoryJpa.findById(id).get();
    }

    /**
     * get all order
     *
     * @return
     */
    @Override
    public List<Orders> ordersList(Long id) {
        return ordersRepositoryJpa.findByUserId(id);
    }
}

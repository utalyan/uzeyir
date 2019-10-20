package com.uzeyir.booksales.service;

import com.uzeyir.booksales.model.OrderDetail;
import com.uzeyir.booksales.repository.OrderDetailRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    OrderDetailRepositoryJpa orderDetailRepositoryJpa;

    @Override
    public List<OrderDetail> create(List<OrderDetail> orderDetails) {
        return orderDetailRepositoryJpa.saveAll(orderDetails);
    }

    @Override
    public void delete(Long id) {
        orderDetailRepositoryJpa.deleteById(id);
    }

    @Override
    public List<OrderDetail> findByOrdersId(Long id) {
        return orderDetailRepositoryJpa.findByOrdersId(id);
    }
}

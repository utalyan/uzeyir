package com.uzeyir.booksales.repository;


import com.uzeyir.booksales.model.*;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderRepositoryJpaTest {

    @Autowired
    OrdersRepositoryJpa ordersRepositoryJpa;

    @Autowired
    OrderDetailRepositoryJpa orderDetailRepositoryJpa;

    @Autowired
    UserRepositoryJpa userRepositoryJpa;

    @Autowired
    BookRepositoryJpa bookRepositoryJpa;

    @Test
    @Transactional
    public void orderInsert(){
        Orders orders = new Orders();

        orders.setDescription("İlk sipariş");

        User user = new User();

        user.setName("Talha");
        user.setMailAddress("utalyan@hotmail.com");
        Address address = new Address();
        address.setAddress("Test Adres");
        user.setAddress(address);

        userRepositoryJpa.save(user);

        orders.setUser(user);

        OrderDetail orderDetail = new OrderDetail();

        orderDetail.setPrice(2.4);
        orderDetail.setQuantity(5L);

        Book book = new Book();

        Category category = new Category();
        category.setName("Bilim-Kurgu");

        Author author = new Author();
        author.setName("Talha Talyan");

        book.setAuthors( Collections.singleton(author));

        book.setCategories(Collections.singleton(category));

        book.setDescription("Uzayda geçen bir hikaye");
        book.setName("Selim Uzayda");

        bookRepositoryJpa.save(book);

        orderDetail.setBook(book);

        orders.setOrderDetails(Collections.singleton(orderDetail));

        ordersRepositoryJpa.save(orders);

        MatcherAssert.assertThat(orders.getId(), Matchers.greaterThan(0L));



    }

}

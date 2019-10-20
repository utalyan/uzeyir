package com.uzeyir.booksales.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders orders;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    private Long quantity;
    private Double price;
}

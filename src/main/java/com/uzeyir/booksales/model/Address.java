package com.uzeyir.booksales.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @OneToOne(mappedBy = "address")
    private User user;
    private String address;
}

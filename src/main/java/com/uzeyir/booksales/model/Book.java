package com.uzeyir.booksales.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data

public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "İsim Girilmeli.")
    String name;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "author_book",
            joinColumns = {@JoinColumn(name = "book_id",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "author_id",referencedColumnName = "id")})
    private Set<Author> authors = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "category_book",
            joinColumns = {@JoinColumn(name = "book_id",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id",referencedColumnName = "id")})
    private Set<Category> categories = new HashSet<>();

    @OneToMany(mappedBy = "book")
    private Set<OrderDetail> orderDetails = new HashSet<>();

    private Double price;
    private String description;
}
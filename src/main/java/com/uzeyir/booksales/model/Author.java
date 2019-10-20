package com.uzeyir.booksales.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data

public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "authors",fetch = FetchType.LAZY)
    private Set<Book> books = new HashSet<>();

}

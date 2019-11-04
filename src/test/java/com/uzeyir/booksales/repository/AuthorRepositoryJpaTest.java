package com.uzeyir.booksales.repository;

import com.uzeyir.booksales.model.Author;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthorRepositoryJpaTest {

    @Autowired
    AuthorRepositoryJpa authorRepositoryJpa;

    @Test
    public void authorInsert(){
        Author author = new Author();

        author.setName("Talha Talyan");

        authorRepositoryJpa.save(author);

        MatcherAssert.assertThat(author.getId(), Matchers.greaterThan(0L));
    }
}

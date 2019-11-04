package com.uzeyir.booksales.repository;

import com.uzeyir.booksales.model.Author;
import com.uzeyir.booksales.model.Book;
import com.uzeyir.booksales.model.Category;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolationException;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class BookRepositoryJpaTest {

    @Autowired
    BookRepositoryJpa bookRepositoryJpa;


    @Test
    public void bookInsert(){
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

        MatcherAssert.assertThat(book.getId(), Matchers.greaterThan(0L));
        MatcherAssert.assertThat(book.getName(),Matchers.equalTo("Selim Uzayda"));
    }

    @Test(expected = ConstraintViolationException.class)
    public void bookInsertError(){
        Book book = new Book();

        Category category = new Category();
        category.setName("Bilim-Kurgu");

        Author author = new Author();
        author.setName("Talha Talyan");


        book.setAuthors( Collections.singleton(author));

        book.setCategories(Collections.singleton(category));

        book.setDescription("Uzayda geçen bir hikaye");
        //book.setName("Selim Uzayda");

        bookRepositoryJpa.save(book);

        bookRepositoryJpa.flush();

    }
}

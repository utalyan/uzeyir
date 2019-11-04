package com.uzeyir.booksales.repository;

import com.uzeyir.booksales.model.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class CategoryRepositoryTest {

    @Autowired
    CategoryRepositoryJpa categoryRepositoryJpa;

    @Test
    public void category(){
        Category category = new Category();
        category.setName("Bilim-Kurgu");

        Category returnCategory = new Category();

        returnCategory = categoryRepositoryJpa.save(category);

        org.hamcrest.MatcherAssert.assertThat(returnCategory.getId(),org.hamcrest.Matchers.greaterThan(0L));
        org.hamcrest.MatcherAssert.assertThat(returnCategory.getName(),org.hamcrest.Matchers.equalTo("Bilim-Kurgu"));

    }

}

package com.uzeyir.booksales.service;

import com.uzeyir.booksales.model.Category;
import com.uzeyir.booksales.repository.CategoryRepositoryJpa;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CategoryServiceImplTest {

    @InjectMocks
    public CategoryServiceImpl categoryService;

    @Mock
    CategoryRepositoryJpa categoryRepositoryJpa;

    @Test
    public void categoryInsertSuccess(){

        Category category = new Category();
        category.setName("Kitap");

        org.mockito.Mockito.when(categoryRepositoryJpa.save(Mockito.any())).thenReturn(category);
        category = categoryService.create(category);

        org.hamcrest.MatcherAssert.assertThat(category.getName(),org.hamcrest.Matchers.equalTo("Kitap"));

    }
}

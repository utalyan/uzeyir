package com.uzeyir.booksales.service;

import com.uzeyir.booksales.model.Category;

import java.util.List;

public interface CategoryService {
    Category create(Category category);

    Category update(Category category);

    void delete(Long id);

    Category findById(Long id);

    List<Category> categoryList();
}

package com.uzeyir.booksales.service;

import com.uzeyir.booksales.model.Category;
import com.uzeyir.booksales.repository.CategoryRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepositoryJpa categoryRepositoryJpa;

    @Override
    @Transactional
    public Category create(Category category) {
        return categoryRepositoryJpa.save(category);
    }

    @Override
    @Transactional
    public Category update(Category category) {
        return categoryRepositoryJpa.save(category);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        categoryRepositoryJpa.deleteById(id);
    }

    @Override
    public Category findById(Long id) {
        return categoryRepositoryJpa.findById(id).get();
    }

    @Override
    public List<Category> categoryList() {
        return categoryRepositoryJpa.findAll();
    }
}

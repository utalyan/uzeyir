package com.uzeyir.booksales.service;

import com.uzeyir.booksales.model.User;
import com.uzeyir.booksales.repository.UserRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepositoryJpa userRepositoryJpa;

    @Override
    @Transactional
    public User create(User user) {
        return userRepositoryJpa.save(user);
    }

    @Override
    @Transactional
    public User update(User user) {
        return userRepositoryJpa.save(user);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        userRepositoryJpa.deleteById(id);
    }

    @Override
    public User findById(Long id) {
        return userRepositoryJpa.findById(id).get();
    }

    @Override
    public List<User> userList() {
        return userRepositoryJpa.findAll();
    }
}

package com.uzeyir.booksales.service;

import com.uzeyir.booksales.model.User;

import java.math.BigInteger;
import java.util.List;

/**
 * Kullanıcı tanımlama servisini içerir.
 */
public interface UserService {
    User create(User user);
    User update(User user);
    void delete(Long id);
    User findById(Long id);
    List<User> userList();
}

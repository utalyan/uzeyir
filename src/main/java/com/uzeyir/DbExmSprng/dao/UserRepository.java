package com.uzeyir.DbExmSprng.dao;

import java.util.List;

import com.uzeyir.DbExmSprng.model.User;

public interface UserRepository {

	 void create(User user);

	 boolean existsByName(String name);

	 List<User> findByName(String name);

	 List<User> userList();

}

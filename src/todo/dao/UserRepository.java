package todo.dao;

import java.util.List;

import todo.model.User;

public interface UserRepository {

	 void create(User user);

	 boolean existsByName(String name);

	 List<User> findByName(String name);

	 List<User> userList();

}

package todo.service;

import java.util.List;

import todo.dao.UserRepository;
import todo.dao.UserRepositoryImplJdbc;
import todo.model.User;

public class UserService {
	
	UserRepository userRepository = null;
	
	public UserService()
	{
		userRepository = new UserRepositoryImplJdbc();
	}
	
	public void create(User user)
	{
		userRepository.create(user);
	}
	
	public boolean existsByName(String name)
	{
		return userRepository.existsByName(name);
	}
	
	public List<User> getAllList()
	{
		return userRepository.userList();
	}
	
	public List<User> findByName(String name) {
		return userRepository.findByName(name);
	}
	
}

package com.uzeyir.DbExmSprng.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uzeyir.DbExmSprng.dao.UserRepository;
import com.uzeyir.DbExmSprng.model.User;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	
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

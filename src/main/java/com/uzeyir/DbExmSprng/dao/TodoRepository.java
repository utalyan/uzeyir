package com.uzeyir.DbExmSprng.dao;

import java.util.List;

import com.uzeyir.DbExmSprng.model.Todo;

public interface TodoRepository {

	void create(Todo todo);
	
	Todo update(Todo todo);
	void delete(Long id);

	Todo findById(Long id);

	List<Todo> todoList(Integer userId);

}
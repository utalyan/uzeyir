package com.uzeyir.DbExmSprng.service;

import java.util.List;

import com.uzeyir.DbExmSprng.model.Todo;

public interface TodoServiceJpaData {

	Todo create(Todo todo);
	
	Todo update(Todo todo);
	void delete(Integer id);

	Todo findById(Integer id);

	List<Todo> todoList(Integer userId);
}

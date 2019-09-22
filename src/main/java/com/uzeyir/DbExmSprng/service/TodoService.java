package com.uzeyir.DbExmSprng.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uzeyir.DbExmSprng.dao.TodoRepository;
import com.uzeyir.DbExmSprng.model.Todo;

@Service
@Transactional
public class TodoService implements TodoRepository {
	
	@Autowired
	private TodoRepository todoRepository;
	
	@Override
	public void create(Todo todo) {
		todoRepository.create(todo);

	}

	@Override
	public Todo update(Todo todo) {
		return todoRepository.update(todo);
	}

	@Override
	public void delete(Long id) {
		todoRepository.delete(id);

	}

	@Override
	public Todo findById(Long id) {
		return todoRepository.findById(id);
	}

	@Override
	public List<Todo> todoList(Integer userId) {
		return todoRepository.todoList(userId);
	}

}

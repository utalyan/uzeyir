package com.uzeyir.DbExmSprng.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uzeyir.DbExmSprng.dao.TodoRepositoryJpaData;
import com.uzeyir.DbExmSprng.model.Todo;

@Service
public class TodoServiceJpaDataImpl implements TodoServiceJpaData {

	@Autowired
	TodoRepositoryJpaData todoRepository;
	
	
	@Override
	public Todo create(Todo todo) {

		return todoRepository.save(todo);
	}

	@Override
	public Todo update(Todo todo) {
		return todoRepository.save(todo);
	}

	@Override
	public void delete(Integer id) {
		todoRepository.deleteById(id);

	}

	@Override
	public Todo findById(Integer id) {
		return todoRepository.findById(id).get();
	}

	@Override
	public List<Todo> todoList(Integer userId) {
		return todoRepository.findAll();
	}

}

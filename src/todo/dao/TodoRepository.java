package todo.dao;

import java.util.List;

import todo.model.Todo;

public interface TodoRepository {

	void create(Todo todo);
	
	Todo update(Todo todo);
	void delete(Long id);

	Todo findById(Long id);

	List<Todo> todoList(Integer userId);

}
package todo.service;

import java.util.List;

import todo.dao.TodoRepository;
import todo.dao.TodoRepositoryImplJdbc;
import todo.model.Todo;

public class TodoService {

	TodoRepository todoRepository = null;
	
	public TodoService()
	{
		todoRepository = new TodoRepositoryImplJdbc();
	}
	public void create(Todo todo) {
		todoRepository.create(todo);
	}

	public Todo update(Todo todo) {
		
		return todoRepository.update(todo);
	}

	public void delete(Long id) {
		todoRepository.delete(id);
		
	}

	public Todo findById(Long id) {
		return todoRepository.findById(id);
	}

	public List<Todo> todoList(Integer userId) {
		return todoRepository.todoList(userId);
	}

}

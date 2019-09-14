package todo.dao;

import java.util.List;

import todo.DbHelper;
import todo.model.Todo;

public class TodoRepositoryImplJdbc implements TodoRepository {

	DbHelper dbHelper = null;
	
	public TodoRepositoryImplJdbc() {
		dbHelper = new DbHelper();
	
	}
	@Override
	public void create(Todo todo) {
		String sql = "INSERT INTO TODO (id,description,status,user_id) VALUES ("+dbHelper.getTodoId()+",'"+todo.getDescription()+"',"+todo.isStatus()+","+todo.getUserId()+")";
		
		dbHelper.executeUpdate(sql);
	}

	@Override
	public Todo update(Todo todo) {
		
		Todo returnTodo = null;
		
		String sql = "UPDATE TODO SET description = '" + todo.getDescription() + "',status = " + todo.isStatus() + " WHERE id = " + todo.getId();
		
		dbHelper.executeUpdate(sql);
		
		sql = "select * from TODO where id = " + todo.getId();
		
		List<Todo> todoList = null;
		
		todoList = dbHelper.todoExecuteQuery(sql);
		
		if (todoList.size() > 0) {
			returnTodo = todoList.get(0);
		}
		
		return returnTodo;
	}

	@Override
	public void delete(Long id) {
		String sql = "delete from TODO where id = " + id;
		
		dbHelper.executeUpdate(sql);
	}

	@Override
	public Todo findById(Long id) {
		
		Todo returnTodo = null;
		
		String sql = "select id,description,status,user_id from TODO where id = " + id;
		
		List<Todo> todoList = null;
		
		todoList = dbHelper.todoExecuteQuery(sql);
		
		if (todoList.size() > 0) {
			returnTodo = todoList.get(0);
		}
		
		return returnTodo;

	}

	@Override
	public List<Todo> todoList(Integer userId) {
		
		String sql = "select id,description,status,user_id from TODO where user_id = " + userId;
		
		return dbHelper.todoExecuteQuery(sql);
	}

}

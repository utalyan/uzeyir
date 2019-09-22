package com.uzeyir.DbExmSprng;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uzeyir.DbExmSprng.model.Todo;
import com.uzeyir.DbExmSprng.model.User;
import com.uzeyir.DbExmSprng.service.TodoService;
import com.uzeyir.DbExmSprng.service.UserService;

@RestController
@RequestMapping("/todo")
public class TodoRestController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private TodoService todoService;

	
	@RequestMapping(method = RequestMethod.GET,value = "/user/create")
	public void userCreate(User user) {
		userService.create(user);
	}
	
	@RequestMapping(method = RequestMethod.GET,value="/user/list")
	public ResponseEntity<List<User>> getUsers() {
		
		List<User>  users =userService.getAllList();
		
		return ResponseEntity.ok(users);	
	}

	@RequestMapping(method=RequestMethod.GET,value="/todo/create")
	public void todoCreate(Todo todo) {
		todoService.create(todo);
	}
	
	@RequestMapping(method = RequestMethod.GET,value="/todo/update")
	public Todo todoUpdate(Todo todo) {
		return todoService.update(todo);
	}
	
	public void todoDlete(Long id) {
		todoService.delete(id);
	}
	
	public ResponseEntity<List<Todo>> todoList(int userId) {
		List<Todo> users =todoService.todoList(userId);
		
		return ResponseEntity.ok(users);
		
		
	}

}

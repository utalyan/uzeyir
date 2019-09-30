package com.uzeyir.DbExmSprng;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.uzeyir.DbExmSprng.model.Todo;
import com.uzeyir.DbExmSprng.model.User;
import com.uzeyir.DbExmSprng.service.TodoServiceJpaDataImpl;
import com.uzeyir.DbExmSprng.service.UserService;

@RestController
public class TodoRestController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private TodoServiceJpaDataImpl todoService;

	
	@RequestMapping(method = RequestMethod.GET,value = "/user/create")
	public void userCreate(User user) {
		userService.create(user);
	}
	
	@RequestMapping(method = RequestMethod.GET,value="/user/list")
	public ResponseEntity<List<User>> getUsers() {
		
		List<User>  users =userService.getAllList();
		
		return ResponseEntity.ok(users);	
	}

	@PostMapping( path="/todo/create",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Todo todoCreate(@RequestBody Todo todo) 
	{
//		todo.setDescription("değiştirdim");
		return todoService.create(todo);
	}

	@PostMapping( path="/todo/create/test",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public Todo todoCreate2() {
		Todo todo = new Todo();
		todo.setId(1);
		todo.setDescription("deneme");
		todo.setStatus(true);
		todo.setUserId(3);
		return todo;
	}

	@PutMapping(path="/todo/update")
	public Todo todoUpdate(Todo todo) {
		return todoService.update(todo);
	}
	@DeleteMapping(path="/todo/delete/{id}")
	public void todoDlete(@PathVariable Integer id) {
		todoService.delete(id);
	}
	
	@GetMapping(path="/todo/list/{userId}")
	public ResponseEntity<List<Todo>> todoList(@PathVariable Integer userId) {
		List<Todo> todos =todoService.todoList(userId);
		
		return ResponseEntity.ok(todos);
		
		
	}

}

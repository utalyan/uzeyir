package todo.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import todo.model.User;
import todo.service.UserService;

class UserServiceTest {

	@Test
	void test() {
		UserService userService = new UserService();
		
		User user = new User();
		user.setName("Test User");
		
		userService.create(user);
		
		assertEquals(userService.existsByName("Test User"),true);
		
		assertEquals(userService.findByName("Test User").get(0).getName(), "Test User");
		
		
	}

}

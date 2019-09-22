package com.uzeyir.DbExmSprng;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.uzeyir.DbExmSprng.model.User;
import com.uzeyir.DbExmSprng.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DbExmSprngApplicationTests {

	@Autowired
	private UserService userService;
	
	@Test
	public void userCreate() {
		User user = new User();
		
		user.setName("Talha");
		
		userService.create(user);
		
		boolean bl = userService.existsByName("Talha");
		
		
		
		MatcherAssert.assertThat(bl, Matchers.equalTo(true));
		
//		MatcherAssert.assertThat(userService.findByName("Talha").get(0).getName(), Matchers.equalTo("Talha"));
	}

}

package com.uzeyir.booksales.service;


import com.uzeyir.booksales.model.Address;
import com.uzeyir.booksales.model.User;
import com.uzeyir.booksales.repository.UserRepositoryJpa;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @Mock
    public UserRepositoryJpa userRepositoryJpa;

    @InjectMocks
    public UserServiceImpl userService;

    @Test
    public void userInsertSuccess(){

        User user = new User();
        Address address = new Address();
        address.setAddress("İstanbul");

        user.setName("Talha");
        user.setAddress(address);

        org.mockito.Mockito.when(userRepositoryJpa.save(org.mockito.Mockito.any())).thenReturn(user);

        user = userService.create(user);

        org.hamcrest.MatcherAssert.assertThat(user.getName(),org.hamcrest.Matchers.equalTo("Talha"));

    }

}

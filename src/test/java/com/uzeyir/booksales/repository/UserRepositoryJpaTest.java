package com.uzeyir.booksales.repository;

import com.uzeyir.booksales.model.Address;
import com.uzeyir.booksales.model.Category;
import com.uzeyir.booksales.model.User;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.validation.*;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserRepositoryJpaTest {

    @Autowired
    UserRepositoryJpa userRepositoryJpa;

    @Autowired
    CategoryRepositoryJpa categoryRepositoryJpa;

    @Autowired
    EntityManager entityManager;

    private static ValidatorFactory validatorFactory;
    private static Validator validator;

    @BeforeClass
    public static void createValidator() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @AfterClass
    public static void close() {
        validatorFactory.close();
    }

    @Test
    public void user(){
        User user = new User();
        user.setName("üzeyir");
        user.setMailAddress("utalyan@hotmail.com");
        Address address = new Address();
        address.setAddress("istanbul");
        user.setAddress(address);

        User returnUser = new User();

        returnUser = userRepositoryJpa.save(user);

        org.hamcrest.MatcherAssert.assertThat(returnUser.getId(),org.hamcrest.Matchers.greaterThan(Long.valueOf(0)));
        org.hamcrest.MatcherAssert.assertThat(returnUser.getMailAddress(),org.hamcrest.Matchers.equalTo("utalyan@hotmail.com"));
        org.hamcrest.MatcherAssert.assertThat(returnUser.getAddress().getAddress(),org.hamcrest.Matchers.equalTo("istanbul"));

    }

    @Test(expected = ConstraintViolationException.class)
    public void userError(){
        User user = new User();
        user.setName("üzeyir");
        user.setMailAddress("utalyan");
        Address address = new Address();
        address.setAddress("istanbul");
        user.setAddress(address);

        User returnUser = new User();

        returnUser = userRepositoryJpa.save(user);

        entityManager.flush();
    }

    @Ignore
    public void userMailAddressError(){
        User user = new User();
        user.setName("üzeyir");
        user.setMailAddress("utalyan");
        Address address = new Address();
        address.setAddress("istanbul");
        user.setAddress(address);

        //User returnUser = new User();

        //returnUser = userRepositoryJpa.save(user);

        Set<ConstraintViolation<User>> violations = validator.validate(user);

        Assert.assertEquals(violations.size(), 1);

        ConstraintViolation<User> violation = violations.iterator().next();
        Assert.assertEquals("Hatalı e-mail", violation.getMessage());
        Assert.assertEquals("mailAddress", violation.getPropertyPath().toString());
        Assert.assertEquals("utalyan", violation.getInvalidValue());
    }

    @Test
    public void userGet(){
        User user = new User();
        user.setName("üzeyir");
        user.setMailAddress("utalyan@hotmail.com");
        Address address = new Address();
        address.setAddress("istanbul");
        user.setAddress(address);

        User returnUser = new User();

        returnUser = userRepositoryJpa.save(user);

        User  getUser = new User();

        getUser = userRepositoryJpa.findById(Long.valueOf(returnUser.getId())).get();

        MatcherAssert.assertThat(returnUser.getMailAddress(), Matchers.equalTo(getUser.getMailAddress()));

    }

}

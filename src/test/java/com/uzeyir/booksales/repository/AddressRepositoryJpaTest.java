package com.uzeyir.booksales.repository;

import com.uzeyir.booksales.model.Address;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressRepositoryJpaTest {

    @Autowired
    AddressRepositoryJpa addressRepositoryJpa;

    @Test
    @Transactional
    public void addressInsert(){
        Address address = new Address();

        address.setAddress("Sefaköy / İstanbul");

        addressRepositoryJpa.save(address);

        MatcherAssert.assertThat(address.getId(),Matchers.greaterThan(0L));
    }
}

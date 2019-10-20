package com.uzeyir.booksales.repository;

import com.uzeyir.booksales.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface AddressRepositoryJpa extends JpaRepository<Address, BigInteger> {
}

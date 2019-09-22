package com.uzeyir.DbExmSprng.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.uzeyir.DbExmSprng.model.User;

@Repository
public class UserRepositoryImplJpa implements UserRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void create(User user) {
		entityManager.persist(user);

	}

	@Override
	public boolean existsByName(String name) {
		return entityManager.createQuery("from User where name = :name",User.class).setParameter("name", name).getResultList().size() > 0;
	}

	@Override
	public List<User> findByName(String name) {
		return entityManager.createQuery("from User where name = :name ",User.class).setParameter("name", name).getResultList();
	}

	@Override
	public List<User> userList() {
		return entityManager.createQuery("from User",User.class).getResultList();
	}

}

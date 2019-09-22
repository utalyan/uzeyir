package com.uzeyir.DbExmSprng.dao;

import java.security.acl.Owner;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.uzeyir.DbExmSprng.model.Todo;

@Repository
public class TodoRepositoryImplJpa implements TodoRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void create(Todo todo) {
		entityManager.persist(todo);

	}

	@Override
	public Todo update(Todo todo) {
		return entityManager.merge(todo);
	}

	@Override
	public void delete(Long id) {
		entityManager.remove(entityManager.getReference(Owner.class, id));

	}

	@Override
	public Todo findById(Long id) {
		return entityManager.find(Todo.class, id);
	
	}

	@Override
	public List<Todo> todoList(Integer userId) {
		return entityManager.createQuery("from Todo where userId = :userid",Todo.class).setParameter("userid", userId).getResultList();
	}

}

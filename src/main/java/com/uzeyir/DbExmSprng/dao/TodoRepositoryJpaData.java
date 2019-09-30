package com.uzeyir.DbExmSprng.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uzeyir.DbExmSprng.model.Todo;

@Repository
public interface TodoRepositoryJpaData extends JpaRepository<Todo, Integer>{

}

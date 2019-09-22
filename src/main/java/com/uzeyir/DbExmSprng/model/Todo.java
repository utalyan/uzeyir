package com.uzeyir.DbExmSprng.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

public class Todo {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "todoSeqGen")
	@SequenceGenerator(name="todoSeqGen",sequenceName = "todo_sequence")
	private Integer id;
	
	@Column(name="description")
	private String description ;
	
	@Column(name="status")
	private boolean status;
	
	@Column(name="user_id")
	private Integer userId;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	
}

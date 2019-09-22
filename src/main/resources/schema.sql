CREATE TABLE user (id INTEGER not NULL, name VARCHAR(255),   
	           PRIMARY KEY ( id )); 

CREATE TABLE   todo (id INTEGER not NULL, 
		     description VARCHAR(255), status BOOLEAN, 
	             user_id INTEGER, PRIMARY KEY ( id )); 

create sequence todo_sequence; 


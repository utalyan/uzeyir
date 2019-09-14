package todo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import todo.model.Todo;
import todo.model.User;

public class DbHelper {

    // JDBC driver name and database URL 
    static final String JDBC_DRIVER = "org.h2.Driver";   
    static final String DB_URL = "jdbc:h2:~/firstDb";  
   
    //  Database credentials 
    static final String USER = "sa"; 
    static final String PASS = ""; 

    Connection conn = null; 
    Statement stmt = null; 

    
    public DbHelper() {

    	if (!isCreated()) {
			createUserObject();
		}
	}

	private boolean isCreated()
	{
		String sql = "select count(1) from INFORMATION_SCHEMA.TABLES  where table_name = 'USER'";
		Integer rCount=0;

		rCount = this.singleReturnInt(sql);

		return rCount > 0;
	}

	private void createUserObject()
	{
		this.connectionOpen();

        try {
			stmt = conn.createStatement();

			String sql =  "CREATE TABLE user (id INTEGER not NULL, name VARCHAR(255), " +  
	                " PRIMARY KEY ( id )); CREATE TABLE   todo (id INTEGER not NULL, " + 
	                " description VARCHAR(255), status BOOLEAN, " +  
	                " user_id INTEGER, PRIMARY KEY ( id )); create sequence todo_seq; create sequence user_seq;";  

			stmt.executeUpdate(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        finally {
			this.connectionClose();
		}
	}
	
	private void connectionOpen()
	{

        // STEP 1: Register JDBC driver 
        try {
			Class.forName(JDBC_DRIVER);

	        //STEP 2: Open a connection 
	        conn = DriverManager.getConnection(DB_URL,USER,PASS);  

        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
            

	}
	
	private void connectionClose()
	{
		
        // STEP 4: Clean-up environment 
		try {
			if (stmt != null)
			{
				stmt.close();
			};
        	
			if (conn != null)
			{
				conn.close();
			};
			
			stmt = null;
			conn = null;

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        
	}
	
	public Integer getUserId()
	{
		Integer userId=0;
		
		String sql = "select user_seq.nextval from dual";
		
		userId = this.singleReturnInt(sql);
		
		return userId;
	}
	
	public Integer getTodoId()
	{
		Integer todoId=0;
		
		String sql = "select todo_seq.nextval from dual";
		
		todoId = this.singleReturnInt(sql);
		
		return todoId;
	}

    public Integer singleReturnInt(String sql)
    {
		ResultSet rs;
		Integer returnValue=0;
		
		this.connectionOpen();
		
		try {
			rs = conn.prepareStatement(sql).executeQuery();
			if(rs.next()) returnValue = rs.getInt(1) ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.connectionClose();
		}
    	
		return returnValue;
    }
    
    public Integer executeUpdate(String sql)
    {
    	Integer rCount = 0;
    	
    	this.connectionOpen();
    	
    	try {
			rCount = conn.prepareStatement(sql).executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	finally {
        	this.connectionClose();
			
		}
    	    	
    	return rCount;
    	
    }

    public List<User> userExecuteQuery(String sql)
    {
    	ResultSet result = null;
    	List<User> userList = null;
    	
    	this.connectionOpen();
    	
    	try {
			result = conn.prepareStatement(sql).executeQuery();
			userList = this.userMapRow(result);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	finally {
        	this.connectionClose();
			
		}
    	    	
    	return userList;
    	
    }
    
	private List<User> userMapRow(ResultSet rs) {
		// TODO Auto-generated method stub
		User user = new User();
		List<User> userL = new ArrayList<>();

		try {
			while (rs.next()) {
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				
				userL.add(user);
				
				user = null;
				user = new User();
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		


		return userL;
	}


    public List<Todo> todoExecuteQuery(String sql)
    {
    	ResultSet result = null;
    	List<Todo> todoList = null;
    	
    	this.connectionOpen();
    	
    	try {
			result = conn.prepareStatement(sql).executeQuery();
			todoList = this.todoMapRow(result);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	finally {
        	this.connectionClose();
			
		}
    	    	
    	return todoList;
    	
    }
    
	private List<Todo> todoMapRow(ResultSet rs) {
		// TODO Auto-generated method stub
		Todo todo = new Todo();
		List<Todo> todoL = new ArrayList<>();

		try {
			while (rs.next()) {
				todo.setId(rs.getInt("id"));
				todo.setDescription(rs.getString("description"));
				todo.setStatus(rs.getBoolean("status"));
				todo.setUserId(rs.getInt("user_id"));
				todoL.add(todo);
				
				todo = null;
				todo = new Todo();
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		


		return todoL;
	}


}

package todo.dao;

import java.util.List;

import todo.DbHelper;
import todo.model.User;

public class UserRepositoryImplJdbc implements UserRepository {

	final DbHelper dbHelper ;
	
	public UserRepositoryImplJdbc()
	{
		dbHelper = new DbHelper(); 
	}
	
	public void create(User user)
	{
		String sql ="INSERT INTO user(id,name) values ("+ dbHelper.getUserId() +",'"+ user.getName() +"')";
		
		dbHelper.executeUpdate(sql);
	}

	public boolean existsByName(String name)
	{
		String sql = "Select count(1) from user where name ='" + name + "'";
		
		return dbHelper.singleReturnInt(sql) > 0;
		
	}
	

	public List<User> findByName(String name)
	{
		String sql = "Select id,name from user where name ='" + name + "'";
		
		return dbHelper.userExecuteQuery(sql);
		
	}
	public List<User> userList()
	{
		String sql = "Select id,name from user";
		
		return dbHelper.userExecuteQuery(sql);
	}
	

}

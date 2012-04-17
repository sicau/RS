package cn.edu.sicau.rs.dao;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.List;

import cn.edu.sicau.rs.bean.User;
import cn.edu.sicau.rs.bean.UserPager;

public interface UserDao {
	public boolean saveUser(User user);    // 注册
	
	public User userLogin(String name,String password);  //
	//public boolean checkNameExist(String name);   //
	public User getUser(Serializable id);   //得到一个用户

	public boolean updateUser(User user);   //

	public boolean updateSignInfo(User user);   //
	
	boolean updatePassword(String username, String password);
	
	public ResultSet getUsers(int type);

	public List getAllUsers();
	
	public boolean checkNameExist(String username);
	
	public String setSignumber();
}

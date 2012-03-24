package cn.edu.sicau.rs.dao;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

import cn.edu.sicau.rs.bean.User;

public interface UserDao {
	public boolean saveUser(User user);    // 注册
	public User userLogin(String name,String password);  //
	public boolean checkNameExist(String name);   //
	public User getUser(int id);   //得到一个用户
	public ResultSet getUsers();   //得到所有用户
	public boolean updateUser(User user);   //
	public boolean updatePassword(String username, String password);   //
	public boolean updateSignInfo(User user);   //
}

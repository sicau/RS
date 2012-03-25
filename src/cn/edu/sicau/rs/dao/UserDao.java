package cn.edu.sicau.rs.dao;

import java.io.Serializable;
import java.util.Map;

import cn.edu.sicau.rs.bean.User;

public interface UserDao {
	public boolean saveUser(User user);    // 注册
	public User userLogin(String name,String password);  //
	//public boolean checkNameExist(String name);   //
	public User getUser(Serializable id);   //得到一个用户

	public boolean updatePassword(String username, String password);   //
	public boolean updateSignInfo(User user);   //
}

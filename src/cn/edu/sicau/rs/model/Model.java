package cn.edu.sicau.rs.model;

import cn.edu.sicau.rs.bean.User;
import cn.edu.sicau.rs.dao.UserDao;
import cn.edu.sicau.rs.daoimpl.UserDaoImpl;

public class Model {
	private UserDao ud = new UserDaoImpl();
	
	public boolean saveUser(User user) {
		return ud.saveUser(user);
	}
	
	
	public User userLogin(String name,String password) {
		return ud.userLogin(name, password);
	}
	
	
	public boolean checkNameExist(String name) {
		return ud.checkNameExist(name);
	}
	
	
	public boolean updateUser(User user) {
		return ud.updateUser(user);
	}
	
	public User getUser(int id) {
		return ud.getUser(id);
	}
	
	public boolean updatePassword (String username, String password) {
		return ud.updatePassword(username,  password );
	}

}

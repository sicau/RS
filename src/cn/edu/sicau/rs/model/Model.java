package cn.edu.sicau.rs.model;

import java.util.List;
import java.util.Map;

import cn.edu.sicau.rs.bean.Admin;
import cn.edu.sicau.rs.bean.User;
import cn.edu.sicau.rs.bean.UserPager;
import cn.edu.sicau.rs.dao.AdminLoginDao;
import cn.edu.sicau.rs.dao.AdminUserDao;
import cn.edu.sicau.rs.dao.UserDao;
import cn.edu.sicau.rs.daoimpl.AdminLoginDaoImpl;
import cn.edu.sicau.rs.daoimpl.AdminUserDaoImpl;
import cn.edu.sicau.rs.daoimpl.UserDaoImpl;

public class Model {
	private UserDao ud = new UserDaoImpl();
                
	/*user*/	
	public boolean saveUser(User user) {
		return ud.saveUser(user);
	}
	
	
	public User userLogin(String name,String password) {
		return ud.userLogin(name, password);
	}
	
	
//	public boolean checkNameExist(String name) {
//		return ud.checkNameExist(name);
//	}
	
	
	
	public User getUser(int id) {
		return ud.getUser(id);
	}
	
//	public Map getAllUsers() {
//		return ud.getAllUsers();
//	}
	
	public boolean updatePassword (String username, String password) {
		return ud.updatePassword(username,  password );
	}
	
	public boolean updateSignInfo(User user) {
		return ud.updateSignInfo(user);
	}
	
	
	/*admin*/
    AdminLoginDao ald = new AdminLoginDaoImpl();
    AdminUserDao aud = new AdminUserDaoImpl();
	public boolean login (Admin admin) {
		return ald.login(admin);
	}
	public boolean updatePassword(Admin admin) {
		return ald.updatePassword(admin);
	}
	public boolean createAdmin(String adminname,String password) {
		return ald.createAdmin(adminname, password);
	}
	
	public List getAllUsers() {
		return aud.getAllUsers();
	}
	public boolean deleteUserById(int id) {
		return aud.deleteUserById(id);
	}
	public boolean deleteUsers(int [] ids) {
		return aud.deleteUsers(ids);
	}
	public boolean verifyStu(int id, int type) {
		return aud.verifyStu(id, type);
	}


}

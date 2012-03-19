package cn.edu.sicau.rs.dao;

import java.util.List;
import cn.edu.sicau.rs.bean.User;

public interface UserDao {
	public boolean saveUser(User user);
	public User userLogin(String name,String password);
	public boolean checkNameExist(String name);
	public User getUser(int id);
	public boolean updateUser(User user);
	public boolean updatePassword(String username, String password);
	public boolean updateSignInfo(User user);
}

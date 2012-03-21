package cn.edu.sicau.rs.dao;

import java.util.Map;

import cn.edu.sicau.rs.bean.User;

public interface UserDao {
	public boolean saveUser(User user);    // ע��
	public User userLogin(String name,String password);  //
	public boolean checkNameExist(String name);   //
	public User getUser(int id);   //�õ�һ���û�
//	public Map getAllUsers();   //�õ������û�
	public boolean updateUser(User user);   //
	public boolean updatePassword(String username, String password);   //
	public boolean updateSignInfo(User user);   //
}

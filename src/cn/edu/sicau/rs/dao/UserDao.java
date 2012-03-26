package cn.edu.sicau.rs.dao;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.List;

import cn.edu.sicau.rs.bean.User;

public interface UserDao {
	public boolean saveUser(User user);    // ע��
	public User userLogin(String name,String password);  //
	//public boolean checkNameExist(String name);   //
	public User getUser(Serializable id);   //�õ�һ���û�

	public ResultSet getUsers();   //�õ������û�
	public boolean updateUser(User user);   //

	public boolean updateSignInfo(User user);   //
	boolean updatePassword(String username, String password);
}

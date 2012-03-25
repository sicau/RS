package cn.edu.sicau.rs.dao;

import java.io.Serializable;
import java.util.Map;

import cn.edu.sicau.rs.bean.User;

public interface UserDao {
	public boolean saveUser(User user);    // ע��
	public User userLogin(String name,String password);  //
	//public boolean checkNameExist(String name);   //
	public User getUser(Serializable id);   //�õ�һ���û�

	public boolean updatePassword(String username, String password);   //
	public boolean updateSignInfo(User user);   //
}

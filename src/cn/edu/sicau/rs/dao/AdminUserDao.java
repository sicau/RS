package cn.edu.sicau.rs.dao;

import java.util.Map;

import cn.edu.sicau.rs.bean.UserPager;

public interface AdminUserDao {
	public Map getAllUsers();
	public boolean deleteUserById(int id);
	public boolean deleteUsers(int [] ids);
	public UserPager getUserPager(int index, int pageSize);

}

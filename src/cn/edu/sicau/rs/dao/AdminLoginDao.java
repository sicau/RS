package cn.edu.sicau.rs.dao;

import cn.edu.sicau.rs.bean.Admin;

public interface AdminLoginDao {
	
	public Admin login (Admin admin);
	public boolean updatePassword(Admin admin);
	public boolean createAdmin(String adminname,String password);

}

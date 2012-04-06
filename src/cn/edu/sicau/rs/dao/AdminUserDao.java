package cn.edu.sicau.rs.dao;

import java.util.List;

import cn.edu.sicau.rs.bean.Admin;
import cn.edu.sicau.rs.bean.UserPager;

public interface AdminUserDao {
	public List getAllAdmin();
	public boolean deleteUserById(int id);
	public boolean deleteUsers(int [] ids);
	public UserPager getUserPager(int index, int pageSize);
	public boolean verifyStu(int id, int type);
	public List stuList(int type);
	public boolean changeStuStatus(int id, int type);
	public Admin getAdmin(int id);
}

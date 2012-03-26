package cn.edu.sicau.rs.dao;

import java.util.List;
import cn.edu.sicau.rs.bean.UserPager;

public interface AdminUserDao {
	public List getAllUsers();
	public boolean deleteUserById(int id);
	public boolean deleteUsers(int [] ids);
	public UserPager getUserPager(int index, int pageSize);
	public boolean verifyStu(int id, int type);

}

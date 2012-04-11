package cn.edu.sicau.rs.model;

import java.util.List;
import java.util.Map;
import java.sql.ResultSet;
import java.util.List;
import cn.edu.sicau.rs.bean.Admin;
import cn.edu.sicau.rs.bean.News;
import cn.edu.sicau.rs.bean.NewsPager;
import cn.edu.sicau.rs.bean.User;
import cn.edu.sicau.rs.bean.UserPager;
import cn.edu.sicau.rs.dao.AdminLoginDao;
import cn.edu.sicau.rs.dao.AdminUserDao;
import cn.edu.sicau.rs.dao.NewsDao;
import cn.edu.sicau.rs.dao.UserDao;
import cn.edu.sicau.rs.daoimpl.AdminLoginDaoImpl;
import cn.edu.sicau.rs.daoimpl.AdminUserDaoImpl;
import cn.edu.sicau.rs.daoimpl.NewsDaoImpl;
import cn.edu.sicau.rs.daoimpl.UserDaoImpl;

public class Model {
	private UserDao ud = new UserDaoImpl();
                
	/*user*/	
	public boolean saveUser(User user) {
		return ud.saveUser(user);
	}
	
	public boolean updateUser(User user) {
		return ud.updateUser(user);
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
	
	public ResultSet getUsers(int type) {
		return ud.getUsers(type);
	}
	
	public List getAllUsers() {
		return ud.getAllUsers();
	}
	
	public boolean updatePassword (String username, String password) {
		return ud.updatePassword(username,  password );
	}
	
	public boolean updateSignInfo(User user) {
		return ud.updateSignInfo(user);
	}
	
	
	/*admin*/
    AdminLoginDao ald = new AdminLoginDaoImpl();
    AdminUserDao aud = new AdminUserDaoImpl();
	public Admin login (Admin admin) {
		return ald.login(admin);
	}
	public boolean updatePassword(Admin admin) {
		return ald.updatePassword(admin);
	}
	public boolean createAdmin(String adminname,String password,int type) {
		return ald.createAdmin(adminname, password, type);
	}
	public boolean deleteAdmin(int id) {
		return ald.deleteadmin(id);
	}
	
	public Admin getAdmin(int id) {
		return aud.getAdmin(id);
	}
	
	public List getAllAdmin() {
		return aud.getAllAdmin();
	}
	
	public boolean changeStuStatus(int id,int type) {
		return aud.changeStuStatus(id,type);
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
	
	public List stuList(int type) {
		return aud.stuList(type);
	}
	public UserPager getUserPage(int index, int pageSize,int type) {
		return aud.getUserPager(index, pageSize,type);
	}

	/*news*/
	NewsDao nd = new NewsDaoImpl();
	public boolean addNews(News news){
		return nd.addNews(news);
	}
	public boolean delNews(int ids[]) {
		return nd.delNews(ids);
	}
	public boolean delNews(int id) {
		return nd.delNews(id);
	}
	public boolean updateNews() {
		return nd.updateNews();
	}
	public Map getAllNews(int type) {
		return nd.getAllNews(type);
	}
	public List getAllNewses() {
		return nd.getAllNewses();
	}
	public News getByID(int id) {
		return nd.getByID(id);
	}
	public boolean topSign(int id,String top) {
		return nd.topSign(id, top);
	}
	public NewsPager getNewsPager(int index, int pageSize, int type) {
		return nd.getNewsPager(index, pageSize, type);
	}

}

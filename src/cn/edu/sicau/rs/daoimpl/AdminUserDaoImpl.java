package cn.edu.sicau.rs.daoimpl;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;



import cn.edu.sicau.rs.bean.Admin;
import cn.edu.sicau.rs.bean.User;
import cn.edu.sicau.rs.bean.UserPager;
import cn.edu.sicau.rs.common.DbUtil;
import cn.edu.sicau.rs.common.HibernateUtil;
import cn.edu.sicau.rs.dao.AdminUserDao;

public class AdminUserDaoImpl implements AdminUserDao {

	@Override
	public List getAllAdmin() {
		Session s = null;
		Transaction tx = null;
		List adminList = null;
		try {
			s = HibernateUtil.getSession();
			String hql = "from Admin as admin";
			Query query = s.createQuery(hql);
			adminList = query.list();
		}catch(HibernateException e) {
			e.printStackTrace();
		}
		return adminList;
	}

	public List getAllUser() {
		Session s = null;
		Transaction tx = null;
		List stuList = null;
		try {
			s = HibernateUtil.getSession();
			String hql = "from User as User";
			Query query = s.createQuery(hql);
			stuList = query.list();
		}catch(HibernateException e) {
			e.printStackTrace();
		}
		return stuList;
	}
	
	public List getAllUser(int type) {
		Session s = null;
		Transaction tx = null;
		List stuList = null;
		try {
			s = HibernateUtil.getSession();
			String hql = "from User user where user.type = ?";
		//	update User user set user.type = ? where user.id = ?
			Query query = s.createQuery(hql);
			query.setLong(0, type);
			stuList = query.list();
		}catch(HibernateException e) {
			e.printStackTrace();
		}
		return stuList;
	}
	
	@Override
	public boolean deleteUserById(int id) {
		// TODO Auto-generated method stub
		DbUtil dbutil = null;
		PreparedStatement ps = null;
		String sql = "delete from tb_user where id = ?";
		try {
			dbutil = new DbUtil();
			ps = dbutil.getCon().prepareStatement(sql);
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			if(i != 0) {
				return true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				dbutil.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public boolean deleteUsers(int[] ids) {
		// TODO Auto-generated method stub
		DbUtil dbutil = null;
		PreparedStatement ps= null;
		Connection conn = null;
		String sql = "delete from tb_user where id = ?";
		try {
			dbutil = new DbUtil();
			conn = dbutil.getCon();
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			for(int j = 0;j<ids.length;j++) {
				ps.setInt(1, ids[j]);
				ps.addBatch();
			}
			int[] k = ps.executeBatch();
			conn.commit();
			if(k.length == ids.length){
				return true;
			}
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}finally {
			try {
				ps.close();
				dbutil.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public UserPager getUserPager(int index, int pageSize, int type) {
		// TODO Auto-generated method stub
		Map userMap = new HashMap();
		DbUtil dbutil = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = null;
		try {
			dbutil = new DbUtil();
			if(type==0) {
				sql = "select * from tb_user limit ?,? ";
				ps = dbutil.getCon().prepareStatement(sql);
				ps.setInt(1, index);
				ps.setInt(2, pageSize);
			} else {
				sql = "select * from tb_user where type = ? limit ?,? ";
				ps = dbutil.getCon().prepareStatement(sql);
				ps.setInt(1, type);
				ps.setInt(2, index);
				ps.setInt(3, pageSize);
			}
			
			rs = ps.executeQuery();
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setSigNumber(rs.getString("sigNumber"));
				user.setUserName(rs.getString("userName"));
				user.setPassword(rs.getString("password"));
				user.setTrueName(rs.getString("trueName"));
				user.setTestNumber(rs.getString("testNumber"));
				user.setSex(rs.getString("sex"));
				user.setBirthday(rs.getString("birthday"));
				user.setPolitics(rs.getString("politics"));
				user.setIdentity(rs.getString("identity"));
				user.setSubject(rs.getString("subject"));
				user.setSchool(rs.getString("school"));
				user.setPhone(rs.getString("phone"));
				user.setMphone(rs.getString("mphone"));
				user.setSa(rs.getString("sa"));
				user.setSpostcode(rs.getString("spostcode"));
				user.setHa(rs.getString("ha"));
				user.setHpostcode(rs.getString("hpostcode"));
				user.setLang(rs.getString("lang"));
				user.setCategory(rs.getString("category"));
				user.setPrize(rs.getString("prize"));
				user.setSpeciality(rs.getString("speciality"));
				user.setType(rs.getString("type"));    
				userMap.put(new Integer(user.getId()),user);  
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				dbutil.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		UserPager up = new UserPager();
		up.setUserMap(userMap);   
		up.setPageSize(pageSize);    
		up.setTotalNum(getAllUser(type).size());  
		return up;
	}

	@Override
	public boolean verifyStu(int id, int type) {
		// TODO Auto-generated method stub
		DbUtil dbutil = null;
		PreparedStatement ps = null;
		String sql = "update tb_user set type = ? where id = ?";
		try {
			dbutil = new DbUtil();
			ps = dbutil.getCon().prepareStatement(sql);
			int i = ps.executeUpdate();
			if(i != 0) {
				return true;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				dbutil.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public List stuList(int type) {
		Session s = null;
		Transaction tx = null;
		List userList = null;
		try {
			s = HibernateUtil.getSession();
			String hql = "from User as user where user.type = ?";
			Query query = s.createQuery(hql);
			query.setLong(0, type);
			userList = query.list();
		}catch(HibernateException e) {
			e.printStackTrace();
		}
		return userList;
	}

	@Override
	public boolean changeStuStatus(int id, int type) {
		boolean flag = false;
		Session s = null;
		Transaction tx = null;
		try {
			s = HibernateUtil.getSession();
			tx = s.beginTransaction();
			String hql = "update User user set user.type = ? where user.id = ?";
			Query query = s.createQuery(hql);
			query.setLong(0, type);
			query.setLong(1, id);
			query.executeUpdate();
			tx.commit();
			flag = true;
		}catch(HibernateException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public Admin getAdmin(int id) {
		org.hibernate.Session s = null;
		Transaction tx = null;
		try {
			s = HibernateUtil.getSession();
			Admin admin = (Admin)s.get(Admin.class, id);
			return admin;
		} finally {
			s.close();
		}
	}
	
	
}

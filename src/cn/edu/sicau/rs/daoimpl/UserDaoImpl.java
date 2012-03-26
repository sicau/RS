package cn.edu.sicau.rs.daoimpl;

import java.io.Serializable;
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

import cn.edu.sicau.rs.bean.User;
import cn.edu.sicau.rs.common.DbUtil;
import cn.edu.sicau.rs.common.HibernateUtil;
import cn.edu.sicau.rs.dao.UserDao;
import cn.edu.sicau.rs.exception.ErrPwdException;
import cn.edu.sicau.rs.exception.NameNotFoundException;



public class UserDaoImpl implements UserDao{
	
	//this method has been refactored by hibernate
	public boolean saveUser(User user) {
		boolean flag = false;
		Session s = null;
		Transaction tx = null;
		try {
			s = HibernateUtil.getSession();
			tx = s.beginTransaction();
			s.save(user);
			tx.commit();
			flag = true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}finally {
			s.close();
		}
		return flag;
	}

	//this method has been refactored by hibernate
	public User userLogin(String name,String password) {
		User user = null;
		Session s = null;
		Transaction tx = null;
		try {
			s = HibernateUtil.getSession();
			tx = s.beginTransaction();
			String hql = "from User as user where user.userName = ?";
			Query query = s.createQuery(hql);
			query.setString(0, name);
			List list = query.list();
			
			if(list.size()!= 0) {
				user = (User)list.get(0);
				if(!password.equals(user.getPassword())) {
					throw new ErrPwdException("密码不正确！！");
				}else {
					return user;
				}
			}else {
				throw new NameNotFoundException("用户名不存在！！");
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}finally {
			if(s!=null) {
				s.close();
			}
		}
		return user;
		
	}

//	public boolean checkNameExist(String name) {
//		boolean flag = false;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		DbUtil dbUtil = null;
//		String sql = "select * from tb_user where username=?";
//		try {
//			dbUtil = new DbUtil();
//			pstmt = dbUtil.getCon().prepareStatement(sql);
//			pstmt.setString(1, name);
//			rs = pstmt.executeQuery();
//			if(rs.next()) {
//				flag = true;
//			}
//		}catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return flag;
//	}

	//this method has been refactored by hibernate
	public User getUser(Serializable id) {
		org.hibernate.Session s = null;
		Transaction tx = null;
		try {
			s = HibernateUtil.getSession();
			User user = (User)s.get(User.class, id);
			return user;
		} finally {
			s.close();
		}
	}

	//this method has been refactored by hibernate
	public boolean updatePassword (String username , String password) {
		Boolean flag = false;
		Session s = null;
		Transaction tx = null;
		String hql = "update User user set user.userName = ? where user.password = ?";
		try {
			s = HibernateUtil.getSession();
			tx = s.beginTransaction();
			Query query = s.createQuery(hql);
			query.setString(0, username);
			query.setString(1, password);
			query.executeUpdate();
			tx.commit();
			flag = true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}finally {
			if(s != null) {
				s.close();
			}
		}
		return flag;
	}

	//this method has been refactored by hibernate
	public boolean updateSignInfo(User user) {
		boolean flag = false;
		Session s = null;
		Transaction tx = null;
		try {
			s = HibernateUtil.getSession();
			tx = s.beginTransaction();
			s.update(user);
			tx.commit();
			flag = true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}finally {
			s.close();
		}
		return flag;
	}

	@Override
	public ResultSet getUsers() {
		// TODO Auto-generated method stub
		DbUtil dbutil = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select truename,testnumber,sex,birthday,politics,identity,subject,school,phone,mphone" +
				",sa,spostcode,ha,hpostcode,lang,category,prize,speciality from tb_user";
		try {
			dbutil = new DbUtil();
			ps = dbutil.getCon().prepareStatement(sql);
			rs = ps.executeQuery();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	//this method has been refactored by hibernate
	public boolean updateUser(User user) {
		boolean flag = false;
		Session s = null;
		Transaction tx = null;
		try {
			s = HibernateUtil.getSession();
			tx = s.beginTransaction();
			s.update(user);
			tx.commit();
			flag = true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}finally {
			s.close();
		}
		return flag;
	}

	
	
}
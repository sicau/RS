package cn.edu.sicau.rs.daoimpl;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	
	public boolean saveUser(User user) {
		boolean flag = false;
		
		return flag;
	}

	//this method has been changed by hibernate
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

	/* get one user */
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
	
	@Override



	
	public boolean updatePassword (String username, String password) {
		Boolean flag = false;
		
		DbUtil dbutil = new DbUtil();
		PreparedStatement pstmt = null;
		String sql = "update tb_user set password = ? where name = ?";
		try {
			pstmt = dbutil.getCon().prepareStatement(sql);
			pstmt.setString(1, password);
			pstmt.setString(2, username);
			pstmt.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				dbutil.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}

	@Override
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
	
}
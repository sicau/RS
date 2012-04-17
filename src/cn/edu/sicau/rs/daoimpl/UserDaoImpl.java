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
			tx.commit();
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

	public boolean checkNameExist(String username) {
		Session s = null;
		boolean flag = false; 
		String hql = "from User as user where user.userName = ?";
		try {
			s = HibernateUtil.getSession();
			Query query = s.createQuery(hql);
			query.setString(0, username);
			List userList = query.list();
			System.out.println("size:"+userList.size());
			if(userList.size()>0) {
				flag = true;
			}
		}catch (HibernateException e) {
			e.printStackTrace();
		}
		return flag;
	}

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
	public List getAllUsers() {
		Session s = null;
		List userList = null;
		try {
			s = HibernateUtil.getSession();
			String hql = "from User as user";
			Query query = s.createQuery(hql);
			userList = query.list();
		}catch(HibernateException e) {
			e.printStackTrace();
		}
		return userList;
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
	public ResultSet getUsers(int type) {
		// TODO Auto-generated method stub
		DbUtil dbutil = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select truename," +
						"testnumber," +
						"sex," +
						"birthday," +
						"politics," +
						"identity," +
						"subject," +
						"school," +
						"phone," +
						"mphone," +
						"sa," +
						"spostcode," +
						"ha," +
						"hpostcode," +
						"lang," +
						"category," +
						"prize," +
						"speciality " +
						"from tb_user";
		try {
			if(type != 0) {
				sql = sql + " where type = ?";
			}
			dbutil = new DbUtil();
			ps = dbutil.getCon().prepareStatement(sql);
			if(type != 0) {
				ps.setLong(1, type);
			}
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

	@Override
	public String setSignumber() {
		// TODO Auto-generated method stub
		DbUtil dbutil = null;
		PreparedStatement ps = null;
		String sql = "select max(signumber) from tb_user  ";
		ResultSet rs = null;
		String signumber = null;
		try{
			dbutil = new DbUtil();
			ps = dbutil.getCon().prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()){
				signumber = rs.getString(1);
				if(signumber != null) {
					long sign =Long.parseLong(signumber) + 1;
					signumber = Long.toString(sign);
					System.out.println("signumber:"+signumber);
				} else {
					signumber = "1062620120001";
				}
			} 
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				rs.close();
				ps.close();
				dbutil.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return signumber;
	}

}
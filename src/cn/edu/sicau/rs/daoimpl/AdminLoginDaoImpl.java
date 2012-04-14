package cn.edu.sicau.rs.daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;



import cn.edu.sicau.rs.bean.Admin;
import cn.edu.sicau.rs.bean.User;
import cn.edu.sicau.rs.common.DbUtil;
import cn.edu.sicau.rs.common.HibernateUtil;
import cn.edu.sicau.rs.dao.AdminLoginDao;
import cn.edu.sicau.rs.exception.ErrPwdException;
import cn.edu.sicau.rs.exception.NameNotFound;
import cn.edu.sicau.rs.exception.NameNotFoundException;
import cn.edu.sicau.rs.exception.PasswordError;

public class AdminLoginDaoImpl implements AdminLoginDao {

	@Override
	public Admin login(Admin admin) {
		Admin ad = null;
		Session s = null;
		String password = admin.getPassword();
		try {
			s = HibernateUtil.getSession();
			String hql = "from Admin as admin where admin.adminName = ?";
			Query query = s.createQuery(hql);
			query.setString(0, admin.getAdminName());
			List list = query.list();
			if(list.size()!= 0) {
				ad = (Admin)list.get(0);
				if(!password.equals(ad.getPassword())) {
					throw new ErrPwdException("密码不正确！！");
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
		return ad;
	}

	@Override
	public boolean updatePassword(Admin admin) {
		boolean flag = false;
		Session s = null;
		Transaction tx = null;
		try {
			s = HibernateUtil.getSession();
			tx = s.beginTransaction();
			s.update(admin);
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
	public boolean createAdmin(String adminname, String password, int type) {
		boolean flag = false;
		Admin admin = new Admin();
		admin.setAdminName(adminname);
		admin.setPassword(password);
		admin.setType(type);
		
		Session s = null;
		Transaction tx = null;
		try {
			s = HibernateUtil.getSession();
			tx = s.beginTransaction();
			s.save(admin);
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
	public boolean deleteadmin(int id) {
		// TODO Auto-generated method stub
		boolean flag = false;
		DbUtil dbutil = null;
		PreparedStatement ps = null;
		String sql = "delete from tb_admin where id = ?";
		try {
			dbutil = new DbUtil();
			ps = dbutil.getCon().prepareStatement(sql);
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			if(i != 0) {
				flag = true;
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
		return flag;
	}
	

}

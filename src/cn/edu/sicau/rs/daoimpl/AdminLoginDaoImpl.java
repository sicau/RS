package cn.edu.sicau.rs.daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import cn.edu.sicau.rs.bean.Admin;
import cn.edu.sicau.rs.common.DbUtil;
import cn.edu.sicau.rs.dao.AdminLoginDao;
import cn.edu.sicau.rs.exception.NameNotFound;
import cn.edu.sicau.rs.exception.PasswordError;

public class AdminLoginDaoImpl implements AdminLoginDao {

	@Override
	public boolean login(Admin admin) {
		// TODO Auto-generated method stub
		DbUtil dbutil = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			dbutil = new DbUtil();
			String sql = "select * from tb_admin where name = ?";
			ps = dbutil.getCon().prepareStatement(sql);
			ps.setString(1, admin.getAdminName());
			rs = ps.executeQuery();
			if(rs.next()) {
				if(rs.getString("password").equals(admin.getPassword())) {
					return true;
				} else {
					throw new PasswordError("√‹¬Î¥ÌŒÛ£°");
				}
			} else {
				throw new NameNotFound("’À∫≈¥ÌŒÛ£°");
			}
		} catch (NameNotFound nnf) { 
			throw nnf;
		} catch (PasswordError pe) {
			throw pe;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean updatePassword(Admin admin) {
		// TODO Auto-generated method stub
		DbUtil dbutil = null;
		PreparedStatement pstmt = null;
		String sql = "update tb_admin set password = ? where name =?";
		try {
			dbutil = new DbUtil();
			pstmt = dbutil.getCon().prepareStatement(sql);
			pstmt.setString(1, admin.getPassword());
			pstmt.setString(2, admin.getAdminName());
			int i = pstmt.executeUpdate();
			if(i != 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				dbutil.close();
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public boolean createAdmin(String adminname, String password) {
		// TODO Auto-generated method stub
		boolean flag = false;
		DbUtil dbutil = null;
		PreparedStatement ps = null;
		String sql = "insert into tb_admin values(null,?,?,null)";
		try {
			dbutil = new DbUtil();
			ps = dbutil.getCon().prepareStatement(sql);
			ps.setString(1, adminname);
			ps.setString(2, password);
			int i = ps.executeUpdate();
			if(i != 0) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				dbutil.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
	

}

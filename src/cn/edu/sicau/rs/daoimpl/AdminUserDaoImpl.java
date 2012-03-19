package cn.edu.sicau.rs.daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;



import cn.edu.sicau.rs.bean.User;
import cn.edu.sicau.rs.bean.UserPager;
import cn.edu.sicau.rs.common.DbUtil;
import cn.edu.sicau.rs.dao.AdminUserDao;

public class AdminUserDaoImpl implements AdminUserDao {

	@Override
	public Map getAllUsers() {
		// TODO Auto-generated method stub
		Map userMap = new HashMap();
		DbUtil dbutil = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from tb_user";
		try {
			dbutil = new DbUtil();
			ps = dbutil.getCon().prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
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
				user.setSubject(rs.getShort("subject"));
				user.setSchool(rs.getString("school"));
				user.setPhone(rs.getString("phone"));
				user.setMphone(rs.getString("mphone"));
				user.setSa(rs.getString("sa"));
				user.setSpostcode(rs.getShort("spostcode"));
				user.setHa(rs.getString("ha"));
				user.setHpostcode(rs.getString("hpostcode"));
				user.setLang(rs.getShort("lang"));
				user.setCategory(rs.getString("category"));
				user.setPrize(rs.getString("prize"));
				user.setSpeciality(rs.getString("speciality"));
				user.setType(rs.getString("type"));
				userMap.put(new Integer(user.getId()),user);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				dbutil.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return userMap;
	}

	@Override
	public boolean deleteUserById(int id) {
		// TODO Auto-generated method stub
		boolean flag = false;
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
		return false;
	}

	@Override
	public UserPager getUserPager(int index, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

}

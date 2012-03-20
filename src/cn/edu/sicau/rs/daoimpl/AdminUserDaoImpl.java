package cn.edu.sicau.rs.daoimpl;

import java.sql.Connection;
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
				userMap.put(new Integer(user.getId()),user);     //将userId与此映射中的user关联
				
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
	public UserPager getUserPager(int index, int pageSize) {
		// TODO Auto-generated method stub
		Map userMap = new HashMap();
		DbUtil dbutil = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			dbutil = new DbUtil();
			String sql = "select * from tb_user limit ?,?";
			ps = dbutil.getCon().prepareStatement(sql);
			ps.setInt(1, index);
			ps.setInt(2, pageSize);
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
		up.setPageSize(pageSize);    //
		up.setTotalNum(getAllUsers().size());  //
		return up;
	}

}

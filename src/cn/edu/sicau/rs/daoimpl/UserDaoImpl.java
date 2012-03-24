package cn.edu.sicau.rs.daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.sicau.rs.bean.User;
import cn.edu.sicau.rs.common.DbUtil;
import cn.edu.sicau.rs.dao.UserDao;
import cn.edu.sicau.rs.exception.ErrPwdException;
import cn.edu.sicau.rs.exception.NameNotFoundException;



public class UserDaoImpl implements UserDao{
	
	public boolean saveUser(User user) {
		boolean flag = false;
		PreparedStatement pstmt = null;
		DbUtil dbUtil = null;
		String sql = "insert into tb_user values(null,null,?,?,?,null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,null)";
		try {
			dbUtil = new DbUtil();
			pstmt = dbUtil.getCon().prepareStatement(sql);
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getTrueName());
			pstmt.setString(4, user.getSex());
			pstmt.setString(5, user.getBirthday());
			pstmt.setString(6, user.getPolitics());
			pstmt.setString(7, user.getIdentity());
			pstmt.setString(8, user.getSubject());
			pstmt.setString(9, user.getSchool());
			pstmt.setString(10, user.getPhone());
			pstmt.setString(11, user.getMphone());
			pstmt.setString(12, user.getSa());
			pstmt.setString(13, user.getSpostcode());
			pstmt.setString(14, user.getHa());
			pstmt.setString(15, user.getHpostcode());
			pstmt.setString(16, user.getLang());
			pstmt.setString(17, user.getCategory());
			pstmt.setString(18, user.getPrize());
			pstmt.setString(19, user.getSpeciality());
			pstmt.setString(20, user.getSrc());
			
			
			int i = pstmt.executeUpdate();
			if(i != 0) {
				
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				dbUtil.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		
		return flag;
	}

	
	public User userLogin(String name,String password) {
		User user = new User();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DbUtil dbUtil = null;
		String sql ="select * from tb_user where username=?";
		try {
			dbUtil = new DbUtil();
			pstmt = dbUtil.getCon().prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(!password.equals(rs.getString("password"))) {
					throw new ErrPwdException("密码不正确！！");
				}else {

					user.setId(rs.getInt("id"));
					user.setSigNumber(rs.getString("sigNumber"));
					user.setUserName(rs.getString("username"));
					user.setPassword(rs.getString("password"));
					user.setTrueName(rs.getString("truename"));
					user.setTestNumber(rs.getString("testnumber"));
					user.setSex(rs.getString("sex"));
					user.setBirthday(rs.getString("birthday"));
					user.setPolitics(rs.getString("politics"));
					user.setIdentity(rs.getString("identity"));
					user.setSubject(rs.getString("subject"));
					user.setSchool(rs.getString("school"));
					user.setMphone(rs.getString("mphone"));
					user.setPhone(rs.getString("phone"));
					user.setSa(rs.getString("sa"));
					user.setSpostcode(rs.getString("spostcode"));
					user.setHa(rs.getString("ha"));
					user.setHpostcode(rs.getString("hpostcode"));
					user.setLang(rs.getString("lang"));
					user.setCategory(rs.getString("category"));
					user.setPrize(rs.getString("prize"));
					user.setSpeciality(rs.getString("speciality"));
					user.setSrc(rs.getString("src"));
					user.setType(rs.getString("type"));
					return user;
				}
			}else {
				throw new NameNotFoundException("用户名不存在！！");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				dbUtil.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return user;
	}

	public boolean checkNameExist(String name) {
		boolean flag = false;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DbUtil dbUtil = null;
		String sql = "select * from tb_user where username=?";
		try {
			dbUtil = new DbUtil();
			pstmt = dbUtil.getCon().prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				flag = true;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	/* get one user */
	public User getUser(int id) {
		User user = new User();
		DbUtil dao = new DbUtil();
		
		PreparedStatement pre = null;
		ResultSet rs = null;
		String sql = "selsect * from tb_user where id = ?";
		try {
			pre = dao.getCon().prepareStatement(sql);
			pre.setInt(1, id);
			rs = pre.executeQuery();
			if (rs.next()) {
				user.setId(rs.getInt("id"));
				user.setSigNumber(rs.getString("sigNumber"));
				user.setUserName(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setTrueName(rs.getString("truename"));
				user.setTestNumber(rs.getString("testnumber"));
				user.setSex(rs.getString("sex"));
				user.setBirthday(rs.getString("birthday"));
				user.setPolitics(rs.getString("politics"));
				user.setIdentity(rs.getString("identity"));
				user.setSubject(rs.getString("subject"));
				user.setSchool(rs.getString("school"));
				user.setMphone(rs.getString("mphone"));
				user.setPhone(rs.getString("phone"));
				user.setSa(rs.getString("sa"));
				user.setSpostcode(rs.getString("spost"));
				user.setHa(rs.getString("ha"));
				user.setHpostcode(rs.getString("hpost"));
				user.setLang(rs.getString(""));
				user.setCategory(rs.getString("category"));
				user.setPrize(rs.getString("prize"));
				user.setSpeciality(rs.getString("speciality"));
				user.setSrc(rs.getString("src"));
				user.setType(rs.getString("type"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pre.close();
				dao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return user;
	}
	
	@Override


	/* user provide personal information */
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		Boolean flag = false;
		DbUtil dbutil = new DbUtil();
		PreparedStatement pstmt = null;
		String sql = "update tu_user set truename = ?,sex = ?,birthday = ?,politics = ?,identity = ?,subject = ?,school = ?," +
				    "phone= ? ,mphone = ?,SA = ?,spostcode = ?,HA = ?,hpostcode = ?,lang = ?,category = ?,prize = ?," +
				     "src = ? ,speciality = ? where username = ?";
		try {
			pstmt = dbutil.getCon().prepareStatement(sql);
			pstmt.setString(1, user.getTrueName());
			pstmt.setString(2, user.getSex());
			pstmt.setString(3, user.getBirthday());
			pstmt.setString(4, user.getPolitics());
			pstmt.setString(5, user.getIdentity());
			pstmt.setString(6, user.getSubject());
			pstmt.setString(7, user.getSchool());
			pstmt.setString(8, user.getPhone());
			pstmt.setString(9, user.getMphone());
			pstmt.setString(10, user.getSa());
			pstmt.setString(11, user.getSpostcode());
			pstmt.setString(12, user.getHa());
			pstmt.setString(13, user.getHpostcode());
			pstmt.setString(14, user.getLang());
			pstmt.setString(15, user.getCategory());
			pstmt.setString(16, user.getPrize());
			pstmt.setString(17, user.getSrc());
			pstmt.setString(18, user.getSpeciality());
			pstmt.setString(19, user.getUserName());
			
			pstmt.addBatch();
			pstmt.executeBatch();
			flag = true;
		} catch (SQLException e ) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				dbutil.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	/*user update password*/
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
		PreparedStatement pstmt = null;
		DbUtil dbUtil = null;
		String sql = "update tb_user " +
				"set truename = ?, " +
				"testnumber = ?, " +
				"sex = ?, " +
				"birthday = ?, " +
				"politics = ?, " +
				"identity = ?, " +
				"subject = ?, " +
				"school = ?, " +
				"phone = ?, " +
				"mphone = ?, " +
				"SA = ?, " +
				"spostcode = ?, " +
				"HA = ?, " +
				"hpostcode = ?, " +
				"lang = ?, " +
				"category = ?, " +
				"prize = ?, " +
				"ser = ?,"+
				"speciality = ? " +
				"where id = ?";
		
		try {
			dbUtil = new DbUtil();
			pstmt = dbUtil.getCon().prepareStatement(sql);
			pstmt.setString(1, user.getTrueName());
			pstmt.setString(2, user.getTestNumber());
			pstmt.setString(3, user.getSex());
			pstmt.setString(4, user.getBirthday());
			pstmt.setString(5, user.getPolitics());
			pstmt.setString(6, user.getIdentity());
			pstmt.setString(7, user.getSubject());
			pstmt.setString(8, user.getSchool());
			pstmt.setString(9, user.getPhone());
			pstmt.setString(10, user.getMphone());
			pstmt.setString(11, user.getSa());
			pstmt.setString(12, user.getSpostcode());
			pstmt.setString(13, user.getHa());
			pstmt.setString(14, user.getHpostcode());
			pstmt.setString(15, user.getLang());
			pstmt.setString(16, user.getCategory());
			pstmt.setString(17, user.getPrize());
			pstmt.setString(18, user.getSrc());
			pstmt.setString(19, user.getSpeciality());
			pstmt.setInt(20, user.getId());
			System.out.println(sql);
			
			int i = pstmt.executeUpdate();
			if(i != 0) {
				
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				dbUtil.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

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
	
}
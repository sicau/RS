package cn.edu.sicau.rs.daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
		String sql = "insert into tb_user values(null,null,?,?,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)";
		try {
			dbUtil = new DbUtil();
			pstmt = dbUtil.getCon().prepareStatement(sql);
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getPassword());
			
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
					user.setAs(rs.getString("as"));
					user.setSchool(rs.getString("school"));
					user.setMphone(rs.getString("mphone"));
					user.setPhone(rs.getString("phone"));
					user.setSa(rs.getString("sa"));
					user.setSpost(rs.getString("spost"));
					user.setHa(rs.getString("ha"));
					user.setHpost(rs.getString("hpost"));
					user.setForeign(rs.getString("foreign"));
					user.setCategory(rs.getString("category"));
					user.setPrize(rs.getString("prize"));
					user.setSpeciality(rs.getString("speciality"));
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
				user.setAs(rs.getString("as"));
				user.setSchool(rs.getString("school"));
				user.setMphone(rs.getString("mphone"));
				user.setPhone(rs.getString("phone"));
				user.setSa(rs.getString("sa"));
				user.setSpost(rs.getString("spost"));
				user.setHa(rs.getString("ha"));
				user.setHpost(rs.getString("hpost"));
				user.setForeign(rs.getString("foreign"));
				user.setCategory(rs.getString("category"));
				user.setPrize(rs.getString("prize"));
				user.setSpeciality(rs.getString("speciality"));
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

	/* user provide personal information */
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		Boolean flag = false;
		DbUtil dbutil = new DbUtil();
		PreparedStatement pstmt = null;
		String sql = "update tu_user set truename = ?,sex = ?,birthday = ?,politics = ?,identity = ?,as = ?,school = ?," +
				    "phone= ? ,mphone = ?,SA = ?,spostcode = ?,HA = ?,hpostcode = ?,foreign = ?,category = ?,prize = ?," +
				     "speciality = ? where username = ?";
		try {
			pstmt = dbutil.getCon().prepareStatement(sql);
			pstmt.setString(1, user.getTrueName());
			pstmt.setString(2, user.getSex());
			pstmt.setString(3, user.getBirthday());
			pstmt.setString(4, user.getPolitics());
			pstmt.setString(5, user.getIdentity());
			pstmt.setString(6, user.getAs());
			pstmt.setString(7, user.getSchool());
			pstmt.setString(8, user.getPhone());
			pstmt.setString(9, user.getMphone());
			pstmt.setString(10, user.getSa());
			pstmt.setString(11, user.getSpost());
			pstmt.setString(12, user.getHa());
			pstmt.setString(13, user.getHpost());
			pstmt.setString(14, user.getForeign());
			pstmt.setString(15, user.getCategory());
			pstmt.setString(16, user.getPrize());
			pstmt.setString(17, user.getSpeciality());
			pstmt.setString(18, user.getUserName());
			
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
	
	
	
}
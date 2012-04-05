package cn.edu.sicau.rs.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import cn.edu.sicau.rs.bean.News;
import cn.edu.sicau.rs.bean.User;
import cn.edu.sicau.rs.common.DbUtil;
import cn.edu.sicau.rs.dao.NewsDao;

public class NewsDaoImpl implements NewsDao{

	@Override
	public boolean addNews(News news) {
		// TODO Auto-generated method stub
		DbUtil dbutil = null;
		PreparedStatement ps = null;
		String sql = "insert into tb_news values (null,?,?,?,?,?,?)";
		try {
			dbutil = new DbUtil();
			ps = dbutil.getCon().prepareStatement(sql);
			ps.setString(1,news.getSubject());
			ps.setString(2, news.getCreateTime());
			ps.setString(3, news.getContent());
			ps.setString(4, news.getAuthor());
			ps.setString(5, news.getType());
			ps.setString(6, news.getTop());
			
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
	public boolean delNews(int ids[]) {
		// TODO Auto-generated method stub
		DbUtil dbutil = null;
		PreparedStatement ps = null;
		Connection conn = null;
		String sql = "delete from tb_news where id = ?";
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
	public boolean updateNews() {
		// TODO Auto-generated method stub
		
		return false;
	}

	@Override
	public Map getAllNews() {
		// TODO Auto-generated method stub
		Map newsMap = new HashMap();
		DbUtil dbutil = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from tb_news";
		try {
			dbutil = new DbUtil();
			ps = dbutil.getCon().prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				News news = new News();
				news.setId(rs.getInt("id"));
				news.setSubject(rs.getString("subject"));
				news.setCreateTime(rs.getString("createtime"));
				news.setContent(rs.getString("content"));
				news.setAuthor(rs.getString("author"));
				news.setType(rs.getString("type"));
				newsMap.put(new Integer(news.getId()),news);     
				
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
		return newsMap;
		
	}
	
	public List getAllNewses() {
		// TODO Auto-generated method stub
		List newsList = new ArrayList();
		DbUtil dbutil = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from tb_news";
		try {
			dbutil = new DbUtil();
			ps = dbutil.getCon().prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				News news = new News();
				news.setId(rs.getInt("id"));
				news.setSubject(rs.getString("subject"));
				news.setCreateTime(rs.getString("createtime"));
				news.setContent(rs.getString("content"));
				news.setAuthor(rs.getString("author"));
				news.setType(rs.getString("type"));
				newsList.add(news);     
				
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
		return newsList;
		
	}

	@Override
	public News getByID(int id) {
		// TODO Auto-generated method stub
		DbUtil dbutil = null;
		PreparedStatement ps = null;
		String sql =  "select * from tb_news where id = ?";
		ResultSet rs = null;
		try {
			dbutil = new DbUtil();
			ps = dbutil.getCon().prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				News news = new News();
				news.setId(rs.getInt("id"));
				news.setSubject(rs.getString("subject"));
				String sub = rs.getString("subject");
				System.out.println(sub);
				news.setContent(rs.getString("content"));
				news.setCreateTime(rs.getString("createtime"));
				news.setType(rs.getString("type"));
				news.setAuthor(rs.getString("author"));
				return news;
			} else {
				System.out.println("该新闻不存在！！");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean delNews(int id) {
		// TODO Auto-generated method stub
		DbUtil dbutil = null;
		PreparedStatement ps = null;
		Connection conn = null;
		String sql = "delete from tb_news where id = ?";
		try {
			dbutil = new DbUtil();
			conn = dbutil.getCon();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			if(i != 0) {
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
	public boolean topSign(int id,String top) {
		// TODO Auto-generated method stub
		DbUtil dbutil = null;
		PreparedStatement ps = null;
		if(top.equals(0)){
			String sql = "update tb_user set top = 1 where id = ?";
		} else {
			String sql = "update tb_user set top =0 where id = ?";
		}
		
		try {
			dbutil = new DbUtil();
			ps = dbutil.getCon().prepareStatement(sql);
			ps.setInt(1, id);
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
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

}

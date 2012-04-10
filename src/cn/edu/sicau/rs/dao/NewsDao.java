package cn.edu.sicau.rs.dao;

import java.util.List;
import java.util.Map;

import cn.edu.sicau.rs.bean.News;
import cn.edu.sicau.rs.bean.NewsPager;

public interface NewsDao {
	public boolean addNews(News news);
	public boolean delNews(int ids[]);
	public boolean delNews(int id);
	public boolean updateNews();
	public Map getAllNews(int type);
	public List getAllNewses();
	public News getByID(int id);
	public boolean topSign(int id , String top);
	public NewsPager getNewsPager(int index, int pageSize, int type);
	
}

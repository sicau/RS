package cn.edu.sicau.rs.bean;

import java.util.Map;

public class NewsPager {
	private Map newsMap;
	private int totalNum;
	private int pageSize;
	private int currentPage;
	private int pageNum;
	private int pageOffset;
	public Map getNewsMap() {
		return newsMap;
	}
	public void setNewsMap(Map newsMap) {
		this.newsMap = newsMap;
	}
	public int getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageOffset() {
		return pageOffset;
	}
	public void setPageOffset(int pageOffset) {
		this.pageOffset = pageOffset;
	}
}

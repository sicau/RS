package cn.edu.sicau.rs.bean;

import java.util.Map;

public class UserPager {
	private Map userMap;    //。。。。。。。。。。。
	
	private int totalNum;   //总记录数     .........
	
	private int pageSize;   //每页显示数目     ........
	
	private int currentPage;       //当前页
	
	private int pageNum;    //总页数
	
	private int pageOffset;    // 偏移量
	
	

	public Map getUserMap() {
		return userMap;
	}

	public void setUserMap(Map userMap) {
		this.userMap = userMap;
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

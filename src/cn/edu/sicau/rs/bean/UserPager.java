package cn.edu.sicau.rs.bean;

import java.util.Map;

public class UserPager {
	private Map userMap;
	
	private int totalNum;   //��ҳ��
	
	private int pageSize;   //ÿҳ��ʾ��Ŀ
	
	private int currentPage;       //��ǰҳ
	
	private int rowNum;    //�ܼ�¼����
	
	private int pageOffset;    // ƫ����
	
	

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

	public int getRowNum() {
		return rowNum;
	}

	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}

	public int getPageOffset() {
		return pageOffset;
	}

	public void setPageOffset(int pageOffset) {
		this.pageOffset = pageOffset;
	}
	
}

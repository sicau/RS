package cn.edu.sicau.rs.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.sicau.rs.model.Model;

public class DeleteUserServlet extends HttpServlet { 
	public  void doGet(HttpServletRequest request, HttpServletResponse response)
					throws ServletException , IOException {
		String users_str = request.getParameter("userIds");
		String pageOffset = request.getParameter("pageOffset");
		String pageSize = request.getParameter("pageSize");
		String type = request.getParameter("type");
		
		String[] ids_str = null;
		
		if(users_str != "") {
			ids_str = users_str.split(",");
		}
		int[] ids = new int[ids_str.length];
		for(int i=0;i<ids_str.length;i++) {
			ids[i] = Integer.parseInt(ids_str[i]);
		}
		Model model = new Model();
		if(model.deleteUsers(ids)) {
			request.getRequestDispatcher("GetUserPageServlet?pager.offset="+pageOffset+"&pageSize="+pageSize+"&type="+type).forward(request, response);
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		this.doGet(request, response);
		
	}

}

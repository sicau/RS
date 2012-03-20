package cn.edu.sicau.rs.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteUserServlet extends HttpServlet {
	public  void doGet(HttpServletRequest request, HttpServletResponse response)
					throws ServletException , IOException {
		String users_str = request.getParameter("userIDs");
		String pageOffset = request.getParameter("pageOffset");
		String pageSize = request.getParameter("pageSize");
	}

}

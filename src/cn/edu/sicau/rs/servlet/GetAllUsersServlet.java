package cn.edu.sicau.rs.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.sicau.rs.bean.User;
import cn.edu.sicau.rs.model.Model;

public class GetAllUsersServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		List userList = null;
		Model model = new Model();
		try {
//			if(!userMap.isEmpty()) {
				userList = model.getAllUsers();
				request.setAttribute("userList", userList);
				response.sendRedirect("stuList.jsp");
//			} else {
				request.getRequestDispatcher("").forward(request, response);
//			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse resposne)
					throws ServletException ,IOException {
		this.doGet(request, resposne);
	}

}

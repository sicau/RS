package cn.edu.sicau.rs.servlet;

import java.io.IOException;
import java.util.HashMap;
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
        Map userMap = new HashMap();
		Model model = new Model();
		try {
			if(!userMap.isEmpty()) {
				userMap = model.getAllUsers();
				request.setAttribute("userMap", userMap);
				response.sendRedirect("stuList.jsp");
			} else {
				request.getRequestDispatcher("").forward(request, response);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse resposne)
					throws ServletException ,IOException {
		this.doGet(request, resposne);
	}

}

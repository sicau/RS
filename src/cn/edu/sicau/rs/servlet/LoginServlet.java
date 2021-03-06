package cn.edu.sicau.rs.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.sicau.rs.bean.User;
import cn.edu.sicau.rs.exception.ErrPwdException;
import cn.edu.sicau.rs.exception.NameNotFoundException;
import cn.edu.sicau.rs.model.Model;


public class LoginServlet extends HttpServlet {
	public void doGet (HttpServletRequest request, HttpServletResponse response)
	           throws ServletException , IOException {
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Model model = new Model();
		try {
			User user = model.userLogin(username, password);
//			ServletContext context = this.getServletContext();    //����������
//			List nameList = (List) context.getAttribute("nameList");   
//			
			request.getSession().setAttribute("username", username);    
			request.getSession().setAttribute("id", user.getId());  
			request.getSession().setAttribute("type", user.getType()); 
			response.sendRedirect("selfHome.jsp");
			
		} catch (NameNotFoundException e) {
			request.setAttribute("NameNotFondException",e.getMessage());
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} catch (ErrPwdException e) {
			request.setAttribute("ErrPwdException", e.getMessage());
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
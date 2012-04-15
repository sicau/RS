package cn.edu.sicau.rs.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.sicau.rs.bean.News;
import cn.edu.sicau.rs.model.Model;

public class GetAllNewsServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		News news = new News();
		Model model = new Model();
		List newsList = null;
		int type =Integer.parseInt(request.getParameter("type"));
		try {
			newsList = model.getAllNewses(type);
			if(!newsList.isEmpty()) {
				request.getSession().setAttribute("newsList", newsList);
				request.getSession().setAttribute("news", news);
				response.sendRedirect("Admin/pages/newsList.jsp");
			}else {
				System.out.println("new is empty");
			}
		} catch(Exception e ) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}

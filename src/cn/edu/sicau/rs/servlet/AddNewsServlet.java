package cn.edu.sicau.rs.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.sicau.rs.bean.News;
import cn.edu.sicau.rs.model.Model;

public class AddNewsServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
						throws ServletException , IOException {
		request.setCharacterEncoding("UTF-8");
		News news = new News();
		news.setAuthor(request.getParameter("author"));
		news.setContent(request.getParameter("content"));
		news.setCreateTime(request.getParameter("time"));
		news.setSubject(request.getParameter("title"));
		news.setType(request.getParameter("type"));
		news.setTop("0");
		try {
			Model model = new Model();
			if(model.addNews(news)) {
				System.out.println("³É¹¦£¡£¡");
			} else {
				System.out.println("Ê§°Ü£¡£¡");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
						throws ServletException , IOException {
		this.doGet(request, response);
	}
}

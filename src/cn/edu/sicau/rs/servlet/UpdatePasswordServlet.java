package cn.edu.sicau.rs.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.sicau.rs.bean.User;
import cn.edu.sicau.rs.model.Model;

public class UpdatePasswordServlet {
	public void doGet (HttpServletRequest request, HttpServletResponse response)
	           	throws ServletException , IOException {
		User user = (User) request.getSession().getAttribute("user");
		String username = (String) user.getUserName();
		String password = request.getParameter("password");
		
		Model model = new Model();
		try {
			model.updatePassword(username, password);
			request.setAttribute("updatpwdsuccess", "�޸�����ɹ���");
			response.sendRedirect("index.jsp");
		} catch (Exception e) {
			System.out.println("��������û�ɹ�������");
		}
	}

}

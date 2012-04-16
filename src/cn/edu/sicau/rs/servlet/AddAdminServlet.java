package cn.edu.sicau.rs.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.sicau.rs.model.Model;

public class AddAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddAdminServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String adminame = request.getParameter("adminname");
		String password = request.getParameter("password");
		int type = Integer.parseInt(request.getParameter("type"));
		Model model = new Model(); 
		if (model.createAdmin(adminame, password, type)) {
			response.sendRedirect("Admin/pages/addAdmin.jsp");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}

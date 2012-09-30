package cn.edu.sicau.rs.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.sicau.rs.bean.Admin;
import cn.edu.sicau.rs.model.Model;

public class AdminInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public AdminInfoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String adminame = request.getParameter("adminname");
		String password = request.getParameter("password");
		int type = Integer.parseInt(request.getParameter("type"));
		Admin admin = new Admin();
		admin.setId(id);
		admin.setAdminName(adminame);
		admin.setPassword(password);
		admin.setType(type);
		Model model = new Model();
		if(model.updatePassword(admin)) {
			request.setAttribute("message", "修改成功");
			request.getRequestDispatcher("Admin/pages/adminListServlet").forward(request, response);
		}else{
			System.out.println("出错啦！");
		}
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}

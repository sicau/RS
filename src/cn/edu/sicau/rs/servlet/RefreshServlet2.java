package cn.edu.sicau.rs.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.sicau.rs.model.Model;

/**
 * Servlet implementation class RefreshServlet2
 */
public class RefreshServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RefreshServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		int type = Integer.parseInt(request.getParameter("type"));
		Model model = new Model();
		List newsList = null;
		
		try {
			newsList = model.getAllNewses(type);
			if(!newsList.isEmpty()) {
				request.getSession().setAttribute("informList", newsList);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}else {
				System.out.println("shibai");
			}
		} catch(Exception e ) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}

package cn.edu.sicau.rs.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.sicau.rs.bean.News;
import cn.edu.sicau.rs.model.Model;

/**
 * Servlet implementation class GetOneNewsServlet
 */
public class GetOneNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetOneNewsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		Model model = new Model();
		News news = null;
		try {
			int id = Integer.valueOf(request.getParameter("id")).intValue();
			
			
			news = model.getByID(id);
			request.getSession().setAttribute("news", news);
			response.sendRedirect("onenews.jsp");
		} catch(Exception e) {
			request.getRequestDispatcher("errorpage.jsp").forward(request, response);
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

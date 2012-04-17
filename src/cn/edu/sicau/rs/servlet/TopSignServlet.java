package cn.edu.sicau.rs.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.sicau.rs.bean.NewsPager;
import cn.edu.sicau.rs.model.Model;

/**
 * Servlet implementation class TopSignServlet
 */
public class TopSignServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TopSignServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String top = request.getParameter("top");
		String type = request.getParameter("type");
		NewsPager np = (NewsPager)request.getSession().getAttribute("newsPager");
		int i = 0;
		Model model = new Model();
		if(type.equals("0")){
			model.clearSign();
		}
		if(model.topSign(id, top)) {
			response.sendRedirect("GetNewsPagerServlet?type="+type+"&pageSize="+np.getPageSize()+"&pager.offset = i");
//			response.sendRedirect("GetNewsPagerServlet?type=0&pageSize=5&pager.offset=0");
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

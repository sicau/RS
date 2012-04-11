package cn.edu.sicau.rs.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.sicau.rs.bean.NewsPager;
import cn.edu.sicau.rs.model.Model;

/**
 * Servlet implementation class GetNewsPagerServlet
 */
public class GetNewsPagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetNewsPagerServlet() {
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
		String pageOffset_str = request.getParameter("pager.offset");
		String pageSize_str = request.getParameter("pageSize");
		int pageOffset = 0;
		int pageSize = 5;
		int currentPage = 0;
		if(pageOffset_str != null && pageSize_str != null) {
			pageOffset = Integer.parseInt(pageOffset_str);
			pageSize = Integer.parseInt(pageSize_str);
		}
		Model model = new Model();
		NewsPager newsPager = model.getNewsPager(pageOffset, pageSize, type);
		if(newsPager.getNewsMap().size() == 0 && pageOffset != 0) {
			pageOffset -= pageSize;
			newsPager = model.getNewsPager(pageOffset, pageSize, type);
		}
		
		if(pageOffset%pageSize == 0 || pageOffset/pageSize > 0) {
			currentPage = pageOffset/pageSize + 1;
		}
		newsPager.setPageOffset(pageOffset);
		newsPager.setPageSize(pageSize);
		newsPager.setCurrentPage(currentPage);
		request.setAttribute("type", type);
		request.getSession().setAttribute("newsPager", newsPager);
		request.setAttribute("newsList", newsPager.getNewsMap().values());
		request.getRequestDispatcher("Admin/pages/newsList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}

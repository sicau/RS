package cn.edu.sicau.rs.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class SelfHomeFilter
 */
public class SelfHomeFilter implements Filter {

    /**
     * Default constructor. 
     */
    public SelfHomeFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpServletRequest httpreq = (HttpServletRequest) request;
		HttpServletResponse httpresp = (HttpServletResponse) response;
		String username = (String)httpreq.getSession().getAttribute("username");
		if(username == null) {
			System.out.println("ÇëµÇÂ¼ÏÈ");
			httpreq.getRequestDispatcher("index.jsp").forward(httpreq, httpresp);
		}else{
			chain.doFilter(httpreq, response);
		}

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

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

import cn.edu.sicau.rs.bean.Admin;

public class AdminLoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpServletRequest httpreq = (HttpServletRequest) request; 
		HttpServletResponse httpresp = (HttpServletResponse) response;
		Admin admin = (Admin) httpreq.getSession().getAttribute("admin");
		if(admin == null) {
			System.out.println(admin);
			httpreq.getRequestDispatcher("../login/adminLogin.jsp").forward(httpreq, httpresp);
		} else {
			chain.doFilter(httpreq, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}

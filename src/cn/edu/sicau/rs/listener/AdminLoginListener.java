package cn.edu.sicau.rs.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import cn.edu.sicau.rs.bean.Admin;

public class AdminLoginListener implements ServletContextListener,
								HttpSessionListener, HttpSessionAttributeListener {
	
	private List<Admin> adminList;
	private ServletContext context;
	
	
	@Override
	public void attributeAdded(HttpSessionBindingEvent arg0) {   //当在Session增加一个属性时，激发
		// TODO Auto-generated method stub
		HttpSession session = arg0.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		if(adminList.size() == 0) {
			adminList.add(admin);
			context.setAttribute("adminList", adminList);
		}
		
	}
	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {   //当在Session删除一个属性时，激发
		// TODO Auto-generated method stub
		
	}
	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {   //在Session属性被重新设置时，激发
		// TODO Auto-generated method stub
		
	}
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {   //当创建一个Session时，激发
		// TODO Auto-generated method stub
		
	}
	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {   //当销毁一个Session时，激发
		// TODO Auto-generated method stub
		HttpSession session = arg0.getSession();
		Admin admin =(Admin) session.getAttribute("admin");
		if(admin != null) {
			adminList.remove(admin);
			context.setAttribute("adminList", adminList);
		}
	}
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void contextInitialized(ServletContextEvent arg0) {  //初始化时创建一个adminList属性
		// TODO Auto-generated method stub
		adminList = new ArrayList<Admin>();
		context = arg0.getServletContext();
		context.setAttribute("adminList" , adminList);
		
	}

}

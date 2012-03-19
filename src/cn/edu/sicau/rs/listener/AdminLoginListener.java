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
	public void attributeAdded(HttpSessionBindingEvent arg0) {   //����Session����һ������ʱ������
		// TODO Auto-generated method stub
		HttpSession session = arg0.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		if(adminList.size() == 0) {
			adminList.add(admin);
			context.setAttribute("adminList", adminList);
		}
		
	}
	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {   //����Sessionɾ��һ������ʱ������
		// TODO Auto-generated method stub
		
	}
	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {   //��Session���Ա���������ʱ������
		// TODO Auto-generated method stub
		
	}
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {   //������һ��Sessionʱ������
		// TODO Auto-generated method stub
		
	}
	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {   //������һ��Sessionʱ������
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
	public void contextInitialized(ServletContextEvent arg0) {  //��ʼ��ʱ����һ��adminList����
		// TODO Auto-generated method stub
		adminList = new ArrayList<Admin>();
		context = arg0.getServletContext();
		context.setAttribute("adminList" , adminList);
		
	}

}

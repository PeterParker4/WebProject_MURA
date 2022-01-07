package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;



//@WebServlet("/ControllerAction")
public class ControllerAction2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	// ��ɾ�� ��ɾ� ó�� Ŭ������ ������ ������
		private Map<String, Object> commandMap2 =
				new HashMap<String, Object>();
		
		/* ��ɾ�� ó�� Ŭ������ ���εǾ� �ִ� properties ������ �о commandMap�� ����
		 * ���������� Command.properties ����
		 * 
		 * web.xml���� init-param�� �ش��ϴ� ���� �о��
		 */

		public void init(ServletConfig config) throws ServletException {
			String props2 = config.getInitParameter("propertyConfig2"); // ������Ƽ ������ �о�� Ȱ��
			
			// ��ɾ�� ó��Ŭ������ ���������� ������ properties ��ü�� ������
			Properties pro2 = new Properties();
			String path2 = config.getServletContext().getRealPath("/WEB-INF"); // ������ ��ο��� ������ �о�� 
			
			FileInputStream f2 = null;
			
			try {
				
				//Command.properties ������ ������ �ҷ���
				f2 = new FileInputStream(new File(path2, props2));
				
				//Command.properties ���Ͽ� �ִ� ���������� Properties ��ü�� ������
				pro2.load(f2);
				
			}catch(IOException e) {
				throw new ServletException(e);
			}finally {
				if(f2 != null) try {f2.close();}catch(IOException e) {}
			}
			
			// Iterator ��ü ����
			Iterator<Object> keyIter2 = pro2.keySet().iterator(); // key���� ������ ?
			
			// ��ü�� �ϳ��� ������ �� ��ü������ properties ��ü�� ����� ��ü ������
			while(keyIter2.hasNext()) {
				
				String command2 = (String) keyIter2.next();
				String className2 = pro2.getProperty(command2);
				
				try {
					// �ش� ���ڿ��� �״�� Ŭ������ ����
					Class commandClass2 = Class.forName(className2);
					
					// �ش� Ŭ������ ��ü�� ������
					Object commandInstance2 = commandClass2.newInstance();
					
					// Map ��ü�� commandMap�� ��ü�� ������
					commandMap2.put(command2, commandInstance2);
				}catch(ClassNotFoundException ne) {
					throw new ServletException(ne);
				}catch(InstantiationException ie) {
					throw new ServletException(ie);
				}catch(IllegalAccessException e) {
					throw new ServletException(e);
				}	
			}
			
		}
		
	protected void requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String view2 = null;
		CommandAction com2 = null;
		
		try {
			
			String command2 = request.getRequestURI();
			if(command2.indexOf(request.getContextPath()) == 0) {
				command2 = command2.substring(request.getContextPath().length());
			}
			com2 = (CommandAction) commandMap2.get(command2);
			view2 = com2.requestPro(request, response);
			
		}catch(Throwable e) {
			throw new ServletException();
		}
		RequestDispatcher dispatcher2 = request.getRequestDispatcher(view2);
		dispatcher2.forward(request, response);
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		requestPro(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		requestPro(request, response);
	}

}

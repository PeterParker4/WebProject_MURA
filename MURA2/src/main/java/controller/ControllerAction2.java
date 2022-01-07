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

	
	// 명령어와 명령어 처리 클래스를 쌍으로 저장함
		private Map<String, Object> commandMap2 =
				new HashMap<String, Object>();
		
		/* 명령어와 처리 클래스가 매핑되어 있는 properties 파일을 읽어서 commandMap에 저장
		 * 매핑파일은 Command.properties 파일
		 * 
		 * web.xml에서 init-param에 해당하는 값을 읽어옴
		 */

		public void init(ServletConfig config) throws ServletException {
			String props2 = config.getInitParameter("propertyConfig2"); // 프로퍼티 파일을 읽어다 활용
			
			// 명령어와 처리클래스의 매핑정보를 저장할 properties 객체를 생성함
			Properties pro2 = new Properties();
			String path2 = config.getServletContext().getRealPath("/WEB-INF"); // 지정한 경로에서 파일을 읽어옴 
			
			FileInputStream f2 = null;
			
			try {
				
				//Command.properties 파일의 내용을 불러옴
				f2 = new FileInputStream(new File(path2, props2));
				
				//Command.properties 파일에 있는 매핑정보를 Properties 객체에 저장함
				pro2.load(f2);
				
			}catch(IOException e) {
				throw new ServletException(e);
			}finally {
				if(f2 != null) try {f2.close();}catch(IOException e) {}
			}
			
			// Iterator 객체 생성
			Iterator<Object> keyIter2 = pro2.keySet().iterator(); // key값만 가져옴 ?
			
			// 객체를 하나씩 꺼내서 그 객체명으로 properties 객체에 저장된 객체 접근함
			while(keyIter2.hasNext()) {
				
				String command2 = (String) keyIter2.next();
				String className2 = pro2.getProperty(command2);
				
				try {
					// 해당 문자열을 그대로 클래스로 만듦
					Class commandClass2 = Class.forName(className2);
					
					// 해당 클래스의 객체를 생성함
					Object commandInstance2 = commandClass2.newInstance();
					
					// Map 객체인 commandMap에 객체를 저장함
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

package com.mtory.action;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.util.locale.StringTokenIterator;

public class MtoryFrontController extends HttpServlet{
	
	
	
	protected void service(HttpServletRequest request,
			HttpServletResponse response)
		throws ServletException, IOException {
		
		String RequestURI=request.getRequestURI();
		String contextPath=request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		ActionForward forward= null;
		Action action=null;
		
		Properties prop = new Properties();
		FileInputStream fis = 
				new FileInputStream("C:\\git_4/gitRepositories1/mvc/build/classes/mvc.properties");
		
		prop.load(fis);
		fis.close();
		String value = prop.getProperty(command);
		//프로퍼티 파일 내용을 읽어들여 문자열 변수에 저장
		if(value.substring(0, 7).equals("execute")){
			try{
				StringTokenizer st = new StringTokenizer(value,"|");
				String url_1 = st.nextToken();
				String url_2 = st.nextToken();
				Class url = Class.forName(url_2);
				action = (Action)url.newInstance();
				try {
					forward=action.execute(request, response);
				}catch (Exception e) {
					e.printStackTrace();
				}
			}catch(ClassNotFoundException ex) {
				ex.printStackTrace();
			}catch (InstantiationException ex) {
				ex.printStackTrace();
			}catch(IllegalAccessException ex) {
				ex.printStackTrace();
			}
		}else{
			forward=new ActionForward();
			forward.setRedirect(false);
			forward.setPath(value);
			
		}
		
		
		if(forward != null){
			if(forward.isRedirect()){
				response.sendRedirect(forward.getPath());
				
			}else{
				RequestDispatcher dispatcher =
						request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
				
			}
		}
	}

}

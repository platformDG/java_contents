package com.varxyz.jv300.mod009;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class initializeCourseListenser implements ServletContextListener {
	
	@Override //톰캣 올라갈때 이벤트를 발생
	public void contextInitialized(ServletContextEvent event)  { 
		System.out.println("contextInitialized() method called");
		ServletContext context = event.getServletContext();
		InputStream is = null;
		BufferedReader reader = null;
		List<String[]> contentList = new ArrayList<String[]>();
		try {
			//데코레이팅 패턴
			is = context.getResourceAsStream("/WEB-INF/classes/cource_contents.txt");
			reader = new BufferedReader(new InputStreamReader(is));
			String record = null;
			while((record = reader.readLine()) != null) {
				record = escapeHtml(record);
				String[] fields = record.split("\t");
				contentList.add(fields);
			}
			context.setAttribute("contentList", contentList);
			System.out.println("The course contents has been loaded");
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override //톰캣을 shutdown할때 이벤트 발생
    public void contextDestroyed(ServletContextEvent event)  { 
		System.out.println("contextDestroyed() method called");
    }
	
	private String escapeHtml(String line) {
		if(line.length() == 0) {
			return line;
		}
		return line.replace("<", "&lt;").replace(">", "&gt;");
	}
}

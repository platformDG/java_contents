package com.varxyz.jv300.mod002;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MultiplicationTable extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		String pageTitle = "구구단";
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>"+pageTitle+"</title></head>");
		out.println("<style> p { display : flex; margin-left: 10px; }");
		out.println(" span { width : 100px; text-align : left; position : relative; border-bottom : 1px solid red; } span::before { content : ''; display: block; width: 5px; height: 5px; position : absolute; left : -10px; top: calc(50% - 2.5px); background-color : red;");
		out.println("</style>");
		out.println("<body>");
		out.println("<h3>구구단</h3>");
		
		for (int i = 1; i < 10; i++ ) {
			out.println("<p>");
			for(int j = 2; j < 10; j++) {
				int result = i*j;
				out.println("<span>"+j +" * " +i+" = "+result+"</span>");
			}
			out.println("</p>");
		};
		
		out.println("</body></html>");
		out.close();
	}

}

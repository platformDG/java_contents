package com.varxyz.jv300.mod004;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormBaseHelloServlet
 */

@WebServlet("/mod004/hello.do")
public class FormBaseHelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String DEFAULT_NAME = "world";
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("userName");
		if (name == null || name.length() == 0) {
			name = DEFAULT_NAME;
		}
		String pageTitle = "Hello World";
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>"+pageTitle+"</title></head>");
		out.println("<body>");
		out.println("<h3> 안녕하세요 !! "+name+" 입니다.!!</h3>");
		out.println("</body></html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}

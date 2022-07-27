package com.varxyz.jv300.mod004;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddUserServlet
 */
@WebServlet("/mod004/add_user.do")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId= null;
		String passwd = null;
		String userName = null;
		String ssn = null;
		String email1 = null;
		String email2 = null;
		String[] concerns = null;
		
		if(checkRequestValue(request.getParameter("userId"))) {
			userId = request.getParameter("userId");
		}
		else {
			throw new IOException("아이디를 가져올수 없습니다.");
		}
		
		if(checkRequestValue(request.getParameter("passwd"))) {
			passwd = request.getParameter("passwd");
		}
		else {
			throw new IOException("비밀번호를 가져올수 없습니다.");
		}
		
		if(checkRequestValue(request.getParameter("userName"))) {
			userName = request.getParameter("userName");
		}
		else {
			throw new IOException("이름를 가져올수 없습니다.");
		}
		
		if(checkRequestValue(request.getParameter("ssn"))) {
			ssn = request.getParameter("ssn");
		}
		else {
			throw new IOException("생년월일를 가져올수 없습니다.");
		}
		
		if(checkRequestValue(request.getParameter("email1"))) {
			email1 = request.getParameter("email1");
			email2 = request.getParameter("email2");
		}
		else {
			throw new IOException("이메일를 가져올수 없습니다.");
		}
		
		if(checkRequestValue(request.getParameter("concerns"))) {
			concerns = request.getParameterValues("concerns");
		}
		else {
			concerns = new String[1];
			concerns[0] = "관심분야가 없습니다.";
		}

		String pageTitle = "회원가입 결과";
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>"+pageTitle+"</title><link rel='stylesheet' href='../css/style.css'></head>");
		out.println("<body>");
		out.println("<h3 class='header'> 회원가입 정보 </h3>");
		out.println("<div class='wrap'>");
		out.println("<table border='1'>");
		out.println("<tr><td>아이디</td><td>"+userId+"</td></tr>");
		out.println("<tr><td>비밀번호</td><td>"+passwd+"</td></tr>");
		out.println("<tr><td>이름</td><td>"+userName+"</td></tr>");
		out.println("<tr><td>주민번호</td><td>"+ssn+"</td></tr>");
		out.println("<tr><td>이메일주소</td><td>"+email1+"@"+email2+"</td></tr>");
		out.println("<tr><td>관심분야</td><td>");
		for(String concern : concerns) {
			out.println(concern);
		}
		out.println("</td></tr>");
		out.println("</table></div></body></html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId= null;
		String passwd = null;
		String userName = null;
		String ssn = null;
		String email1 = null;
		String email2 = null;
		String[] concerns = null;
		request.setCharacterEncoding("UTF-8");
		if(checkRequestValue(request.getParameter("userId"))) {
			userId = request.getParameter("userId");
		}
		else {
			throw new IOException("아이디를 가져올수 없습니다.");
		}
		if(checkRequestValue(request.getParameter("passwd"))) {
			passwd = request.getParameter("passwd");
		}
		else {
			throw new IOException("비밀번호를 가져올수 없습니다.");
		}
		
		if(checkRequestValue(request.getParameter("userName"))) {
			userName = request.getParameter("userName");
		}
		else {
			throw new IOException("이름를 가져올수 없습니다.");
		}
		
		if(checkRequestValue(request.getParameter("ssn"))) {
			ssn = request.getParameter("ssn");
		}
		else {
			throw new IOException("생년월일를 가져올수 없습니다.");
		}
		if(checkRequestValue(request.getParameter("email1"))) {
			email1 = request.getParameter("email1");
			email2 = request.getParameter("email2");
		}
		else {
			throw new IOException("이메일를 가져올수 없습니다.");
		}
		if(checkRequestValue(request.getParameter("concerns"))) {
			concerns = request.getParameterValues("concerns");
		}
		else {
			concerns = new String[1];
			concerns[0] = "관심분야가 없습니다.";
		}

		String pageTitle = "회원가입 결과";
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>"+pageTitle+"</title><link rel='stylesheet' href='../css/style.css'></head>");
		out.println("<body>");
		out.println("<h3 class='header'> 회원가입 정보 </h3>");
		out.println("<div class='wrap'>");
		out.println("<table border='1'>");
		out.println("<tr><td>아이디</td><td>"+userId+"</td></tr>");
		out.println("<tr><td>비밀번호</td><td>"+passwd+"</td></tr>");
		out.println("<tr><td>이름</td><td>"+userName+"</td></tr>");
		out.println("<tr><td>주민번호</td><td>"+ssn+"</td></tr>");
		out.println("<tr><td>이메일주소</td><td>"+email1+"@"+email2+"</td></tr>");
		out.println("<tr><td>관심분야</td><td>");
		for(String concern : concerns) {
			out.println(concern);
		}
		out.println("</td></tr>");
		out.println("</table></div></body></html>");
		out.close();
	}
	
	public boolean checkRequestValue(String value) {
		if (value == null || value.length() == 0) {
			return false;
		}
		else {
			return true;
		}
	}
}

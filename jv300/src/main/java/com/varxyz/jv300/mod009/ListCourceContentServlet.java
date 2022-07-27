package com.varxyz.jv300.mod009;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mod009/list_cource_contents.do")
public class ListCourceContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static List<String[]> contentList;
	private static List<String> sendData = new ArrayList<String>();
	
	@SuppressWarnings("unchecked")
	public void init(ServletConfig config) throws ServletException {
		ServletContext context = config.getServletContext();
		contentList = (List<String[]>)context.getAttribute("contentList");
		sendData = tapToSpace(contentList);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setAttribute("contentList", sendData);
		request.getRequestDispatcher("list_cource_contents.jsp")
				.forward(request, response);
	}
	
	private List<String> tapToSpace(List<String[]> contentList){
		List<String> lineList = new ArrayList<String>();
		if(contentList.size() > 0) {
			for(String[] s : contentList) {
				if(isEmptyLine(s)) {
					continue;
				}
				for(int i=0; i<s.length; i++) {
					if(s[i].length() == 0) {
						//s[i] = "&nbsp;&nbsp;&nbsp;&nbsp;";
						s[i] ="<span class='tab'>";
						s[s.length - 1] = s[s.length -1] + "</span>";
					}
				}
			}
		}else {
			lineList.add("-No Data-");
		}
		String line ="";
		for(String[] aa : contentList) {
			for(String a : aa) {
				line += a;
			}
			lineList.add(line);
			line= "";
		}
		
		return lineList;
	}
	
	private boolean isEmptyLine(String[] s) {
		if(s[0].length() == 0 && s.length == 1) {
			return true;
		}
		else {
			return false;
		}
	}
}

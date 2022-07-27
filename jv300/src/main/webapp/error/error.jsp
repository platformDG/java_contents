<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 방법1 
<% 	
	List<String> errorMsgs = new ArrayList<String>();
	for (String s : (List<String>)request.getAttribute("errMsgs") ){
		errorMsgs.add(s);
	}
%>
<%
for (int i = 0; i< errorMsgs.size(); i++){
%>
	<h3><%= errorMsgs.get(i).toString() %></h3>
	
	<%
}
%>
실패했습니다!!
 --%>
 <%-- 방법2 --%>
 <c:if test="${not empty errMsgs}">
 	<ul>
	<c:forEach var="message" items="${errMsgs}">
		<li>${message}</li>
	</c:forEach>
	</ul>
</c:if>
</body>
</html>
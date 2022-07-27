<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>서브릿 리스너 자료 가져오기</title>
  <style>
    html,body {
      margin: 20px;
      padding: 0;
    }
    ul,li {
    list-style: none;
    margin: 0;
    padding: 0;
    }
    ul {
      width: 350px;
      height: 350px;
      background-color : beige;
    }
    .tab {
      margin-left: 40px;
    }
  </style>
</head>
<body>
	<h3>서브릿 리스너 자료 가져오기.</h3>
	<form action="list_cource_contents.do" method="get">
		<input type="submit" value="확인">
	</form>
	<c:forEach var="message" items="${contentList}">
			${message} <br>
	</c:forEach>
</body>
</html>
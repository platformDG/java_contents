<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>dgCafe</title>
</head>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/default.css'/>">
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/style.css'/>">
<body>
<header>
<%@ include file="../include/header.jsp" %>
</header>
<div class="wrap">
	<div class="inner-wrap">
		<form:form method="post" modelAttribute="category" class="cform">
				<label>카테고리메뉴</label>
				<form:input path="categoryName" class="iform" />
				<label>서브카테고리메뉴</label>
				<form:input path="subCategoryName" class="iform" />
				<input type="submit" class="in-btn" value="추가하기" />
		</form:form>
	</div>
	<p class="msg ${psuh}">${msg}</p>
	<div class="inner-wrap2 cate-table">
		<table class="inner-table">
		<thead>
		<tr>
			<th>번호</th>
			<th>카테고리이름</th>
			<th>서브카테고리이름</th>
			<th>날짜</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="li" items="${list}">
		<tr>
			<td>${li.cid}</td>
			<td>${li.categoryName}</td>
			<td>${li.subCategoryName}</td>
			<td>${li.regDate}</td>
		</tr>
		</c:forEach>
		</tbody>
		</table>
	</div>
</div>
</div>
</body>
</html>
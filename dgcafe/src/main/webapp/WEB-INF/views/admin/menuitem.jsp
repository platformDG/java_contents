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
	<div class="inner-wrap menuitem">
		<form action="menuitem" method="post" enctype="multipart/form-data" class="cform">
			<label>메인카테고리</label>
			<select name='categoryName' class="iform">
				<option value='' selected>-- 선택 --</option>
				<c:forEach var="cate" items="${category}">
				<option name="categoryName" value="${cate.categoryName}">${cate.categoryName}</option>
				</c:forEach>
			</select>
			<label>서브카테고리</label>
			<select name='subCategoryName' class="iform">
				<option value='' selected>-- 선택 --</option>
				<c:forEach var="cate" items="${category}">
				<option name="subCategoryName" value="${cate.subCategoryName}">${cate.subCategoryName}</option>
				</c:forEach>
			</select>
			<label>메뉴이름</label><input type="text" name="menuItem" placeholder="메뉴이름" class="iform">
			<label>가격</label><input type="text" name="menuPrice" placeholder="가격" class="iform"><br>
			<input type="file" name="file">
			<input type="submit" class="in-btn" value="추가하기">
		</form>
	</div>
	<p class="msg ${psuh}">${msg}</p>
	<div class="inner-wrap2 i-table">
		<table class="inner-table">
		<thead>
		<tr>
			<th>번호</th>
			<th>카테고리</th>
			<th>서브카테고리</th>
			<th>메뉴이름</th>
			<th>메뉴가격</th>
			<th>등록날짜</th>
			<th>사진</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="li" items="${menuitem}">
		<tr>
			<td>${li.mid}</td>
			<td>${li.category.categoryName}</td>
			<td>${li.category.subCategoryName}</td>
			<td>${li.menuName}</td>
			<td><fmt:formatNumber value="${li.menuPrice}" pattern="#,###"/></td>
			<td>${li.regDate}</td>
			<td><img src="<c:url value='/resources/image/${li.imageName}'/>" style="width:100px; height: 100px;" /></td>
		</tr>
		</c:forEach>
		</tbody>
		</table>
	</div>
</div>
</body>
</html>
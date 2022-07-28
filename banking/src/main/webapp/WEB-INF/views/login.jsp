<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>회원가입</title>
	<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/default.css'/>">
	<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/style.css'/>">
</head>

<body>
	<section>
		<div class="container">
			<div class="title-wrap">
				<h3 class="title">로그인</h3>
			</div>
			<div id="content-wrapper">
				<div class="content">
					<form class="add_user" action="index" method="post">
						<div class="add">
							<input type="text" name="userId" placeholder="아이디">
						</div>
						<div class="add">
							<input type="password" name="passwd" placeholder="비밀번호">
						</div>
						<p style="color:red">${errMsg}</p>
						<div class="btn-group">
							<div class="i-btn">
								<div class="btn">
									<button type="submit" class="btn-inner">로그인</button>
								</div>
								<div class="btn">
									<a href="add_customer/add_customer" class="in-btn">회원가입</a>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</section>
</body>
</html>
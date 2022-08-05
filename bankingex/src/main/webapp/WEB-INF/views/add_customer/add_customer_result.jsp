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
				<h3 class="title">가입성공</h3>
			</div>
			<div id="content-wrapper">
				<div class="content">
					<form class="add_user" action="" method="post">
						<div class="add">
							<span class="text on3">${customer.name}님 반갑습니다.</span>
						</div>
						<div class="add">
							<span class="text on3">다시 로그인 해주시기 바랍니다.</span>
						</div>
							<div class="i-btn on">
								<div class="btn">
									<a href="<c:url value='/login'/>" class="in-btn">홈</a>
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
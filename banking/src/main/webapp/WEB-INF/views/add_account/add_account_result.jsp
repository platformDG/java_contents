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
	<header>
    	<%@ include file="../include/header.jsp" %>
	</header>
	<section>
		<div class="container">
			<div class="title-wrap">
				<h3 class="title">계좌가입완료!</h3>
			</div>
			<div id="content-wrapper">
				<div class="content">
					<form class="add_user" action="" method="post">
						<div class="add">
							<span class="text wide">가입 완료되었습니다!</span>
						</div>
						<div class="btn-group">
							<div class="i-btn">
								<div class="btn">
									<a href="<c:url value='/index'/>" class="in-btn">홈</a>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</section>
	<script>
	window.onload = function(){
		if(document.getElementById('radio1').checked == true){
			document.getElementById('darftOrRate').placeholder ="이자율";
		}
		if(document.getElementById('radio2').checked == true){
			document.getElementById('darftOrRate').placeholder ="대출한도";
		}
	};
	</script>
</body>
</html>
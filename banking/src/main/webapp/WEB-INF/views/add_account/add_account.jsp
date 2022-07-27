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
		<div class="container wide2">
			<div class="title-wrap">
				<h3 class="title">계좌가입</h3>
			</div>
			<div id="content-wrapper">
				<div class="content">
					<form class="add_user" action="add_account" method="post">
						<div class="add">
							<input type="radio" id="radio1" class="radio" name="accType" value="S" onclick=window.onload()><span class="text">SAVING</span>
							<input type="radio" id="radio2" class="radio" name="accType" value="C" onclick=window.onload()><span class="text">CHECHING</span>
						</div>
						<div class="add">
							<span class="text on2">대출한도/이자율</span><input type="text" name="darftOrRate" id="darftOrRate" placeholder="대출한도 / 이자율">
						</div>
						<div class="add">
							<span class="text on2">초기입금금액</span><input type="text" name="balance" id="balance" value="0">
						</div>
						<div class="add">
							<span class="text on2">회원아이디</span><input type="text" name="userId" placeholder="회원아이디" value="${userId}" readonly>
						</div>
						<div class="btn-group">
							<div class="i-btn">
								<div class="btn">
									<button type="submit" class="btn-inner">확인</button>
								</div>
								<div class="btn">
									<a href="../index" class="in-btn">취소</a>
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
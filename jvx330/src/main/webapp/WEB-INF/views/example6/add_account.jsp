<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>계좌가입</h3>	
	<form:form method="post" modelAttribute="account">
		<form:radiobutton path="accType" value="s"/> SavingsAccount
		<form:radiobutton path="accType" value="c"/> CheckingAccount<br>
		<label>초기잔액 : </label> <form:input path="balance"/>
		<label>이름 : </label> <form:input path="customerCommand.name"/>
		<input type="submit" value="생성하기"/>
	</form:form>
</body>
</html>
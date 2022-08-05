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
	<h3>계좌가입완료</h3>
	<label>계좌타입 : </label> ${account.accType}
	<label>초기잔액 : </label> ${account.balance}
	<label>이름 : </label> ${account.customerCommand.name}	
</body>
</html>
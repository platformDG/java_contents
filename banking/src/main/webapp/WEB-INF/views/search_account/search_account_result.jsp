<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <title>계좌목록찾기</title>
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
        <h3 class="title">계좌목록결과</h3>
      </div>
      <div id="content-wrapper">
        <div class="content">
          <form class="add_user" action="search_account" method="post">
          <c:forEach var="li" items="${list}"> 
            <div class="add">
              <span class="text on2">계좌번호</span><input type="text" class="on" name="accountType" value=${li.accountNum}>
              <span class="text on2">계좌타입</span><input type="text" class="on"name="accType" value=${li.accType}>
            </div>
          </c:forEach>
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
</body>

</html>
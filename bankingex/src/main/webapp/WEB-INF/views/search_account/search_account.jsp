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
        <h3 class="title">계좌목록찾기</h3>
      </div>
      <div id="content-wrapper">
        <div class="content">
          <form class="add_user" action="search_account" method="post">
            <div class="add">
              <span class="text on2">회원아이디</span><input type="text" name="userId" placeholder="회원아이디" value="${userId}" readonly>
            </div>
            <div class="btn-group">
              <div class="i-btn">
                <div class="btn">
                  <button type="submit" class="btn-inner">확인</button>
                </div>
                <div class="btn">
                   <a href="<c:url value='/main'/>" class="in-btn">취소</a>
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
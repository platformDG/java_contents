<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <title>계좌송금</title>
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
        <h3 class="title">계좌송금</h3>
      </div>
      <div id="content-wrapper">
        <div class="content">
          <form class="add_user" action="transfer_balance" method="post">
            <div class="add">
              <select class="select" name='outputAccountNum'>
                <option value='' selected>-- 선택 --</option>
                <c:forEach var="li" items="${list}">
                  <option name="outputAccountNum" value="${li.accountNum}">${li.accountNum}</option>
                </c:forEach>
              </select>
            </div>
            <div class="add">
              <input type="text" name="balance" placeholder="출금할금액">
            </div>
            <div class="add">
              <input type="text" name="inputAccountNum" placeholder="입금계좌">
            </div>
             <div class="add">
              <input type="test" name="userId" value="${userId}" readonly>
            </div>
            <div class="add">
              <input type="password" name="passwd" placeholder="비밀번호">
            </div>
            <p style="color:red">${errMsg}</p>
            <div class="btn-group">
              <div class="i-btn">
                <div class="btn">
                  <button type="submit" class="btn-inner">송금</button>
                </div>
                <div class="btn">
                  <a href="<c:url value='/index'/>" class="in-btn">취소</a>
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
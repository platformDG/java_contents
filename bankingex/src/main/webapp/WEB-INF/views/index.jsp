<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <title>은행서비스</title>
  <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/default.css'/>">
  <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/header.css'/>">
  <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/style.css'/>">
</head>

<body>
	<header>
    	<%@ include file="include/header.jsp" %>
	</header>
  <section>
    <div class="container">
      <div class="title-wrap">
        <h3 class="title">서비스메뉴</h3>
      </div>
      <div id="content-wrapper">
        <div class="content">
          <div class="add">
            <div class="i-btn">
              <div class="btn">
                <a href="add_account/add_account" class="in-btn">계좌생성</a>
              </div>
            </div>
          </div>
          <div class="add">
            <div class="i-btn">
              <div class="btn">
                <a href="search_account/search_account" class="in-btn">계좌목록검색</a>
              </div>
            </div>
          </div>
          <div class="add">
            <div class="i-btn">
              <div class="btn">
                <a href="transfer_balance/transfer_balance" class="in-btn">계좌송금</a>
              </div>
            </div>
          </div>
          <div class="add">
            <div class="i-btn">
              <div class="btn">
                <a href="checking_balance/checking_balance" class="in-btn">잔액조회</a>
              </div>
            </div>
          </div>
          <div class="add">
            <div class="i-btn">
              <div class="btn">
                <a href="save_interest/save_interest" class="in-btn">이자지급</a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
</body>

</html>
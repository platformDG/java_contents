<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/default.css'/>">
  <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/header.css'/>">
<div id="header" class="login_on">
      <div class="header-wrap">
        <div class="gnb">
          <div class="left-gnb">
            <ul>
              <li><a href="<c:url value='/main'/>">홈</a></li>
            </ul>
          </div>
          <div class="right-gnb">
            <ul>
              <li><a href="<c:url value='/add_account/add_account'/>" class="in-btn">계좌생성</a></li>
              <li><a href="<c:url value='/search_account/search_account'/>" class="in-btn">계좌목록검색</a></li>
              <li><a href="<c:url value='/transfer_balance/transfer_balance'/>" class="in-btn">계좌송금</a></li>
              <li><a href="<c:url value='/checking_balance/checking_balance'/>" class="in-btn">잔액조회</a></li>
              <li><a href="<c:url value='/save_interest/save_interest'/>" class="in-btn">이자지급</a></li>
              <li><a href="<c:url value='/login'/>">로그아웃</a></li>
            </ul>
          </div>
        </div>
      </div>
    </div>
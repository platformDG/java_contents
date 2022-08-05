<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<html>
  <head>
    <title>DGCafe</title>
  </head>
  <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/default.css'/>">
  <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/home.css'/>">
  <body>
    <div class="wrap">
      <h1>DG</h1>
      <h2>CAFE</h2>
      <div class="i-btn">
        <div class="btn">
          <a href="order/orderlist/all" class="in-btn">주문하기</a>
        </div>
        <div class="btn">
          <a href="admin/category" class="in-btn">관리자페이지</a>
        </div>
      </div>
    </div>
 </body>
</html>

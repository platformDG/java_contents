<%@ page import="java.net.URLEncoder" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="utf-8">
  <title>회원가입</title>
  <link rel="stylesheet" href="../css/style.css">
  <!-- CSS only -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="text-center">
  <div class="container">
    <div id="header">
      <jsp:include page="/incl/banner.jsp">
        <jsp:param name="subtitle" value='<%=URLEncoder.encode("mod010 : 자바빈즈", "UTF-8") %>' />
      </jsp:include>
    </div>
   <div>
   <h3>회원목록</h3>
	  <c:forEach var="message" items="${listStr}">
			${message} <br>
	</c:forEach>
   </div>
    <div id="footer">
      <%@ include file="/incl/footer.jsp" %>
    </div>
  </div>
  <!-- JavaScript Bundle with Popper -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>
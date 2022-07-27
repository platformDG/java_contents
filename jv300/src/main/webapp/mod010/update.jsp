<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="utf-8">
  <title>회원가입</title>
   <link rel="stylesheet" href="../css/style.css">
   <!-- CSS only -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
  <div class="wrap">
    <div id="header">
      <jsp:include page="/incl/banner.jsp">
        <jsp:param name="subtitle" value="mod007 : Java Beans and include" />
      </jsp:include>
    </div>
    <div id="content-wrapper">
      <div class="wrap">
      	<h3>업데이트 되었습니다.</h3>
      	${user.userId}
    </div>
    <div id="footer">
      <%@ include file="/incl/footer.jsp" %>
    </div>
  </div>
  <!-- JavaScript Bundle with Popper -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
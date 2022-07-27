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
    <main class="orm-signin w-100 m-auto" class="text-center">
    
    	<form action="user_search.do" method="post">
    		<input type="text" name="updateName">
    		<input type="submit" value="이름 검색하기"> 
    	</form>
     </main>
     	 <main class="orm-signin w-100 m-auto" class="text-center">
      <form action="user_update.do" method="post">
        <h1 class="h3 mb-3 fw-normal">회원수정</h1>
        <div class="form-floating">
          <input type="text" class="form-control" id="floatingInput" placeholder="아이디" name="userId" value ="${user.getUserId()}">
          <label for="floatingInput">아이디</label>
        </div>
        <div class="form-floating">
          <input type="password" class="form-control" id="floatingInput" placeholder="비밀번호" name="passwd">
          <label for="floatingInput">비밀번호</label>
        </div>
        <div class="form-floating">
          <input type="text" class="form-control" id="floatingInput" placeholder="이름" name="userName" value ="${user.getUserName()}">
          <label for="floatingInput">이름</label>
        </div>
        <div class="form-floating">
          <input type="text" class="form-control" id="floatingInput" placeholder="주민번호" name="ssn" value ="${user.getSsn()}">
          <label for="floatingInput">주민번호</label>
        </div>
        <div class="form-floating">
          <input type="text" class="form-control" id="floatingInput" placeholder="이메일1" name="email1" value ="${user.getEmail()}">
          <label for="floatingInput">E-mail ID</label>
        </div>
        <div class="form-floating">
          <input type="text" class="form-control" id="floatingInput" placeholder="주소1" name="addr1" value ="${user.getAddr()}">
          <label for="floatingInput">주소</label>
        </div>
        <p class="btn-2"> <input type="submit" value="수정하기" class="btn btn-lg btn-primary btn-2"></p>
      </form>
    </main>
    <div id="footer">
      <%@ include file="/incl/footer.jsp" %>
    </div>
  </div>
  <!-- JavaScript Bundle with Popper -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>
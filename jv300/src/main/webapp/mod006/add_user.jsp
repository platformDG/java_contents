<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <title>회원가입</title>
    <link rel="stylesheet" href="../css/style.css">
  </head>
  <body>
    <div class="wrap">
      <form class="signup" action="add_user.do" method="post">
          <h3>회원가입</h3>
          <p><span>아이디 : </span><input type="text" name="userId" value="" placeholder="아이디"> </p>
          <p><span>비밀번호 : </span><input type="password" name="passwd" value="" placeholder="비밀번호"></p>
          <p><span>이름 : </span><input type="text" name="userName" value="" placeholder="이름"></p>
          <p><span>주민번호 : </span><input type="text" name="ssn" value="" placeholder="주민번호앞자리"></p>
          <p><span>이메일 : </span><input type="text" name="email1" value="" placeholder="이메일">@
          <select class="select" name="email2">
              <option value="naver.com">naver.com</option>
              <option value="gmail.com">gmail.com</option>
              <option value="kakao.com">kakao.com</option>
          </select>
          </p>
          <p><span>주소 : </span><input type="text" name="addr1" value="" placeholder="주소"><input type="text" name="addr1" value="" placeholder="상세주소"></p>
          <p class="btn"> <input type="submit"value="가입하기"> <input type="reset" value="취소하기"> </p>
      </form>
    </div>
  </body>
</html>
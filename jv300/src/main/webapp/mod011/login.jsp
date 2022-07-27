<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
    <style>
 		main {
 		 margin : 0 auto;
 		 margin-top : 300px;
 		 width : 500px;
 		 height: 500px;
 		}
    </style>
	<!-- CSS only -->
  	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="text-center">    
	<main class="form-signin">
	  <form action="login" method="post">
	    <h1 class="h3 mb-3 fw-normal">Please Log in</h1>
	    <div class="form-floating">
	      <input type="text" class="form-control" id="floatingInput" placeholder="Id" name ="userId">
	      <label for="floatingInput">Id</label>
	    </div>
	    <div class="form-floating">
	      <input type="password" class="form-control" id="floatingPassword" placeholder="Password" name ="passwd">
	      <label for="floatingPassword">Password</label>
	    </div>
	    <button class="w-100 btn btn-lg btn-primary" type="submit">Log in</button>
	  </form>
	</main>
	<!-- JavaScript Bundle with Popper -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"></script>
  </body>
</html>
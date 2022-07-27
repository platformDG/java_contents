<%@ page import="java.net.URLDecoder" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="banner">
	<nav class="navbar navbar-expand-lg bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#"><%=URLDecoder.decode(request.getParameter("subtitle"), "UTF-8") %></a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
      <div class="navbar-nav">
        <a class="nav-link active" aria-current="page" href="/jv300/mod010/add_user.jsp">Home</a>
        <a class="nav-link" aria-current="page" href="/jv300/mod010/list_user.do">LIST</a>
        <a class="nav-link" aria-current="page" href="/jv300/mod010/user_update.jsp">UPDATE</a>
        <a class="nav-link" aria-current="page" href="/jv300/mod011/login">LOGIN</a>
      </div>
    </div>
  </div>
</nav>
</div>
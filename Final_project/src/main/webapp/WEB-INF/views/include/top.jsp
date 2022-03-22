<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
	<title>Final Login</title>
</head>
<body>
	<div class="container-fluid  bg-dark text-white ">
	
	
	
	<h1>프로젝트</h1>
  	<p style="margin: 0px 0px">
  		Spring MVC 기반의 웹 어플리케이션 
  	</p>
  	
	</div>
	
	<c:choose>
		<c:when test="${empty sessionScope.loginUser }">
		
	
<nav class="navbar navbar-expand-sm bg-light navbar-light">
  <ul class="navbar-nav">
    <li class="nav-item ${empty nav? 'active' : '' }">
      <a class="nav-link" href="/">Home</a>
    </li>
    <li class="nav-item" ${nav eq 'sign'? 'active' : '' }>
      <a class="nav-link" href="/signup">회원가입</a>
    </li>
    <li class="nav-item" ${nav eq 'sign'? 'active' : '' }>
      <a class="nav-link" href="/login">로그인</a>
    </li>
    <li class="nav-item">
      <a class="nav-link disabled" href="#">Disabled</a>
    </li>
  </ul>
</nav>
	
		</c:when>
		<c:otherwise>

<nav class="navbar navbar-expand-sm bg-light navbar-dark">
  <ul class="navbar-nav">
    <li class="nav-item ${empty nav? 'active' : '' }">
      <a class="nav-link" href="/">Home</a>
    </li>

    <li class="nav-item" ${nav eq 'sign'? 'active' : '' }>
      <a class="nav-link disabled" href="/message">메세지</a>
    </li>
  </ul>
</nav>
  
		
			
		</c:otherwise>
	</c:choose>
</body>
</html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="security"
  uri="http://www.springframework.org/security/tags" %>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Home</title>

  <!-- Bootstrap core CSS -->
  <link href="./resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom fonts for this template -->
  <link href="./resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Varela+Round" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="./resources/css/grayscale.min.css" rel="stylesheet">

</head>

<body id="page-top">

  
  	<h1>Main Page</h1> 
	등급 : 
		<security:authorize access="hasRole('ROLE_USER')">
		   user
		    <br/>
		</security:authorize>
		<security:authorize access="hasRole('ROLE_CREATOR')">
		    creator
		    <br/>
		</security:authorize>
		<security:authorize access="hasRole('ROLE_ADMIN')">
		    admin
		    <br/>
		</security:authorize>
      	<br/>
   	<security:authorize access="isAnonymous()">

	<a href="${CONTEXT }/login">로그인</a>

	</security:authorize>


   	<security:authorize access="isAuthenticated()">

	<a href="${CONTEXT }/login">로그아웃</a>

	</security:authorize>


  <!-- Footer -->
  <footer class="bg-light-gray small text-center text-black-50">
    <div class="container">
      Copyright &copy; Your Website 2019
    </div>
  </footer>

  <!-- Bootstrap core JavaScript -->
  <script src="./resources/vendor/jquery/jquery.min.js"></script>
  <script src="./resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Plugin JavaScript -->
  <script src="./resources/vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for this template -->
  <script src="./resources/js/grayscale.min.js"></script>

</body>

</html>

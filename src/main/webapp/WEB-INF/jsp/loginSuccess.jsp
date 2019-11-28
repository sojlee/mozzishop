<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="security"
  uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Login Success ... <br/>
사용자 정보 받기. <br/>

<security:authorize access="hasRole('ROLE_USER')">
    This text is only visible to a user
    <br/>
</security:authorize>
<security:authorize access="hasRole('ROLE_CREATOR')">
    This text is only visible to a creator
    <br/>
</security:authorize>
<security:authorize access="hasRole('ROLE_ADMIN')">
    This text is only visible to an admin
    <br/>
</security:authorize>

</body>
</html>
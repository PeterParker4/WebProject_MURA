<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.model.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 확인</title>
</head>
<body>
<c:set var="flag" value="${flag }" />
<br><br>
<div align="center">
	<c:choose>
	<c:when test="${flag }">
	<b>환영합니다 회원가입을 축하드립니다!</b><br>
	<a href="login.jsp">로그인</a>
	</c:when>
	<c:otherwise>
	<b>다시 입력해 주세요</b>
	<a href="signinForm.jsp">다시입력</a>
	</c:otherwise>
	</c:choose> 
</div>
</body>
</html>
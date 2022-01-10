<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.model.MemberDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ID 중복 체크</title>
<script type="text/javascript" src="script.jsp"></script>
</head>
<body>
	<br>
	<div align="center">
		<b>${id_mem}</b>
		<c:if test="${check eq true}">
			이미 존재하는 아이디입니다. <br>
		</c:if>
		<c:if test="${check ne true}">
			는 사용 가능한 ID 입니다.	<br>
		</c:if>
		<a href="#" onclick="javascript:self.close()">닫기</a>
	</div>
</body>
</html>
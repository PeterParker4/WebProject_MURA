<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="member.model.MemberDAO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" http-equiv="refresh" content="3; url=/MURA2/page/member/login.mur">
<title>회원 탈퇴</title>
<style type="text/css">
body {
	background-image: #34495e;
}

.joinForm {
	width: 400px;
	height: 400px;
	padding: 30px, 20px;
	background-color: #FFFFFF;
	text-align: center;
	border-radius: 15px;
}

.joinForm h2 {
	text-align: center;
	margin: 30px;
}

.textForm {
	border-bottom: 2px solid #adadad;
	margin: 20px;
	padding: 10px 5px;
}

.id {
	width: 100%;
	border: none;
	outline: none;
	color: #636e72;
	font-size: 16px;
	height: 25px;
	background: none;
}

.btn {
	position: relative;
	left: 40%;
	transform: translateX(-50%);
	margin-bottom: 40px;
	width: 80%;
	height: 40px;
	background: linear-gradient(125deg, #a84781, yellow, green);
	background-position: left;
	background-size: 200%;
	color: white;
	font-weight: bold;
	border: none;
	cursor: pointer;
	transition: 0.4s;
	display: inline;
}

.btn:hover {
	background-position: right;
}

.btn2 {
	background-color: #fff;
	margin: 4px;
	width: 40%;
	height: 50%;
	border-radius: 10px;
	transition: 0.8s;
	display: inline;
	cursor: pointer;
}

.btn2:hover {
	color: #fff;
	background-color: black;
}
</style>
</head>
<script type="text/javascript" src="script.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<link rel="icon" type="image/x-icon" href="images/mura_logo.png">
<link href="css/style.css" rel="stylesheet" type="text/css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<body onload="begin()">
<c:set var="result" value="${result }" />
<div align="center">
<c:if test="${result eq 0 }">
<script type="text/javascript">
alert("비밀번호가 맞지 않습니다.");
history.go(-1);
</script>
</c:if>
<font size="5" face="궁서체">
회원 정보가 삭제되었습니다. <br><br>
3초 후에 Login 페이지로 이동합니다.

</font>
</div>
</body>
</html>
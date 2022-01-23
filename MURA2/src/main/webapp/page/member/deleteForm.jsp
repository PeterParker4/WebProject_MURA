<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
<link rel="icon" type="image/x-icon" href="../images/mura_logo.png">
<link href="../css/style.css" rel="stylesheet" type="text/css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<body onload="begin()">
	<!-- 상단 로고 -->
	<div class="logo">
	  <a href="/MURA2/page/index.mur"> 
	  <img src="../images/mura_logo2.png" width="230" height="230" border="0" alt=""></a>
	</div>
	
<form action="deleteProc.mur" name="myForm" method="post" onsubmit="return checkIt()">
<table width="260" border="1" align="center">
<tr>
	<td colspan="2" align="center">
	<b>회원탈퇴</b>
	</td>
</tr>	

<tr>
	<td width="150"><b>비밀번호입력:</b></td>
	<td width="110">
		<input type="password" name="pw_mem" size="15">
	</td>
</tr>

<tr>
	<td colspan="2" align="center">
	<input type="submit" value="회원탈퇴">
	<a href="myPage.mur" class="txt1"> <b>취소</b>
	</a>
	</td>
</tr>
</table>
</form>
</body>
</html>
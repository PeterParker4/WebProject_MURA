<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
request.setCharacterEncoding("utf-8");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이 페이지</title>
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
<body>
	<!-- 상단 로고 -->
	<div class="logo">
		<a href="../index.jsp"> <img src="images/topLogo.jpg" width="1194"
			height="230" border="0" alt=""></a>
	</div>
	<h1>유저 정보</h1>
	<div id="detail">
		<ul>
			<li>이름 : ${memberInfo.name_mem }</li>
			<li>닉네임 : ${memberInfo.nn_mem }</li>
			<li>이메일 : ${memberInfo.email_mem }</li>
			<li>폰번호 : ${memberInfo.tel_mem }</li>
			<li>집주소 : ${memberInfo.zc1_mem } ${memberInfo.zc2_mem }</li>
			<li>성별 : ${memberInfo.gender_mem }</li>
			<li><a href="modifyForm.mur">정보 수정</a></li>
			<li><a href="deleteForm.mur">회원 탈퇴</a></li>
		</ul>
		<!-- 좋아요, 게시글 목록 -->
	</div>

</body>
</html>
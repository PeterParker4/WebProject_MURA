<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>MURA :: 비밀번호 찾기</title>

<style type="text/css">

.bt{
width: 200px;
height: 50px;
font-size: 17px;

}

</style>
<script type="text/javascript" src="script.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<link rel="icon" type="image/x-icon" href="images/mura_logo.png">
<link href="../css/style.css" rel="stylesheet" type="text/css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<!--===============================================================================================-->
<link rel="icon" type="image/png" href="../images/icons/favicon.ico" />


</head>

<body bgcolor="#FFFFFF">

	<!-- 상단 로고 -->
	<div class="logo">
		<a href="../index.jsp"> <img src="../images/topLogo.jpg" width="1194"
			height="230" border="0" alt=""></a>
	</div>

	<div align="center">
	
		<img alt="" src="../images/cat.gif" width="220" height="220">
		
		<form role="form" method="post">
						<h2>비밀번호 찾기</h2>
						<h3>
							회원님의 비밀번호는 [&nbsp;<strong style="color: #a84781;">${pw_mem}</strong>&nbsp;] 입니다.
						</h3>
					
			<div>
					<button type="button" class="bt" onclick="location.href='login.mur'">로그인
						화면으로 돌아가기</button>
				
			</div>
		</form>
	</div>


	<div id="dropDownSelect1"></div>

	<!--===============================================================================================-->
	<script src="../vendor/jquery/jquery-3.2.1.min.js"></script>
	<!--===============================================================================================-->
	<script src="../vendor/animsition/js/animsition.min.js"></script>
	<!--===============================================================================================-->
	<script src="../vendor/bootstrap/js/popper.js"></script>
	<script src="../vendor/bootstrap/js/bootstrap.min.js"></script>
	<!--===============================================================================================-->
	<script src="../vendor/select2/select2.min.js"></script>
	<!--===============================================================================================-->
	<script src="../vendor/daterangepicker/moment.min.js"></script>
	<script src="../vendor/daterangepicker/daterangepicker.js"></script>
	<!--===============================================================================================-->
	<script src="../vendor/countdowntime/countdowntime.js"></script>
	<!--===============================================================================================-->
	<script src="js/main.js"></script>


</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="id_mem" value="${sessionScope.id_mem }" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>MURA :: 아이디 찾기</title>
<script type="text/javascript" src="script.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<link rel="icon" type="image/x-icon" href="../images/mura_logo.png">
<link href="../css/style.css" rel="stylesheet" type="text/css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<!--===============================================================================================-->
<link rel="icon" type="image/png" href="../images/icons/favicon.ico" />
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="../vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="../fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="../fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="../vendor/animate/animate.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="../vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="../vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="../vendor/select2/select2.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="../vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="../css/util.css">
<link rel="stylesheet" type="text/css" href="../css/main.css">
<!--===============================================================================================-->

</head>

<body bgcolor="#FFFFFF">

	<!-- 상단 로고 -->
	<div class="logo">
	  <a href="/MURA2/page/index.mur"> 
	  <img src="../images/mura_logo2.png" width="230" height="230" border="0" alt=""></a>
	</div>

	<form action="findPwAfter.mur" method="post"
		class="form-horizontal" role="form">
		<span class="login100-form-title p-b-51"> 비밀번호 찾기 </span>
		<h4 align="center">비밀번호는 이름, 아이디, 이메일을 통해 찾을 수 있습니다.</h4>
		<br>
		<br>
<div align="center">
	<table>
		<tr>
			<td><strong>NAME</strong></td>
				</tr>
		<tr>
		<td>
		<div>
			
						<input style="border: 2px solid black;" type="text" name="name_mem" placeholder="이름">
					
			
		</div>
		</td></tr>
		<tr>
						<td><strong>ID</strong></td>
							</tr>
		<tr><td>
		<div>
			
						<input style="border: 2px solid black;" type="text" name="id_mem" placeholder="아이디">
				
		</div>
		</td></tr>
		
		<tr>
						<td><strong>E-MAIL</strong></td>
							</tr>	
		<tr><td>
		<div>
			
						<input style="border: 2px solid black;" type="email" name="email_mem" placeholder="이메일">
					
		</div>
		</td></tr>
		
		
		<tr height="30"></tr>
		
		<tr><td>
		<div align="center">
			
				<button type="submit" style="border: 1px solid black;
							border-radius: 5px; width: 60px; height: 30px;">찾기</button>
			
		</div>
		</td></tr>
		</table>
	</div>
	</form>




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
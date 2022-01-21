<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="loginID" value="${sessionScope.loginID }" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>MURA :: 아이디 찾기</title>
<style type="text/css">

.txt{
border: 2px solid threedshadow;
width: 250px;
height: 45px;
margin: 4px;
border-radius: 4px;
font-size: 24px;

}

.txt::placeholder{
color: black;
opacity: 0.5;
}

.bt{
color:#fff;
font-size: 24px;
  padding: 6px 10px;
  width: 70px;
  background-color: #a84781;
  border-radius: 5px;
  -webkit-transition: all 0.4s;
  -o-transition: all 0.4s;
  -moz-transition: all 0.4s;
  transition: all 0.4s;
  border: none;
  box-shadow: 1px 1px 2px 1px black;
}

.bt:hover {
  background-color: #403866;
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
	<img alt="" src="../images/remem.gif" width="220" height="220">
</div>
	
				<form action="findIdAfter.mur" method="post" role="form">
					 
					<h2 align="center">이름과 이메일을 입력해주세요</h2>
					
					<div align="center">
						
						<input type="text" class="txt" name="name_mem" placeholder="이름">
							
					</div>

					
					<div align="center">
						
						<input type="email" class="txt" name="email_mem" placeholder="이메일">
								
					</div>
					<br>
					<div align="center">
						
						<button type="submit" class="bt">찾기</button>
						
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MURA :: 회원가입을 축하합니다 !!!</title>
<style type="text/css">

.con {
    width:100%;
    height: 50px;
    font-size: 30px;
    font-weight: 400;
}

.ho1{
color:#fff;
font-size: 16px;
  padding: 12px 40px;
  width: 23%;
  background-color: #a84781;
  border-radius: 10px;
  -webkit-transition: all 0.4s;
  -o-transition: all 0.4s;
  -moz-transition: all 0.4s;
  transition: all 0.4s;
  border: none;
}

.ho1:hover {
  background-color: #403866;
}


</style>
</head>
<script type="text/javascript" src="script.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<link rel="icon" type="image/x-icon" href="images/mura_logo.png">
<link href="css/style.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">

<body>

<div class="logo">
	  <a href="/MURA2/page/index.jsp"> 
	  <img src="images/topLogo.jpg" width="1194" height="230" border="0" alt=""></a>
	</div>

<div align="center">
	<table id="Table_01" width="1194" height="1081" border="0" cellpadding="0" cellspacing="0"">
		
		<tr></tr>
		<tr class="con" >
			<td></td>
		</tr>
		<tr>
		<td><img src="images/banga.jpg" width="210" height="210" border="0" alt=""></td>
		</tr>
		<tr height="40"></tr>
		
		<tr>
			<td><button type="button" class="ho1" onclick="window.location.href='http://localhost:9000/MURA2/page/login.jsp'">로그인하기</button>
			</td>
		</tr>
		
		<tr height="20"></tr>
		
		<tr>
			<td><button type="button" class="ho1" onclick="window.location.href='http://localhost:9000/MURA2/page/index.jsp'">홈페이지로 가기</button>
			</td>
		</tr>
	
	</table>


</div>



</body>
</html>
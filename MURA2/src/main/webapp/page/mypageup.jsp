<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MURA :: 마이페이지 수정</title>
<style type="text/css">


.ct{


width: 30%;
border-color: threeddarkshadow;
}

tr{
width: 300px;
height : 50px;
}

td{
border-color: black;
border-radius: 1px;

}

table{
border-radius: 5px;

}

.dd{
background-color: #FFDCFF;
color: black;
font-style: oblique;
font-weight: bolder;
}

p{

font-size: 33px;
font-weight: bold;
color: black;
}

.t1{
width : 30%;
height: 11px;
}

.btt{
color:#fff;
font-size: 16px;
  padding: 12px 40px;
  text-align:justify;
  width: 23%;
  background-color: #a84781;
  border-radius: 10px;
  -webkit-transition: all 0.4s;
  -o-transition: all 0.4s;
  -moz-transition: all 0.4s;
  transition: all 0.4s;
  font-style: inherit;
  
}

.btt:hover {
  background-color: #403866;
}

b{
text-align: justify;

}

.btt2{
width: 330px;
height: 30px;
}

.tel{
width:35px;
height: 25px;
}

.btt3{
width : 100px;
height: 25px;
border-radius: 5px;
float: right;

}

</style>

<script type="text/javascript" src="script.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<link rel="icon" type="image/x-icon" href="images/mura_logo.png">
<link href="css/style.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
</head>
<body>

<!-- 상단 로고 -->
	<div class="logo">
	  <a href="/MURA2/page/index.jsp"> 
	  <img src="images/topLogo.jpg" width="1194" height="230" border="0" alt=""></a>
	</div>
	
	
	<p align="center">
		<img src="images/mypage.jpg" width="30" height="30">
	MuRa : : My Page 
	</p>
<div>
	<table class="ct" border="1" cellpadding="3" cellspacing="0">
		<tr>
			<td colspan="2">
			<img src="images/toki.jpg" width="340" height="314" alt="">
			<br>
			<input type="button" name="내사진" class="btt3" value="내사진변경" onclick="">
			</td>
			
		</tr>
		
		<tr>
			<td class="dd" width="200" >성명</td><td>정수현</td>
		</tr>
		
		<tr>
			<td class="dd" width="200" >닉네임</td><td><input type="text" class="btt2" name="nickname"></td>
		</tr>
		
		<tr>
			<td class="dd" width="200">이메일</td><td><input type="text" class="btt2" name="email"></td>
		</tr>
		
		<tr>
			<td class="dd" width="200">H.P </td><td><input type="text" class="tel" name="tel" maxlength="3"> -
			<input type="text" class="tel" name="tel" maxlength="4"> - <input type="text" class="tel" name="tel" maxlength="4"></td>
		</tr>
		
		<tr>
			<td class="dd" width="200">집주소</td><td><input type="text" class="btt2" name="address"></td>
		</tr>
		
		<tr>
			<td class="dd" width="200">성별</td><td>남자</td>
		</tr>
		
		<tr>
			<td class="dd" width="200">비밀번호 변경</td><td><input type="password" class="btt2" name="pass1"></td>
		</tr>
		
		<tr>
			<td class="dd" width="200">비밀번호 확인</td><td><input type="password" class="btt2" name="pass2"></td>
		</tr>
	</table>
	
	<table class="ct">
	 	<tr>
	 		<td align="right"><input type="button" class="btt" name="저장하기" value="저장">
					<input type="button" class="btt" name="돌아가기" value="취소" onclick="window.location.href='http://localhost:9000/MURA2/page/mypage.jsp'""></td>
	 	</tr>
	</table>
</div>	
	
	
	
	
	
	
</body>
</html>
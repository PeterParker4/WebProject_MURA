<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- dao 연결 -->   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MURA :: 마이페이지 수정</title>
<style type="text/css">
*{
font-family:"bmh";
font-weight: bold;
}
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
width:90px;
height: 25px;
}
.btt3{
width : 100px;
height: 25px;
border-radius: 5px;
float: right;
}
.btt3:hover{
background-color: silver;
}
</style>

<script type="text/javascript" src="script.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<link rel="icon" type="image/x-icon" href="../images/mura_logo.png">
<link href="../css/style.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
</head>
<body>

<!-- 상단 로고 -->
	<div class="logo">
	  <a href="/MURA2/page/index.jsp"> 
	  <img src="../images/topLogo.jpg" width="1194" height="230" border="0" alt=""></a>
	</div>
	
	
	<p align="center">
		<img src="../images/mypage.jpg" width="30" height="30">
	MuRa : : My Page 
	</p>


<div>
<form action="modifyProc.mur" method="post" class="joinForm" name="modifyForm">
	<table class="ct" border="1" cellpadding="3" cellspacing="0">
		<tr>
			<td colspan="2">
			<img src="../images/toki.jpg" width="340" height="314" alt="">
			<br>
			<input type="button" name="내사진" class="btt3" value="내사진변경" onclick="">
			</td>
			
		</tr>
		
		<tr>
			<td class="dd" width="200" >성명</td>
			<td>
			${name_mem }
			<input type="hidden" class="btt2" name="id_mem" value="${id_mem }">
			<input type="hidden" class="btt2" name="name_mem" value="${name_mem }">
			
			</td>
		</tr>
		
		<tr>
			<td class="dd" width="200" >닉네임</td><td><input type="text" class="btt2" name="nn_mem" value="${nn_mem }"></td>
		</tr>
		
		<tr>
			<td class="dd" width="200">이메일</td><td><input type="text" class="btt2" name="email_mem" value="${email_mem }"></td>
		</tr>
		
		<tr>
			<td class="dd" width="200">H.P </td><td><input type="text" class="tel" name="tel_mem" maxlength="15" value="${tel_mem }"></td>
		</tr>
		
		<tr>
			<td class="dd" width="200">우편번호</td><td><input type="text" style="width: 273px; margin-right:12px; height: 30px;" name="zipcode_mem" value="${zipcode_mem }"><input type="button" class="btn2" value="찾기" onclick="zipCheck2()"></td>
			
		</tr>
		
		<tr>
			<td class="dd" width="200">주소</td><td><input type="text" class="btt2" name="zc1_mem" value="${zc1_mem }"></td>	
		</tr>
		
		<tr>
			<td class="dd" width="200">상세주소</td><td><input type="text" class="btt2" name="zc2_mem" value="${zc2_mem }"></td>
		</tr>
		
		<tr>
			<td class="dd" width="200">성별</td>
			<td>
			${gender_mem}
			<input type="hidden" class="btt2" name="gender_mem" value="${gender_mem }">
			</td>
		</tr>
		
		<tr>
			<td class="dd" width="200">비밀번호 변경</td><td><input type="password" class="btt2" name="pw_mem" value="${pw_mem }"></td>
		</tr>
		
		<tr>
			<td class="dd" width="200">비밀번호 확인</td><td><input type="password" class="btt2" name="repass_mem"></td>
		</tr>
	</table>
	<table class="ct">
	 	<tr>
	 		<td align="right"><button type="button" class="btt" name="저장하기" onclick="inputCheck2()">저장</button>
					<input type="button" class="btt" name="돌아가기" value="취소" onclick="window.location.href='http://localhost:9000/MURA2/page/member/myPage.mur'"></td>
	 	</tr>
	</table>
	</form>	
</div>

</body>
</html>
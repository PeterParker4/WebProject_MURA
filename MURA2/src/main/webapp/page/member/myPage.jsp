<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MURA :: 마이페이지</title>
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
  text-align:center;
  width: 25%;
  background-color: #a84781;
  border-radius: 10px;
  -webkit-transition: all 0.4s;
  -o-transition: all 0.4s;
  -moz-transition: all 0.4s;
  transition: all 0.4s;
  font-style: inherit;
  cursor: pointer;
}
.btt:hover {
  background-color: #403866;
}
b{
text-align: justify;
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
	<table class="ct" border="1" cellpadding="3" cellspacing="0">
		<tr>
			<td colspan="2">
			<img src="../images/toki.jpg" width="340" height="314" alt=""></td>
		</tr>
		
		<tr>
			<td class="dd" width="200" >성명</td><td>${memberInfo.name_mem }</td>
		</tr>
		
		<tr>
			<td class="dd" width="200" >닉네임</td><td>${memberInfo.nn_mem }</td>
		</tr>
		
		<tr>
			<td class="dd" width="200">이메일</td><td>${memberInfo.email_mem }</td>
		</tr>
		
		<tr>
			<td class="dd" width="200">H.P </td><td>${memberInfo.tel_mem }</td>
		</tr>
		
		<tr>
			<td class="dd" width="200">집주소</td><td>${memberInfo.zc1_mem } ${memberInfo.zc2_mem } </td>
		</tr>
		
		<tr>
			<td class="dd" width="200">성별</td><td>${memberInfo.gender_mem }</td>
		</tr>
		
	</table>
	
	<table class="ct">
	 	<tr>
	 		<td align="right"><input type="button" class="btt" name="수정하기" value="수정하기" 
	 		onclick="window.location.href='http://localhost:9000/MURA2/page/member/modifyForm.mur'">
					<input type="button" class="btt" name="회원탈퇴" value="회원탈퇴"
					onclick="window.location.href='http://localhost:9000/MURA2/page/member/deleteForm.mur'"></td>
	 	</tr>
	</table>
</div>	
<!-- table안닫은 정수현 머리 박겠습니다. -->



<hr>
	
<div align="center"><img src="../images/icons/list.jpg" width="35" height="35"><b>내가 작성한 게시물(전체 글 : ${count })</b></div>
	
	<table class="t1" border="1" cellpadding="0" cellspacing="0">
	<br><br>
	<tr bgcolor="${value_c }">
		<td align="center" width="250"><b>제목</b><a href=""></a></td>
		<td align="center" width="150"><b>작성일</b></td>
		<td align="center" width="50"><b>조회수</b></td>
	</tr>
	
	
<c:if test="${count > 0 }">
<c:forEach var="article" items="${articleList}">
  
  <tr height="30">
      
    <td width="350">
      <a href="/MURA2/page/recipe/recipeContent.mur?num=${article.idx_li}&pageNum=${currentPage}">
       ${article.wsubject_li}</a>
    </td>
    
    <td align="center" width="150">
    ${article.date_li}
    </td>
    
    <td align="center" width="50">
    ${article.readcount_li}
    </td>
    
  </tr>
  </c:forEach>

</c:if>
</table>
	
	<br><br>
<div align="center"><img src="../images/icons/like.jpg" width="50" height="50"><b>좋아요 누른 게시물</b></div>

	<table class="t1" border="1" cellpadding="0" cellspacing="0">
	<br><br>
	<tr height="30" bgcolor="${value_c }">
		<td align="center" width="250"><b>제목</b></td>
		<td align="center" width="100"><b>작성자</b></td>
		<td align="center" width="150"><b>작성일</b></td>
		<td align="center" width="50"><b>조회수</b></td>
	</tr>
	
	
	
	<c:if test="${count > 0 }">
<c:forEach var="article" items="${articleList}">
  
  <tr height="30">
    
    <td width="350">
      <a href="/MURA2/page/recipe/recipeContent.mur?num=${article.idx_li}&pageNum=${currentPage}">
      ${article.wsubject_li}</a>
    </td>
    
    <td align="center" width="110">
    ${article.nn_mem}
    </td>
    
    <td align="center" width="150">
    ${article.date_li}
    </td>
    
    <td align="center" width="50">
    ${article.readcount_li}
    </td>
    
  </tr>
  </c:forEach>
</c:if>
</table>

	<br><br>
</body>
</html>
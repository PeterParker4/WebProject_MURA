<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file = "view/color.jspf" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MURA :: 레시피 수정</title>
<style type="text/css">

.s1{
width: 100px;
height: 20px;
padding: 5px;
border: thin;
border-radius: 5px;
border-color: aqua;
background-color: #a84781;
color: white;
font-weight: bold;
text-align: center;
margin: 5px;
}

.s2{
height: 25px;
border: thin;
border-radius: 5px;
border-color: aqua;
background-color: #330033;
color: white;
font-weight: bold;
cursor: pointer;
}

.s2:hover{
background-color: orange;
color:black;
}

.tb{
width: 55%;
}

.sl{
width: 80px;
height: 30px;
border-radius: 4px;
color: black;
font-weight: bold;
}

.tx{
width: 100%;
height: 20px;
border-radius: 4px;
}

.txt{
border-radius: 4px;
border-color: graytext;
}

</style>
<script type="text/javascript" src="js/script.js"></script>
<script type="text/javascript" src="/MURA2/ckeditor/ckeditor.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

<link rel="icon" type="image/x-icon" href="../images/mura_logo.png">
<link rel="stylesheet" type="text/css" href="css/recipeStyle.css">
</head>

<body bgcolor = "#FFFFFF">
	<!--N 네비메뉴 -->
	<%@ include file="../nav.jsp" %>
	<br><br>

	<!-- 상단 로고 -->
	<div class="logo">
	  <a href="/MURA2/page/index.mur"> 
	  <img src="../images/mura_logo2.png" width="230" height="230" border="0" alt=""></a>
	</div>

<br><br>
<form action="/MURA2/page/recipe/recipeUpdateProc.mur?pageNum=${pageNum}" name="recipeWriteForm" 
method="post" onsubmit="return writeSave()" encType="multipart/form-data">

<input type="hidden" name="idx_li" value="${idx_li}">
<input type="hidden" name="un_mem" value="${memberInfo.un_mem}">

<table width="1000" border="1" cellpadding="0" cellspacing="0" align="center" bgcolor="${bodyback_c}">

<tr>
<td align="center" colspan="2" bgcolor="${value_c}">레시피 게시판</td>
</tr>

<tr>
   <td width="100" bgcolor="${value_c}" align="center">카테고리</td>
   <td align="center">
     <select name="category_li" style="width:500px">
       <option value="${article.category_li}">${article.category_li}</option>
       <option value="---">----------------</option>
       <option value="한식">한식</option>
       <option value="일식">일식</option>
       <option value="양식">양식</option>
       <option value="중식">중식</option>
       <option value="기타">기타</option>
       <option value="분식">분식</option>
       <option value="디저트">디저트</option>
     </select>
   </td>
</tr>

<tr>
   <td width="100" bgcolor="${value_c}" align="center">제목</td>
   <td width="300" align="center">
     <input type="text" size="100" maxlength="100" name="wsubject_li" value="${article.wsubject_li}">
   </td>
</tr>

<tr>
   <td width="100" bgcolor="${value_c}" align="center">재료입력<br>*쉼표(,)구분</td>
   <td width="300" align="center">
   <input type="text" size="100" maxlength="100" name="tag_li" value="${article.tag_li}">
   </td>
</tr>

<!-- 내용입력창(ck에디터 폼 적용) -->
<tr>
   <td width="100" bgcolor="${value_c}" align="center">내용</td>
   <td width="300" align="center">
   <textarea class="form-control" id="wcontent_li" name="wcontent_li">${article.wcontent_li}</textarea>
     <script type="text/javascript">
     CKEDITOR.replace('wcontent_li', {height: 600});
     </script>
     <!-- <textarea rows="50" cols="80%" name="wcontent_li"></textarea> -->
   </td>
</tr>

<tr>
  <td width="100" bgcolor="${value_c}" align="center">썸네일 이미지</td>
  <td>
    <input type="file" name="thumb_li" value="${thumb_li}"><br>
    *등록한 사진이 썸네일 이미지로 등록됩니다. (게시글 수정시 재업로드 해주세요.)
  </td>
</tr>

<tr>
  <td colspan="2" bgcolor="${value_c}" align="center">
  	<input type="submit" class="s2" value="수정하기">
  	<input type="reset" class="s2" value="돌아가기" onclick="javascript:history.go(-1)">
  	<input type="button" class="s2" value="목록" 
  	onClick="document.location.href='/MURA2/page/recipe/recipeList.mur?pageNum=${pageNum}'">
  </td>
</tr>
</table>
</form>
<br><br>

	<!--F 푸터메뉴 -->
    <%@ include file="../footer.jsp" %>

</body>
</html>
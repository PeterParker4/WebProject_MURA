<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file = "view/color.jspf" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MURA :: 레시피 작성</title>
<script type="text/javascript" src="js/script.js"></script>
<script type="text/javascript" src="/MURA2/ckeditor/ckeditor.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<link rel="icon" type="image/x-icon" href="../images/mura_logo.png">
<link rel="stylesheet" type="text/css" href="css/recipeStyle.css">
</head>

<body bgcolor = "#FFFFFF">
	<!--N 네비메뉴 -->
	<div>
		<nav>
		 	 <c:choose>
				<c:when test="${id_mem ne null && id_mem eq 'aaaa1111' }">
					<a href="/MURA2/page/member/logout.mur"> 회원관리 </a> |
				</c:when>
				
				<c:when test="${id_mem ne null}">
					<a href="/MURA2/page/member/logout.mur"> Logout </a> |
					<a href="/MURA2/page/member/myPage.mur"> MyPage </a>
				</c:when>
							
				<c:otherwise>
					<a href="/MURA2/page/member/signinForm.mur"> Sign In </a> |
					<a href="/MURA2/page/member/login.mur"> Login </a> |
					<a href="/MURA2/page/member/myPage.mur"> MyPage </a>
				</c:otherwise>
			</c:choose> 
		</nav>
	</div>
	<br><br>

	<!-- 상단 로고 -->
	<div class="logo">
	  <a href="/MURA2/page/index.mur"> 
	  <img src="../images/mura_logo2.png" width="230" height="230" border="0" alt=""></a>
	</div>

<br><br>
<form action="/MURA2/page/recipe/recipeWriteProc.mur" name="recipeWriteForm" 
method="post" onsubmit="return writeSave()" encType="multipart/form-data">

<input type="hidden" name="un_mem" value="${memberInfo.un_mem}">
<input type="hidden" name="nn_mem" value="${memberInfo.nn_mem}">

<table class="tb" align="center">

<tr>
<td align="center" colspan="2">
<img src="../images/recipe.jpg" width="90" height="90">
<img src="../images/icons/fr.jpg" width="160" height="90">
</td>

</tr>


<tr>
   <td class="s1" >카테고리</td>
   <td align="left">
     <select name="category_li" size="1" class="sl">
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
   <td class="s1">제목</td>
   <td width="300" align="left">
     <input type="text" size="100" class="tx" maxlength="100" name="wsubject_li">
   </td>
</tr>

<tr>
   <td class="s1">재료입력<br>*쉼표(,)구분</td>
   <td width="500" align="center">
<!--        <div class="content">
        <div>
            <input type="text" id="tag" size="20" placeholder="엔터 버튼 클릭시 태그 입력" />
        </div>
          <ul id="tag-list">
          </ul>
  	   </div> -->
   <input type="text" size="80" class="tx" maxlength="100" name="tag_li">
   </td>
</tr>

<!-- 내용입력창(ck에디터 폼 적용) -->
<tr>
   <td class="s1">내용</td>
   <td width="300" align="center">
   <textarea class="form-control" id="wcontent_li" name="wcontent_li" style="width: 100%;
    height: 600px;" ></textarea>
     <script type="text/javascript">
     CKEDITOR.replace('wcontent_li', {height: 600});
     </script>
     <!-- <textarea rows="50" cols="80%" name="wcontent_li"></textarea> -->
   </td>
</tr>

<tr>
  <td class="s1">썸네일 이미지</td>
  <td>
    <input type="file" name="thumb_li"><br>
    *등록한 사진이 썸네일 이미지로 등록됩니다.
  </td>
</tr>

</table>

<hr width="40%">

<table class="tb" align="center">

<tr>
  <td align="right" colspan="2">
  	<input type="submit" value="글쓰기" class="s2">
  	<input type="reset" value="다시작성" class="s2">
  	<input type="button" value="목록" class="s2" onClick="window.location='recipeList.mur'">
  </td>
</tr>
</table>
</form>
<br><br>

	<!--F 푸터메뉴 -->
    <%@ include file="../footer.jsp" %>

</body>
</html>
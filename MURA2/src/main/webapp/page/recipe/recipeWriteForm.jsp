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
<script type="module" src="js/tag_create.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

<link rel="icon" type="image/x-icon" href="../images/mura_logo.png">
<link rel="stylesheet" type="text/css" href="css/recipeStyle.css">
</head>

<body bgcolor = "#FFFFFF">
	<!--N 네비메뉴 -->
    <nav>
		<a href="/loginPage"> Sign In </a> |
		<a href="/loginPage"> Login </a> |
		<a href="/javascript/intro"> MyPage </a>
	</nav>
	<br><br>

	<!-- 상단 로고 -->
	<div class="logo">
	  <a href="/MURA2/page/index.jsp"> 
	  <img src="../images/topLogo.jpg" width="1194" height="230" border="0" alt=""></a>
	</div>

<br><br>
<form action="/MURA2/page/recipe/recipeWriteProc.mur" name="recipeWriteForm" 
method="post" onsubmit="return writeSave()" encType="multipart/form-data">

<input type="hidden" name="idx_li" value="${idx_li}">
<input type="hidden" name="nn_mem" value="${nn_mem}">

<table width="1000" border="1" cellpadding="0" cellspacing="0" align="center" bgcolor="${bodyback_c}">

<tr>
<td align="center" colspan="2" bgcolor="${value_c}">레시피 게시판</td>
</tr>

<tr>
   <td width="100" bgcolor="${value_c}" align="center">카테고리</td>
   <td align="center">
     <select name="category_li" style="width:500px">
       <option value="한식">한식</option>
       <option value="일식">일식</option>
       <option value="양식">양식</option>
       <option value="중식">중식</option>
     </select>
   </td>
</tr>

<tr>
   <td width="100" bgcolor="${value_c}" align="center">제목</td>
   <td width="300" align="center">
     <input type="text" size="100" maxlength="100" name="wsubject_li">
   </td>
</tr>

<tr>
   <td width="100" bgcolor="${value_c}" align="center">재료입력<br>*쉼표(,)구분</td>
   <td width="300" align="center">
<!--        <div class="content">
        <div>
            <input type="text" id="tag" size="20" placeholder="엔터 버튼 클릭시 태그 입력" />
        </div>

          <ul id="tag-list">
          </ul>
  	   </div> -->
   <input type="text" size="100" maxlength="100" name="tag_li">
   </td>
</tr>

<!-- 내용입력창(ck에디터 폼 적용) -->
<tr>
   <td width="100" bgcolor="${value_c}" align="center">내용</td>
   <td width="300" align="center">
   <textarea class="form-control" id="wcontent_li" name="wcontent_li"></textarea>
     <script type="text/javascript">
     CKEDITOR.replace('wcontent_li', {height: 600});
     </script>
     <!-- <textarea rows="50" cols="80%" name="wcontent_li"></textarea> -->
   </td>
</tr>

<tr>
  <td width="100" bgcolor="${value_c}" align="center">썸네일 이미지</td>
  <td>
    <input type="file" name="thumb_li"><br>
    *등록한 사진이 썸네일 이미지로 등록됩니다.
  </td>
</tr>

<tr>
  <td colspan="2" bgcolor="${value_c}" align="center">
  	<input type="submit" value="글쓰기">
  	<input type="reset" value="다시작성">
  	<input type="button" value="목록" onClick="window.location='recipeList.mur'">
  </td>
</tr>
</table>
</form>
<br><br>

	<!--F 푸터메뉴 -->
    <footer class="footer">
		<hr style="width:75%;height:6px;border:none;background-color:#a84781;">
		<div class="container" style="padding-top:7px;" align="center">
			<div class="row">
        		<div class="col-md-4 media"><div class="pull-left"><i class="fa fa-info-circle fa-2x fa-fw"></i></div>
					<div class="media-body" style="float:left;width:33%">
					<h3>(주)MURA</h3>
					<p class="text-muted">대표이사: 성세연<br>서울특별시 영등포구<br>010-1234-1234<br>jinsu9337@naver.com
					</p>
					</div>
      			</div>
        		<div class="col-md-4 media"><div class="pull-left"><i class="fa fa-file-o fa-2x fa-fw"></i></div>
					<div class="media-body" style="float:left;width:33%">
					<h3>Site Info</h3>
					<p class="text-muted">"MURA" Designed by <a href="http://readiz.com" target="_blank">YJS</a><br/>with <a href="http://yongzz.com" target="_blank">yongzz</a>, <a href="http://wincomi.com" target="_blank">wincomi</a>, <a href="http://markquery.com" target="_blank">Ungki. H</a><br/><a href="http://blog.readiz.com/22">Further Information</a>
					</p>
					</div>
				</div>
        		<div class="col-md-4 media"><div class="pull-left"><i class="fa fa-link fa-2x fa-fw"></i></div>
					<div class="media-body" style="float:left;width:33%"><h3>Other Links</h3>
						<p class="text-muted">
							<a href="/MURA2/page/index.jsp" title="홈">Top</a> | <a href="/tag" title="태그">태그</a>
						</p><br><br>
					</div>
				</div>
			</div>
			<br><br>
			<div class="row">
				<div class="col-md-12" >
					<hr style="width:75%;height:6px;border:none;background-color:#a84781;"><br>
					<p class="text-muted">Copyright ⓒ 2021-2022 MURA All rights reserved.</p>
				</div>
			</div>
		</div>
    </footer>

</body>
</html>
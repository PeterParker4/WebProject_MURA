<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file = "view/color.jspf" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MURA :: 레시피 작성</title>
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

<input type="hidden" name="un_mem" value="${memberInfo.un_mem}">
<input type="hidden" name="pw_mem" value="${memberInfo.pw_mem}">
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
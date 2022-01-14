<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>레시피 상세보기</title>
<style type="text/css">


.s2{
height: 35px;
width: 60px;
border: thin;
border-radius: 5px;
border-color: aqua;
background-color: #330033;
color: white;
font-weight: bold;
cursor: pointer;
float: right;
margin: 5px;
font-size: 17px;
font-weight: lighter;
}

.s2:hover{
background-color: orange;
color:black;
}

.read{
float: right;
padding: 3px;
text-align: right;
font-weight: bold;
}

.read2{
float: left;
padding-top: 3px;
text-align: left;
font-weight: bold;
}

.read3{
float: left;
padding:0px 20px 0px 20px;
text-align: left;
font-size: 20px;
font-weight:bold;
color: #fff;
background-color: #a84781;
}

.div1{
width: 55%;

}

.title{
font-size: 36px;
font-weight: bolder;
letter-spacing: 2px;
}

.je{
color: #a84781;
font-weight: bold;
padding-top: 4px;
}
</style>
<link rel="icon" type="image/x-icon" href="images/mura_logo.png">
<link href="css/recipeStyle.css" rel="stylesheet" type="text/css">

</head>

<body bgcolor = "ffffff">

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

<div style="display: flex; justify-content: center; align-items: center;">
<div align="center" class="div1"><br><br>
<form>

<hr size="4px;" color="#a84781">

<b class="title">${article.wsubject_li}</b>
<hr size="4px;" color="#a84781">
<div style="background-color: #DDDDDD; height: 30px; width: 100%;">
<div class="read2">&nbsp; <b>${article.nn_mem}</b> | 글번호 ${article.idx_li} | 조회수 ${article.readcount_li}</div> <div class="read">작성일 ${article.date_li} &nbsp;</div>
   </div>

<div class="read3"> 재료 </div>
<div class="je">${article.tag_li}</div>
<hr>
<br><br>

	    <img alt="" src="upload/${article.thumb_li}" id="thumbnailImage" width="80%" height="80%"><br>
	    ${article.wcontent_li}<br>
    
<br><br>

<table>
<tr align="center">
<td align="center">추천수</td>
</tr>

 <tr>
 <td>
 <input type=button value="좋아요" onclick="document.location.href='/MURA2/page/recipe/recipeRecommed.mur'">
 </td>
 </tr>
</table>    
    
<hr>

      <c:if test="${memberInfo.un_mem eq article.un_mem}">
      <a href="/MURA2/page/recipe/recipeDeleteProc.mur?num=${num}&pageNum=${pageNum}&un_mem=${article.un_mem}">
      <input type="button" class="s2" value="글삭제" onclick="return confirm('정말로 삭제하시겠습니까?')">
      </a>
      &nbsp;&nbsp;
      
      <input type="button" class="s2" value="글수정" 
      onclick="document.location.href='/MURA2/page/recipe/recipeUpdateForm.mur?num=${num}&pageNum=${pageNum}'">
      &nbsp;&nbsp;
      </c:if>
      
      <input type="button" class="s2" value="글목록" 
      onclick="document.location.href='/MURA2/page/recipe/recipeList.mur?pageNum=${pageNum}'">
    
</form>
</div>
</div>
<br>
<br>

<!--F 푸터메뉴 -->
<div>
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

</div>
</body>
</html>
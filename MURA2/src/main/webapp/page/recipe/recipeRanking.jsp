<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>레시피 랭킹 게시판</title>
<link href="css/recipeStyle.css" rel="stylesheet" type="text/css">
<link rel="icon" type="image/x-icon" href="../images/mura_logo.png">
</head>
<body>
	<!--N 네비메뉴 -->
	<%@ include file="../nav.jsp" %>
	<br><br>

	<!-- 상단 로고 -->
	<div class="logo">
	  <a href="/MURA2/page/index.mur"> 
	  <img src="../images/mura_logo2.png" width="230" height="230" border="0" alt=""></a>
	</div>
	
	<!-- 상단 메뉴바 -->
	<%@ include file="../menubar.jsp" %>
	<br>
	<hr style="width:100%;height:3px;border:none;background-color:#a84781;">
	<br><br>
	
	<!-- 카테고리 이동 -->
	<div class="category">
	<table  width="1000" border="0" cellpadding="0" cellspacing="0">
	  <tr>
	    <td>
	    <a href="/MURA2/page/recipe/recipeList.mur?find=category_li&find_box=한식">
	      <img alt="" src="../images/korea.png" width="100" height="100"></a>
	    </td>

	    <td>
   	    <a href="/MURA2/page/recipe/recipeList.mur?find=category_li&find_box=일식">
	      <img alt="" src="../images/japan.png" width="100" height="100"></a>
	    </td>

	    <td>
   	    <a href="/MURA2/page/recipe/recipeList.mur?find=category_li&find_box=양식">
	      <img alt="" src="../images/western.png" width="100" height="100"></a>
	    </td>

	    <td>
   	    <a href="/MURA2/page/recipe/recipeList.mur?find=category_li&find_box=중식">
	      <img alt="" src="../images/china.png" width="100" height="100"></a>
	    </td>

	    <td>
   	    <a href="/MURA2/page/recipe/recipeList.mur?find=category_li&find_box=분식">
	      <img alt="" src="../images/bunsik.png" width="100" height="100"></a>
	    </td>

	    <td>
   	    <a href="/MURA2/page/recipe/recipeList.mur?find=category_li&find_box=디저트">
	      <img alt="" src="../images/desert.png" width="100" height="100"></a>
	    </td>
	    
	  </tr>
	</table>
	</div>
	<br><br>
	
	<div align="center">
	    <img alt="" src="images/ranking.png" width="200px" height="200">
	</div>
<div align="center">
	<table style="display: inline-flex; border-collapse: collapse; table-layout: fixed;	position: relative; 
	 padding: 5px;" border="0">
		<tr height="90" style="background-color: #920ADD">
			<td width="230" style="color: #fff; font-size: 27px;">조회 RANKING</td>
			<td width="50" style="color: #fff; font-size: 14px; vertical-align: bottom; padding-bottom: 7px;" >조회수</td>
		</tr>
		<c:forEach var="article" items="${articleList}" end="9">
		<tr height="30">
			<td align="left" width="230" style="border-bottom: 1px solid black;">
			<div style="width:200px; text-overflow:ellipsis; overflow:hidden; white-space:nowrap;" title="잉 기모링">
			&nbsp;&nbsp;
			<a href="/MURA2/page/recipe/recipeContent.mur?num=${article.idx_li}&pageNum=1&thumb_li=${article.thumb_li}">${article.wsubject_li}</a>
			<img alt="" src="recipe/images/hot.gif" border="0" height="20"></div>
			</td>
			<td align="center" width="50">${article.readcount_li}</td>
		</tr>
		</c:forEach>
	</table>
	
	<table style="display: inline-flex; border-collapse: collapse; table-layout: fixed;	position: relative; 
	 padding: 5px;" border="0">
		<tr height="90" style="background-color: orange;">
			<td width="230" style="color: #fff; font-size: 27px;">추천 RANKING</td>
			<td width="50" style="color: #fff; font-size: 14px; vertical-align: bottom; padding-bottom: 7px;">추천수</td>
		</tr>
		<c:forEach var="article2" items="${articleList2}" end="9">
		<tr height="30">
			<td align="left" width="230" style="border-bottom: 1px solid black;">
			<div style="width:200px; text-overflow:ellipsis; overflow:hidden; white-space:nowrap;" title="잉 기모링">
			&nbsp;&nbsp;
			<a href="/MURA2/page/recipe/recipeContent.mur?num=${article2.idx_li}&pageNum=1&thumb_li=${article2.thumb_li}">${article2.wsubject_li}</a>
			<img alt="" src="recipe/images/hot.gif" border="0" height="20"></div>
			</td>
			<td align="center" width="50">${article2.recommend_cnt}</td>
		</tr>
		</c:forEach>
	</table>

	<table style="display: inline-flex; border-collapse: collapse; table-layout: fixed;	position: relative; 
	 padding: 5px; border="0">
		<tr height="90" style="background-color: #ff0000;">
			<td width="230" style="color: #fff; font-size: 27px;">댓글 RANKING</td>
			<td width="50" style="color: #fff; font-size: 14px; vertical-align: bottom; padding-bottom: 7px;">댓글수</td>
		</tr>
		<c:forEach var="article3" items="${articleList3}" end="9">
		<tr height="30">
			<td align="left" width="230" style="border-bottom: 1px solid black;">
			<div style="width:200px; text-overflow:ellipsis; overflow:hidden; white-space:nowrap;" title="잉 기모링">
			&nbsp;&nbsp;
			<a href="/MURA2/page/recipe/recipeContent.mur?num=${article3.idx_li}&pageNum=1&thumb_li=${article3.thumb_li}">${article3.wsubject_li}</a>
			<img alt="" src="recipe/images/hot.gif" border="0" height="20"></div>
			</td>
			<td align="center" width="50">${article3.reply_cnt}</td>
		</tr>
		</c:forEach>
	</table>
</div>	
	<br><br>

<%@ include file="../footer.jsp" %>

</body>
</html>
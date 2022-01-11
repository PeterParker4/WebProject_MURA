<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="view/color.jspf" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>레시피 상세보기</title>
<link href="css/recipeStyle.css" rel="stylesheet" type="text/css">
</head>

<body bgcolor = "ffffff">
<div align="center"><b>레시피 상세보기</b><br><br>
<form>
<table width="1000" border="1" cellpadding="0" cellspacing="0" align="center" bgcolor = "#fff">

  <tr height="30">
    <td align="center" width="125" bgcolor="${value_c}">글번호</td>
    <td align="center" width="125">${article.idx_li}</td>
    
    <td align="center" width="125" bgcolor="${value_c}">조회수</td>
    <td align="center" width="125">${article.readcount_li}</td>
  </tr>

  <tr height="30">
    <td align="center" width="125" bgcolor="${value_c}">작성자</td>
    <td align="center" width="125">${article.nn_mem}</td>

    <td align="center" width="125" bgcolor="${value_c}">작성일</td>
    <td align="center" width="125">${article.date_li}</td>
  </tr>

  <tr height="30">
    <td align="center" width="125" bgcolor="${value_c}">재료</td>
    <td align="center" width="375" colspan="3">
    <pre>${article.tag_li}</pre></td>
  </tr>

  <tr height="30">
    <td align="center" width="125" bgcolor="${value_c}">글제목</td>
    <td align="center" width="375" colspan="3">
    <pre><b>${article.wsubject_li}</b></pre></td>
  </tr>

  <tr>
    <td align="left" width="375" colspan="4">
    	<br>
	    <img alt="" src="upload/${article.thumb_li}" id="thumbnailImage" width="80%" height="80%"><br>
	    ${article.wcontent_li}<br>
    </td>
  </tr>

  <tr height="30">
    <td colspan="4" bgcolor="${value_c}" align="right">
      <input type="button" value="글수정" 
      onclick="document.location.href='/MURA2/page/recipe/recipeUpdateForm.mur?num=${num}&pageNum=${pageNum}'">
      &nbsp;&nbsp;&nbsp;&nbsp;
      
      <input type="button" value="글삭제" 
      onclick="document.location.href='/MURA2/page/recipe/recipeDeleteForm.mur?num=${num}&pageNum=${pageNum}'">
      &nbsp;&nbsp;&nbsp;&nbsp;
      
      <input type="button" value="글목록" 
      onclick="document.location.href='/MURA2/page/recipe/recipeList.mur?pageNum=${pageNum}'">
    </td>
  </tr>
</table>
</form>
</div>
</body>
</html>

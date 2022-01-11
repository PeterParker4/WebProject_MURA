<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file = "view/color.jspf" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>레시피 작성</title>
<script type="text/javascript" src="script.js"></script>
<link href="style.css" rel="stylesheet" type="text/css">
</head>

<body bgcolor = "#FFFFF">
<br><br>
<form action="/JspProject/board/writePro.do" name="recipeWriteForm" method="post" onsubmit="return writeSave()">
<input type="hidden" name="num" value="${num}">
<input type="hidden" name="ref" value="${ref}">
<input type="hidden" name="step" value="${step}">
<input type="hidden" name="depth" value="${depth}">

<table width="540" border="1" cellpadding="0" cellspacing="0" align="center" bgcolor="${bodyback_c}">

<tr>
<td align="center" colspan="2" bgcolor="${value_c}">레시피 게시판</td>
</tr>

<tr>
   <td width="100" bgcolor="${value_c}" align="center">카테고리</td>
   <td>
     <select name="category">
       <option value="korea">한식</option>
       <option value="japan">일식</option>
       <option value="western">양식</option>
       <option value="china">중식</option>
     </select>
   </td>
</tr>

<tr>
   <td width="100" bgcolor="${value_c}" align="center">제목</td>
   <td width="330">
     <c:if test="${num == 0}">
       <input type="text" size="50" maxlength="50" name="subject">
     </c:if>

     <c:if test="${num != 0}">
       <input type="text" size="50" maxlength="50" name="subject" value="[답변]">
     </c:if>
   </td>
</tr>

<tr>
   <td width="100" bgcolor="${value_c}" align="center">재료</td>
   <td width="330">
     <input type="text" size="50" maxlength="50" name="writer">
   </td>
</tr>

<tr>
  <td width="100" bgcolor="${value_c}" align="center">썸네일 이미지</td>
  <td>
    <input type="file" name="fileName1">
  </td>
</tr>

<tr>
  <td width="100" bgcolor="${value_c}" align="center">사진첨부</td>
  <td>
    <input type="file" name="fileName2">
  </td>
</tr>

<tr>
   <td width="100" bgcolor="${value_c}" align="center">내용</td>
   <td width="330">
     <textarea rows="50" cols="50" name="content"></textarea>
   </td>
</tr>

<tr>
  <td colspan="2" bgcolor="${value_c}" align="center">
  	<input type="submit" value="글쓰기">
  	<input type="reset" value="다시작성">
  	<input type="button" value="목록" onClick="window.location='/JspProject/board/list.do'">
  </td>
</tr>

</table>
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>요청 / Q&A 게시판 작성</title>
<script type="text/javascript" src="script.js"></script>
</head>

<body>

<div align="center"><b>글쓰기</b></div><br><br>

<form action="/MURA2/userboard/writePro.mur" name="writeForm" method="post"
onsubmit="return writeSave()">
<input type="hidden" name="mem" value="${wnum_ut }">
<input type="hidden" name="idx" value="${idx_ut }">


<table width="500" border="1" cellpadding="0" cellspacing="0"
align="center">

<tr>
	<td width="70" align="center">게시판</td>
	<td>
	<input type="radio" name="board" value="user">요청게시판
	<input type="radio" name="board" value="Q&A">Q&A게시판
	</td>
</tr>


<tr>
	<td width="120" align="center">제목</td>
	<td width="380">
		<input type="text" size="50" maxlength="50" name="wsubject_ut">
	</td>
</tr>

<tr>
	<td width="120" align="center">내용</td>
	<td width="380">
		<textarea rows="13" cols="50" name="wcontent_ut" style="overflow: auto"></textarea>
	</td>
</tr>




<tr>
	<td colspan="2" align="right"> 
		<input type="submit" value="작성하기">
		<input type="reset" value="취소">
		<input type="button" value="목록" onClick="window.location='/MURA2/userboard/list.mur'">
	</td>
</tr>

</table>
</form>
</body>
</html>
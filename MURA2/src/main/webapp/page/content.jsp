<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 상세 보기</title>

<style type="text/css">
.blank
{
width : 100px;
height : 20px;
border: thin;
border-color: black;
padding : 6px;
margin: 5px;
	
}
.dat{
font-size: 25px;
text-align: center;
width: 80px;
height: 30px;
background-color: #fff;
border: medium;
border-color: black;
border-style: solid;
right: 310px;
position: relative;
}
</style>

<link href="pjmstyle.css" rel="stylesheet" type="text/css">
</head>



<body bgcolor="${bodyback_c }">
<div align="center"> <b>글 상세 보기</b> <br><br>
<form>

<table width="700" border="1" cellpadding="3" cellspacing="3" align="center"
bgcolor="${bodyback_c }">


<tr height="30">
<td align="center" width="80" bgcolor="${value_c }">글제목</td>
<td align="center" width="460" colspan="4">
<pre>${article.wsubject_ut }</pre></td>
<td align="center" width="80" bgcolor="${value_c }">작성일</td>
<td align="center" width="80">${article.date_ut }</td>
</tr>


<tr height="30">
<td align="center" width="80" bgcolor="${value_c }">조회수</td>
<td align="center" width="80">${article.readcount_ut }</td>
<td class="blank" align="center" width="460" colspan="3"></td>
<td align="center" width="80" bgcolor="${value_c }">작성자</td>
<td align="center" width="80">${article.nn_mem }</td>

</tr>



<tr height="30">
<td align="center" width="80" bgcolor="${value_c }">글내용</td>
<td class="blank" colspan="6">
</tr>

<tr>
<td width="700" height="500" colspan="7" >
<pre>${article.wcontent_ut }</pre></td>
</tr>
</table>


<div class="dat">
  댓글 
</div>

<div class="dat">
  댓글 입력창
</div>

<div class="dat">
  등록
</div>

<div class="dat">
  댓글보기
</div>



<tr height="30">
<td colspan="7" bgcolor="${value_c }" align="right">
<input type="button" value="글수정"
onclick="document.location.href='/JspProject/pjmboard/pjmupdateForm.do?idx_ut=${article.idx_ut }&pageNum=${pageNum }'">
&nbsp;&nbsp;&nbsp;&nbsp;

<input type="button" value="글삭제"
onclick="document.location.href='/JspProject/pjmboard/pjmdeleteForm.do?idx_ut=${article.idx_ut }&pageNum=${pageNum }'">
&nbsp;&nbsp;&nbsp;&nbsp;

<input type="button" value="글목록"
onclick="document.location.href='/JspProject/board/list.do?pageNum=${pageNum }'">


</td>
</tr>




</form>
</div>
</body>
</html>
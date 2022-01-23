<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="reply.model.*" %>
<%@ page import="java.util.List" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MURA :: 요청 게시판 글 보기</title>
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

<link rel="icon" type="image/x-icon" href="../images/mura_logo.png">
<link href="../page/css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
function check() {
	if(document.replyWriteForm.content_reply.value==""){
		alert("내용을 입력해 주세요");
		return false;
	}
  }
</script>
</head>
<body bgcolor="${bodyback_c }">

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
	  <img src="../page/images/topLogo.jpg" width="1194" height="230" border="0" alt=""></a>
	</div>


<!--  <body bgcolor="${bodyback_c }">
<div align="center"> <b>글 상세 보기</b> <br><br>  -->


<form>

<table width="700" border="1" cellpadding="3" cellspacing="3" align="center"
bgcolor="${bodyback_c }">


<tr height="30">
<td align="center" width="80" bgcolor="${value_c }">글제목</td>
<td align="center" width="460" colspan="4">
<pre>${userArticle.wsubject_ut }</pre></td>
<td align="center" width="80" bgcolor="${value_c }">작성일</td>
<td align="center" width="80">${userArticle.date_ut }</td>
</tr>


<tr height="30">
<td align="center" width="80" bgcolor="${value_c }">조회수</td>
<td align="center" width="80">${userArticle.readcount_ut }</td>
<td class="blank" align="center" width="460" colspan="3"></td>
<td align="center" width="80" bgcolor="${value_c }">작성자</td>
<td align="center" width="80">${userArticle.nn_mem }</td>
</tr>



<tr height="30">
<td align="center" width="80" bgcolor="${value_c }">글내용</td>
<td class="blank" colspan="6">
</tr>

<tr>
<td width="700" height="500" colspan="7" >
<pre>${userArticle.wcontent_ut }</pre></td>
</tr>
</table>

<br><br>


<tr height="30">
<td colspan="7" bgcolor="${value_c }" align="right">

<c:if test="${id_mem != null}">
<c:if test="${un_mem eq userArticle.un_mem}">
<input type="button" value="글수정"
onclick="document.location.href='/MURA2/userboard/userUpdateForm.mur?idx_ut=${userArticle.idx_ut }&pageNum=${pageNum }'">
&nbsp;&nbsp;

<a onclick="return confirm('정말로 삭제하시겠습니까?')"
href="/MURA2/userboard/userDeletePro.mur?idx_ut=${userArticle.idx_ut }&pageNum=${pageNum}">
<input type="button" value="글삭제"></a>
&nbsp;&nbsp;
</c:if>
</c:if>

<input type="button" value="글목록"
onclick="document.location.href='/MURA2/userboard/boardList.mur?pageNum=${pageNum }'">
</td>
</tr>
</form>
<br><br><br><br>


<table border="1" width="700" align="center">

<tr>
<td align="center" width="100">작성자</td>
<td align="center" width="500">댓글 내용</td>
<td align="center" width="100">작성일자</td>
</tr>
<c:if test="${userArticle.replycnt_ut == 0}">
<tr align="center" >
	    <td colspan="3">댓글이 없습니다.</td>
</tr>
</c:if>

<c:forEach var="reply" items="${replyList }">

<c:if test="${userArticle.replycnt_ut > 0 }">
<tr>
<td>${reply.nn_reply }</td>
<td>${reply.content_reply }</td>
<td>${reply.date_reply }</td>
</tr>
</c:if>

</c:forEach>
</table>


<br><br><br>
<c:if test="${id_mem != null }">
<form action="userReplyPro.jsp" method="post" name="replyWriteForm"
onsubmit="return check()">
<table>
<tr><td>${nn_mem }</td>
<td><textarea rows="3" cols="" placeholder="댓글을 입력하세요." name="content_reply" style="width: 100%"></textarea>
<input type="hidden" value="${userArticle.idx_ut }" name="board_reply">
<input type="hidden" value="${pageNum }" name="pageNum">
</td></tr>

<tr><td colspan="2" align="right"><input type="submit" value="댓글 작성"></td></tr>

</table>

<br><br><br>
</form>
</c:if>
</body>
</html>
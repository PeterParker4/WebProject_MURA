<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유저요청 / Q&A 게시판</title>


<script type="text/javascript">
function frm_sub(i) {
	i_frm.action="/MURA2/userboard/boardList.mur?pageNum="+i;
	i_frm.submit();
}
</script>

</head>
<body>

<div align="center"><b>유저요청 / Q&A 게시판</b>
<hr>
	
	<h1>요청 게시판</h1>
	
	<div align="center"><b>글목록(전체 글:${userCount} )</b>
	
	<c:if test="${userCount == 0 }">
	<table width="700" border="1" cellpadding="0" cellspacing="0">
	  <tr align="center">
	    <td>게시판에 저장된 글이 없습니다.</td>
	  </tr>
	</table>
	</c:if>
	
	<c:if test="${userCount > 0 }">
	<table width="700" border="1" cellpadding="0" cellspacing="0" align="center">
	
		<tr height="30">
		  <td align="center" width="100">글번호</td>			
		  <td align="center" width="300">제목</td>
		  <td align="center" width="100">작성자</td>
		  <td align="center" width="150">작성일</td>
		  <td align="center" width="50">조회수</td>
		</tr>
	
	<c:forEach var="userBoardArticle" items="${userBoardArticleList }">
	
	<tr height="30">
		<td align="center" width="100"><c:out value="${number }"/></td>
		<c:set var="number" value="${number - 1 }"> </c:set>
	
		<td width="300">	
		<a href="/MURA2/userboard/content.mur?num=${userBoardArticle.wnum_ut}&pageNum=${currentPage}">
		${userBoardArticle.wsubject_ut}</a>
		<c:if test="${userBoardArticle.readcount_ut >= 20 }">
			<img alt="" src="images/hot.gif" border="0" height="16">
			</c:if>
		</td>	
	
		<td align="center" width="100">
		${userBoardArticle.nn_mem }
		</td>
		<td align="center" width="150">
		${userBoardArticle.date_ut }
		</td>		
		<td align="center" width="50">
		${userBoardArticle.readcount_ut }
		</td>
		
	</tr>
	</c:forEach>
	</table>
	</c:if>	
	
	<c:if test="${userCount > 0 }">
	 <c:set var="imsi" value="${userCount % pageSize == 0 ? 0 : 1 }"/>
	 <c:set var="pageCount" value="${userCount / pageSize + imsi }"/>
	 <c:set var="pageBlock" value="${3}"/>
	 <fmt:parseNumber var="result" value="${(currentPage - 1) / pageBlock }" integerOnly="true"/>
	 
	 <c:set var="startPage" value="${result * pageBlock + 1 }"/>
	 <c:set var="endPage" value="${startPage + pageBlock - 1 }"/>
	 
	 <c:if test="${endPage > pageCount }">
	 	<c:set var="endPage" value="${pageCount }"/>
	 </c:if>
	 
	 <c:if test="${startPage > pageBlock }">
	 	<a href="/MURA2/userboard/boardList.mur?pageNum=${startPage - pageBlock }" onclick="frm_sub(${startPage - pageBlock})">[이전]</a>
	 </c:if>
	 
	 <c:forEach var="i" begin="${startPage }" end="${endPage }">
	 	<a href="/MURA2/userboard/boardList.mur?pageNum=${i}" onclick="frm_sub(${i})">[${i}]</a>
	 </c:forEach>
	 
	 <c:if test="${endPage < pageCount }">
		<a href="/MURA2/userboard/boardList.mur?pageNum=${startPage + pageBlock }" onclick="frm_sub(${startPage + pageBlock})">[다음]</a> 
	 </c:if>
	</c:if>
	<br><br>
	
<tr>	
	<td colspan="2" align="right">
		<input type="button" value="작성하기" onclick="window.location='/MURA2/userboard/writeForm.mur'">
		<input type="reset" value="취소">
	</td>
</tr>
	
</div>
</body>
</html>
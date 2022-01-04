<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유저요청 / Q&A 게시판</title>
<style type="text/css">

ul.tabs{
	margin: 0px;
	padding: 0px;
	list-style: none;
}

ul.tabs li{
  display: inline-block;
	background: #898989;
	color: white;
	padding: 10px 15px;
	cursor: pointer;
}

ul.tabs li.current{
	background: #e0e0e0;
	color: #222;
}

.tab-content{
  display: none;
	background: #e0e0e0;
	padding: 12px;
}

.tab-content.current{
	display: inherit;
}

</style>

<script type="text/javascript">

$(document).ready(function(){
	
	$('ul.tabs li').click(function(){
		var tab_id = $(this).attr('data-tab');

		$('ul.tabs li').removeClass('current');
		$('.tab-content').removeClass('current');

		$(this).addClass('current');
		$("#"+tab_id).addClass('current');
	})

});

function frm_sub(i) {
	i_frm.action="/MURA2/userboard/list.mur?pageNum="+i;
	i_frm.submit();
}



</script>



</head>
<body>

<div align="center"><b>유저요청 / Q&A 게시판</b>
<hr>
	<div class="container">

	<ul class="tabs">
		<li class="tab-link current" data-tab="tab-1">요청</li>
		<li class="tab-link" data-tab="tab-2">Q&A</li>
	</ul>
	<div id="tab-1" class="tab-content current">
	<h1>요청 게시판</h1>
	
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
		  <td align="center" width="150">작성자</td>
		  <td align="center" width="150">작성일</td>
		</tr>
	
	<c:forEach var="userArticle" items="${userArticleList }">
	
	<tr height="30">
		<td align="center" width="100"><c:out value="${number }"/></td>
		<c:set var="number" value="${number - 1 }"> </c:set>
	
		<td width="300">	
		<a href="/MURA2/userboard/content.mur?num=${userArticle.wnum_ut}&pageNum=${currentPage}">
		${userArticle.wsubject_ut}</a>
		</td>	
	
		<td align="center" width="150">
		${userArticle.nn_mem }
		</td>
		<td align="center" width="150">
		${userArticle.date_ut }
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
	 	<a href="/MURA2/userboard/list.mur?pageNum=${startPage - pageBlock }" onclick="frm_sub(${startPage - pageBlock})">[이전]</a>
	 </c:if>
	 
	 <c:forEach var="i" begin="${startPage }" end="${endPage }">
	 	<a href="/MURA2/userboard/list.mur?pageNum=${i}" onclick="frm_sub(${i})">[${i}]</a>
	 </c:forEach>
	 
	 <c:if test="${endPage < pageCount }">
		<a href="/MURA2/userboard/list.mur?pageNum=${startPage + pageBlock }" onclick="frm_sub(${startPage + pageBlock})">[다음]</a> 
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
	
	
	<div id="tab-2" class="tab-content">
	<h1>Q&A 게시판</h1>
	
	<c:if test="${qaCount == 0 }">
	<table width="700" border="1" cellpadding="0" cellspacing="0">
	  <tr align="center">
	    <td>게시판에 저장된 글이 없습니다.</td>
	  </tr>
	</table>
	</c:if>
	
	<c:if test="${qaCount > 0 }">
	<table width="700" border="1" cellpadding="0" cellspacing="0" align="center">
	
		<tr height="30">
		  <td align="center" width="100">글번호</td>			
		  <td align="center" width="300">제목</td>		
		  <td align="center" width="150">작성자</td>		
		  <td align="center" width="150">작성일</td>		
		</tr>
	
	<c:forEach var="qaArticle" items="${qaArticleList }">
	
	<tr height="30">
		<td align="center" width="100"><c:out value="${number }"/></td>
		<c:set var="number" value="${number - 1 }"> </c:set>
	
		<td width="300">
		<a href="/MURA2/userboard/content.mur?num=${qaArticle.wnum_qt}&pageNum=${currentPage}">
		${qaArticle.wsubject_qt}</a>
		</td>	
	
		<td align="center" width="150">
		${qaArticle.nn_mem }
		</td>
		<td align="center" width="150">
		${qaArticle.date_qt }
		</td>
	</tr>
	</c:forEach>
	</table>
	</c:if>	
	
	<c:if test="${qaCount > 0 }">
	 <c:set var="imsi" value="${qaCount % pageSize == 0 ? 0 : 1 }"/>
	 <c:set var="pageCount" value="${qaCount / pageSize + imsi }"/>
	 <c:set var="pageBlock" value="${3}"/>
	 <fmt:parseNumber var="result" value="${(currentPage - 1) / pageBlock }" integerOnly="true"/>
	 
	 <c:set var="startPage" value="${result * pageBlock + 1 }"/>
	 <c:set var="endPage" value="${startPage + pageBlock - 1 }"/>
	 
	 <c:if test="${endPage > pageCount }">
	 	<c:set var="endPage" value="${pageCount }"/>
	 </c:if>
	 
	 <c:if test="${startPage > pageBlock }">
	 	<a href="/MURA2/userboard/list.mur?pageNum=${startPage - pageBlock }" onclick="frm_sub(${startPage - pageBlock})">[이전]</a>
	 </c:if>
	 
	 <c:forEach var="i" begin="${startPage }" end="${endPage }">
	 	<a href="/MURA2/userboard/list.mur?pageNum=${i}" onclick="frm_sub(${i})">[${i}]</a>
	 </c:forEach>
	 
	 <c:if test="${endPage < pageCount }">
		<a href="/MURA2/userboard/list.mur?pageNum=${startPage + pageBlock }" onclick="frm_sub(${startPage + pageBlock})">[다음]</a> 
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
</div>
</div>


</body>
</html>
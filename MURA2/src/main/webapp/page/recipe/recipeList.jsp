<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="view/color.jspf" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MURA :: 레시피 게시판</title>
<link rel="icon" type="image/x-icon" href="../images/mura_logo.png">
<link href="css/recipeStyle.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
function check() {
	if(document.find_frm.find_box.value == "null") {
		alert("검색어를 입력하세요.");
		return false;
	}
}
function frm_sub(i) {
	i_frm.action = "/MURA2/page/recipe/recipeList.mur?pageNum=" + i;
	i_frm.submit();
}
</script>
</head>
<body bgcolor = "#ffffff">
	<!--N 네비메뉴 -->
    <nav>
		<a href="/loginPage"> Sign Up </a> |
		<a href="/loginPage"> Login </a> |
		<a href="/javascript/intro"> MyPage </a>
	</nav>
	<br><br>

	<!-- 상단 로고 -->
	<div class="logo">
	  <a href="/MURA2/page/index.jsp"> 
	  <img src="../images/topLogo.jpg" width="1194" height="230" border="0" alt=""></a>
	</div>
	
	<div>
	<table class="rayout_menu" width="1194" height="1081" border="0" cellpadding="0" cellspacing="0">
	
	<tr>
		<td>
			<a href="/MURA2/page/recipe/recipeList.mur">
			<img src="../images/recipe_btn.jpg" width="250" height="70" border="0" alt=""></a></td>
		<td>
			<a href="/MURA2/page/recipe/recipeWriteForm.mur">
			<img src="../images/write_btn.jpg" width="158" height="70" border="0" alt=""></a></td>
		<td colspan="2">
			<img src="../images/menu_margin.jpg" width="408" height="70" alt=""></td>
		<td>
			<a href="a">
			<img src="../images/request_btn.jpg" width="174" height="70" alt=""></a></td>
		<td>
			<a href="a">
			<img src="../images/qa_btn.jpg" width="204" height="70" border="0" alt=""></a></td>
	</tr>
	</table>
	</div>

<div align="center">
<table width="800">
  <tr>
	<td align="right">
	  <a href="/MURA2/page/recipe/recipeWriteForm.mur"><button>레시피 작성</button></a></td>
  </tr>
</table>

<c:if test="${count == 0 }">
<table width="800" border="1" cellpadding="0" cellspacing="0">
  <tr align="center">
    <td>게시판에 저장된 글이 없습니다.</td>
  </tr>
</table>
</c:if>

<c:if test="${count > 0 }">
<table width="800" border="1" cellpadding="0" cellspacing="0">
  <tr height="30" bgcolor="${value_c }">
    <td align="center" width="50">번호</td>
    <td align="center" width="90">카테고리</td>
    <td align="center" width="350">제목</td>
    <td align="center" width="110">작성자</td>
    <td align="center" width="150">작성일</td>
    <td align="center" width="50">조회수</td>
  </tr>
  
  <c:forEach var="article" items="${articleList}">
  
  <tr height="30">
  
    <td align="center" width="50">
    <c:out value="${number}"/>
    <c:set var="number" value="${number-1}"/>
    </td>

    <td align="center" width="90">
    ${article.category_li}
    </td>
    
    <td width="350">
    <div class="subjectbar">
      <a href="/MURA2/page/recipe/recipeContent.mur?num=${article.idx_li}&pageNum=${currentPage}">
      <img alt="" src="upload/${article.thumb_li}" width="100px" height="70px">&nbsp; 
      ${article.wsubject_li}</a>
      <c:if test="${article.readcount_li >= 40}">
      <img alt="" src="images/hot.gif" border="0" height="16">
      </c:if>
     </div>
    </td>
    
    <td align="center" width="110">
    ${article.nn_mem}
    </td>
    
    <td align="center" width="150">
    ${article.date_li}
    </td>
    
    <td align="center" width="50">
    ${article.readcount_li}
    </td>
    
  </tr>
  </c:forEach>
</table>
</c:if>

<!-- 페이징 처리 -->
<c:if test="${count > 0 }">
  <c:set var="imsi" value="${count % pageSize == 0 ? 0 : 1}"/>
  <c:set var="pageCount" value="${count / pageSize + imsi }"/>
  <c:set var="pageBlock" value="${3}"/>
  <fmt:parseNumber var="result" value="${(currentPage - 1) / pageBlock}" integerOnly="true"/>

  <c:set var="startPage" value="${result * pageBlock + 1}"/>
  <c:set var="endPage" value="${startPage + pageBlock - 1}"/>
  
  <c:if test="${endPage > pageCount}">
    <c:set var="endPage" value="${pageCount}"/>
  </c:if>
  
  <c:if test="${startPage > pageBlock}">
    <a href="/MURA2/page/recipe/recipeList.mur?pageNum=${startPage - pageBlock}" onClick="frm_sub(${startPage - pageBlock})">[이전]</a>
  </c:if>

  <c:forEach var="i" begin="${startPage}" end="${endPage}">
    <a href="/MURA2/page/recipe/recipeList.mur?pageNum=${i}" onClick="frm_sub(${i})">[${i}]</a>
  </c:forEach>

  <c:if test="${endPage < pageCount}">
    <a href="/MURA2/page/recipe/recipeList.mur?pageNum=${startPage + pageBlock}" onClick="frm_sub(${startPage + pageBlock})">[다음]</a>
  </c:if>
</c:if>

<br><br>

<form method="post" name="i_frm">
  <input type="hidden" name="find_box" value="${find_box}">
  <input type="hidden" name="find" value="${find}">
</form>

<form action="/MURA2/page/recipe/recipeList.mur" method="post" name="find_frm" onsubmit="return check()">
  <select name="find" size="1">
    <option value="writer">작성자</option>
    <option value="subject">제목</option>
    <option value="content">내용</option>
  </select>
  &nbsp;
  <input type="text" name="find_box">
  &nbsp;
  <input type="submit" value="검색">
</form>

<br><br>
<b>전체 글 : ${count}</b>
</div>

</body>
</html>
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
<link href="https://fonts.googleapis.com/css2?family=Lato&display=swap" rel="stylesheet">
<link href="css/recipeStyle.css" rel="stylesheet" type="text/css">
<link rel="icon" type="image/x-icon" href="../images/mura_logo.png">
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
	<div>
		<nav>
		 	 <c:choose>
				<c:when test="${id_mem ne null && id_mem eq 'aaaa1111' }">
					<a href="/MURA2/page/member/logout.mur"> 회원관리 </a> |
				</c:when>
				
				<c:when test="${id_mem ne null}">
					<a href="/MURA2/page/member/logout.mur"> Logout </a> |
					<a href="/MURA2/page/member/myPage.mur"> MyPage </a>
				</c:when>
							
				<c:otherwise>
					<a href="/MURA2/page/member/signinForm.mur"> Sign Up </a> |
					<a href="/MURA2/page/member/login.mur"> Login </a>&nbsp;
				</c:otherwise>
			</c:choose> 
		</nav>
	</div>
	<br><br>

	<!-- 상단 로고 -->
	<div class="logo">
	  <a href="/MURA2/page/index.mur"> 
	  <img src="../images/mura_logo2.png" width="230" height="230" border="0" alt=""></a>
	</div>
	
	<!-- 상단 메뉴바 -->
	<div class="tr1">
	<table border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td>
		<a href="/MURA2/page/recipe/recipeList.mur">
		<input style="margin-left: 300px" type="button" class="button" name="레시피 보기" value="레시피 보기"></a></td>
		
		<td>
		<a href="/MURA2/page/recipe/recipeWriteForm.mur">
		<input type="button" class="button" name="레시피 작성" value="레시피 작성" ></a></td>
		
		<td>
		<a href="/MURA2/userboard/boardList.mur">
		<input type="button" class="button" name="레시피 요청" value="레시피 요청" ></a></td>
		
		<td>
		<a href="/MURA2/userboard/qaboardList.mur">
		<input style="margin-right: 300px" type="button" class="button" name="Q&A" value="Q&A" ></a></td>
	</tr>
	</table>
	</div>

<div align="center">
<table width="980">
  <tr>
  		<c:choose>
			<c:when test="${id_mem eq null}">
				<td align="center">
				<div class="buttons buttons2">
				<button class="button5" onClick="alert('로그인 후 이용해 주세요!!');"></button></div></td>
			</c:when>

			<c:otherwise>
				<td align="center">
				<div class="buttons buttons2">
	            <a href="/MURA2/page/recipe/recipeWriteForm.mur"><button class="button5"></button></a></div></td>
			</c:otherwise>
		</c:choose>
  </tr>
</table>
<h3 style="color: olive;"> 나만의 레시피를 공유해보세요! </h3>

<br>
<c:if test="${count == 0 }">
<table width="800" border="1" cellpadding="0" cellspacing="0">
  <tr align="center">
    <td>게시판에 저장된 글이 없습니다.</td>
  </tr>
</table>
</c:if>

<div>
<c:if test="${count > 0 }">

<table style="display: inline-flex; border-collapse: collapse; table-layout: fixed;" border="1">

<tr height="30">
<td class="tt" align="center" width="45">카테 고리</td>
</tr>
<tr height="380">
  <td class="tt" align="center" width="45">제목</td> 
  </tr>
  <tr height="30">
  <td class="tt" align="center" width="45">작성자</td>
  </tr>
  <tr height="30">
  <td class="tt" align="center" width="45">작성일</td>
  </tr>
  <tr height="30">
  <td class="tt" align="center" width="45">추천수</td>
  </tr>
  <tr height="30">
  <td class="tt" align="center" width="45">조회수</td>
  </tr>
</table>


  <c:forEach var="article" items="${articleList}" varStatus="status">
<table style="display: inline-flex; border-collapse: collapse; table-layout: fixed; word-break:break-all; table-layout: fixed;" border="1" >  
 <%--  <tr height="30">
    <td class="tt" align="center" width="50">번호</td>
    <td align="center" width="50">
    <c:out value="${number}"/>
    <c:set var="number" value="${number-1}"/>
    </td>
  </tr> --%>
  
  <tr height="30">
  	
    <td align="center" width="90">
    ${article.category_li}
    </td>
  </tr>  
    
  <tr height="380">
  	
    <td width="300">
    <div class="subjectbar">
      <a href="/MURA2/page/recipe/recipeContent.mur?num=${article.idx_li}&pageNum=${currentPage}&thumb_li=${article.thumb_li}">
      <img onerror="this.style.visibility='hidden'" alt="" src="upload/${article.thumb_li}" width="300px" height="200px">&nbsp;
      <div align="center" class="txt">
      ${article.wsubject_li}
      <c:if test="${article.readcount_li >= 40}">
      <img alt="" src="images/hot.gif" border="0" height="30">
      </c:if></div></a>
      
     </div>
    </td>
  </tr>
  
  <tr height="30">
    <td align="center" width="110">
    ${article.nn_mem}
    </td>
  </tr>  
  
  <tr height="30">
    <td align="center" width="150">
    ${article.date_li}
    </td>
  </tr>
    
  <tr height="30">
    <td align="center" width="50">
    ${article.recommend_cnt}
    </td>
  </tr>

  <tr height="30">
    <td align="center" width="50">
    ${article.readcount_li}
    </td>
  </tr>
</table>
  </c:forEach>

</c:if>
</div>
<br>

<!-- 페이징 처리 -->
<div>
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
</div>

<br><br>

<div>
<!-- 게시판 내 검색 -->
<form method="post" name="i_frm">
  <input type="hidden" name="find_box" value="${find_box}">
  <input type="hidden" name="find" value="${find}">
</form>

<form action="/MURA2/page/recipe/recipeList.mur" method="post" name="find_frm" onsubmit="return check()">
  <select name="find" size="1">
    <option value="nn_mem">작성자</option>
    <option value="wsubject_li">제목</option>
    <option value="wcontent_li">내용</option>
  </select>
  &nbsp;
  <input type="text" name="find_box">
  &nbsp;
  <input type="submit" class="c2" value="검색">
</form>

<br><br>
<%-- <b>전체 글 : ${count}</b> --%>
</div>


<c:if test="${todayImageList ne null}">
 <div id="todayImageList" align="center">
  <h2>오늘 본 레시피</h2>
  <table align="center">
   <tr>
    <c:forEach var="todayImage" items="${todayImageList}">
     <td>
      <img alt="" src="upload/${todayImage}" id="todayImage" width="170px" height="110px" border="1"></a>&nbsp;
     </td>
      <c:if test="${((status.index+1) mod 4) == 0 }">
     </tr>
    <tr>
    </c:if>
    </c:forEach>
    </tr>
  </table>
 </div>
</c:if>
<br>
<%@ include file="../footer.jsp" %>
</body>
</html>
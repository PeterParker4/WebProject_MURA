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
<style type="text/css">

.tt{
background-color: #FFC31E;
}

.txt{
font-size: 24px;
font-weight: bold;
}
.button5{
width: 120px;
height: 110px;
background-color: #fff;
background-image: url("../images/nem2.png");
background-size: 100px 100px;
background-position:center;
background-repeat:no-repeat;
transition: all 0.3s;
border-radius: 5px;

}

.button5:hover{
color:#fff;
font-size: 15px;
background-image: url("../images/nem1.png");
background-size: 110px 100px;
background-position:center;
background-repeat:no-repeat;

}

 



</style>
<link href="https://fonts.googleapis.com/css2?family=Lato&display=swap" rel="stylesheet">
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
					<a href="/MURA2/page/member/signinForm.mur"> Sign In </a> |
					<a href="/MURA2/page/member/login.mur"> Login </a> |
					<a href="/MURA2/page/member/myPage.mur"> MyPage </a>
				</c:otherwise>
			</c:choose> 
		</nav>
	</div>
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
<h3 style="color: olive;">< 나만의 레시피 공유하기 ></h3>
<table width="980">
  <tr>
	<td align="center">
	<div class="buttons buttons2">
	  <a href="/MURA2/page/recipe/recipeWriteForm.mur"><button class="button5">
	  </button></a></div></td>
	
  </tr>
</table>
<br><br>
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
  <td class="tt" align="center" width="45">조회수</td>
  </tr>
</table>


  <c:forEach var="article" items="${articleList}">
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
      <a href="/MURA2/page/recipe/recipeContent.mur?num=${article.idx_li}&pageNum=${currentPage}">
      <img onerror="this.style.visibility='hidden'" alt="" src="upload/${article.thumb_li}" width="300px" height="300px">&nbsp;
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
  <input type="submit" value="검색">
</form>

<br><br>
<%-- <b>전체 글 : ${count}</b> --%>
</div>

<c:if test="${todayImageList ne null }">
 <div id="todayImageList" align="center">
  <h2>오늘 본 레시피</h2>
  <table>
   <tr>
    <c:forEach var="todayImage" items="${todayImageList }">
     <td>
      <img alt="" src="upload/${todayImage }" id="todayImage">
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


</body>
</html>
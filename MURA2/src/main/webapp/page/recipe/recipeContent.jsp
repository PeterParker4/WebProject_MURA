<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MURA :: 레시피 상세보기</title>
<script type="text/javascript">
function check() {
	if(document.replyWriteForm.content_reply.value==""){
		alert("댓글 내용을 입력해 주세요");
		return false;
	}
  }
</script>
<style type="text/css">
.s2{
height: 35px;
width: 60px;
border: thin;
border-radius: 5px;
border-color: aqua;
background-color: #330033;
color: white;
font-weight: bold;
cursor: pointer;
float: right;
margin: 5px;
font-size: 17px;
font-weight: lighter;
}

.s2:hover{
background-color: orange;
color:black;
}

.read{
float: right;
padding: 3px;
text-align: right;
font-weight: bold;
}

.read2{
float: left;
padding-top: 3px;
text-align: left;
font-weight: bold;
}

.read3{
float: left;
padding:0px 20px 0px 20px;
text-align: left;
font-size: 20px;
font-weight:bold;
color: #fff;
background-color: #a84781;
}

.div1{
width: 55%;

}

.title{
font-size: 36px;
font-weight: bolder;
letter-spacing: 2px;
}

.je{
color: #a84781;
font-weight: bold;
padding-top: 4px;
}
</style>
<link rel="icon" type="image/x-icon" href="images/mura_logo.png">
<link href="css/recipeStyle.css" rel="stylesheet" type="text/css">
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
<script type="text/javascript" src="js/script.js"></script>

</head>

<body bgcolor = "ffffff">

	<!--N 네비메뉴 -->
	<%@ include file="../nav.jsp" %>
	<br><br>

	<!-- 상단 로고 -->
	<div class="logo">
	  <a href="/MURA2/page/index.mur"> 
	  <img src="../images/mura_logo2.png" width="230" height="230" border="0" alt=""></a>
	</div>
	
	<!-- 상단 메뉴바 -->
	<%@ include file="../menubar.jsp" %>

<div style="display: flex; justify-content: center; align-items: center;">
<div align="center" class="div1"><br><br>
<form>

<hr size="4px;" color="#a84781">

<b class="title">${article.wsubject_li}</b>
<hr size="4px;" color="#a84781">
<div style="background-color: #DDDDDD; height: 30px; width: 100%;">
<div class="read2">&nbsp; <b>${article.nn_mem}</b> | 글번호 ${article.idx_li} | 조회수 ${article.readcount_li}</div> <div class="read">작성일 ${article.date_li} &nbsp;</div>
   </div>

<div class="read3"> 재료 </div>
<div class="je">${article.tag_li}</div>
<hr>
<br><br>

	    <img alt="" src="upload/${article.thumb_li}" id="thumbnailImage" width="80%" height="80%"><br>
	    ${article.wcontent_li}<br>
    
<br><br>

<table>
<tr align="center">
<td align="center">추천수 : ${article.recommend_cnt}</td>
</tr>

<c:if test="${memberInfo.id_mem ne null}">
 <tr align="center">
 <td align="center">
 	<a href="/MURA2/page/recipe/recipeRecommend.mur?num=${num}&pageNum=${pageNum}&board_num=${article.board_num}"> 
	  <img src="images/heart.png" width="40" height="40" border="0" alt=""></a></td>
 </tr>
</c:if>
</table>    
<br><br>
<a id="btnTwitter" class="link-icon twitter" href="javascript:shareTwitter('${article.wsubject_li}',${num},${pageNum});"></a>&nbsp;
<a id="btnFacebook" class="link-icon facebook" href="javascript:shareFacebook(${num},${pageNum});"></a>&nbsp;
<a id="btnKakao" class="link-icon kakao" href="javascript:shareKakao();"></a>&nbsp; 
    
<hr>

      <c:if test="${memberInfo.un_mem eq article.un_mem}">
      <a href="/MURA2/page/recipe/recipeDeleteProc.mur?num=${num}&pageNum=${pageNum}&un_mem=${article.un_mem}">
      <input type="button" class="s2" value="글삭제" onclick="return confirm('정말로 삭제하시겠습니까?')">
      </a>
      &nbsp;&nbsp;
      
      <input type="button" class="s2" value="글수정" 
      onclick="document.location.href='/MURA2/page/recipe/recipeUpdateForm.mur?num=${num}&pageNum=${pageNum}'">
      &nbsp;&nbsp;
      </c:if>
      
      <input type="button" class="s2" value="글목록" 
      onclick="document.location.href='/MURA2/page/recipe/recipeList.mur?pageNum=${pageNum}'">
    
</form>
</div>
</div>
<br>
<br>

<table border="0" width="700" align="center">

<tr>
<td class="s1_1" align="center" width="100">작성자</td>
<td class="s1_1" align="center" width="500">댓글 내용</td>
<td class="s1_1" align="center" width="100">작성일</td>
</tr>
<c:if test="${article.reply_cnt == 0}">
<tr align="center" >
	    <td colspan="3">댓글이 없습니다.</td>
</tr>
</c:if>

<c:forEach var="reply" items="${replyList}">

<c:if test="${article.reply_cnt > 0}">
<tr>
<td>${reply.nn_reply}</td>
<td>${reply.content_reply}</td>
<td>${reply.date_reply}</td>
</tr>
</c:if>

</c:forEach>
</table>

<br><br>
<c:if test="${id_mem != null}">
<form action="/MURA2/page/recipe/recipeReplyProc.mur?num=${article.idx_li}&pageNum=${pageNum}&thumb_li=${article.thumb_li}" method="post" name="replyWriteForm" onsubmit="return check()">
<table width="700" align="center">
<tr><td>${memberInfo.nn_mem}</td>
<td><textarea rows="3" cols="" placeholder="댓글을 입력하세요." name="content_reply" style="width: 100%"></textarea>
</td></tr>
<tr><td colspan="2" align="right"><input type="submit" class="s2" value="댓글"></td></tr>
</table>
</form>
</c:if>
<br><br>

<!--F 푸터메뉴 -->
<%@ include file="../footer.jsp" %>

</body>
</html>
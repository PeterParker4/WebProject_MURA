<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="id_mem" value="${sessionScope.id_mem }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MURA :: 당신의 식탁을 더 맛있게</title>
<script type="text/javascript" src="script.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<link rel="icon" type="image/x-icon" href="images/mura_logo.png">
<link href="css/style.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
</head>

<body bgcolor="#FFFFFF">

	<!-- logout 페이지 이 안에서 구현 -->

	<!--N 네비메뉴 -->
	<div>
		<nav>
	<%-- <c:if test="${id_mem eq null }">
		<a href="member/signinForm.mur"> Sign In </a> |
		<a href="member/login.mur"> Login </a> |
		<a onclick="alert('로그인을 먼저 해 주세요!');location.href='/MURA2/page/member/login.mur'" style="cursor:pointer;"> MyPage </a>
	</c:if>
	<c:if test="${id_mem ne null && id_mem eq 'aaaa1111'}">
		<a href="#"> 회원관리 페이지 </a> |
		<a href="#"> 관리자페이지 </a>
	</c:if>
	<c:if test="${id_mem ne null }">
		<a href="member/logout.mur"> Logout </a> |
		<a href="member/myPage.mur"> MyPage </a>
	</c:if> --%>
	  
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
	<br>
	<!-- 상단 로고 -->
	<div class="logo">
		<a href="/MURA2/page/index.jsp"> <img src="images/topLogo.jpg"
			width="1194" height="230" border="0" alt=""></a>
	</div>

	<div>
		<table id="Table_01" width="1194" height="1081" border="0"
			cellpadding="0" cellspacing="0">

			<tr>
				<td><a href="/MURA2/page/recipe/recipeList.mur"> <img src="images/recipe_btn.jpg"
						width="250" height="70" border="0" alt=""></a></td>
				<td><a href="/MURA2/page/recipe/recipeWriteForm.mur"> <img src="images/write_btn.jpg"
						width="158" height="70" border="0" alt=""></a></td>
				<td colspan="2"><img src="images/menu_margin.jpg" width="408"
					height="70" alt=""></td>
				<td><a href="a"> <img src="images/request_btn.jpg"
						width="174" height="70" alt=""></a></td>
				<td><a href="a"> <img src="images/qa_btn.jpg" width="204"
						height="70" border="0" alt=""></a></td>
			</tr>

			<!-- 검색창 -->
			<tr>
				<td colspan="6"><img src="images/search_area.jpg" width="1194"
					height="282" alt="">
					<div class="search-wrapper">
						<div class="input-holder">
							<input type="text" class="search-input" placeholder="재료를 입력하세요!" />
							<button class="search-icon" onclick="searchToggle(this, event);">
								<span></span>
							</button>
						</div>
						<span class="close" onclick="searchToggle(this, event);"></span>
					</div></td>
			</tr>

			<!-- 중간 메뉴바 -->
			<tr>
				<td colspan="6"><img src="images/midle_bar.jpg" width="1194"
					height="84" alt=""></td>
			</tr>

			<tr>
<!-- 				<td colspan="3"><img src="images/best10_area.jpg" width="480"
					height="414" alt=""></td> -->
				<td colspan="3" width="480" height="300">
				게시판에 저장된 글이 없습니다.
				</td>
				<!-- <td colspan="3"><img src="images/hot3_area.jpg" width="714"
					height="414" alt=""></td> -->
			    <td align="center" width="238" height="300">
			    <img alt="" src="upload/${article.thumb_li}" width="200px" height="140px"><br>
			    자글자글 된장찌개
			    </td>
   				<td align="center" width="238" height="300">
   				<img alt="" src="upload/${article.thumb_li}" width="200px" height="140px"><br>
   				맛있는 오야코동
   				</td>
				<td align="center" width="238" height="300">
				<img alt="" src="upload/${article.thumb_li}" width="200px" height="140px"><br>
				집에서 느끼는 오마카세
				</td>	
			</tr>

			<!-- 여백 -->
			<tr>
				<td><img src="images/&#xc2a4;&#xd398;&#xc774;&#xc11c;.gif"
					width="250" height="1" alt=""></td>
				<td><img src="images/&#xc2a4;&#xd398;&#xc774;&#xc11c;.gif"
					width="158" height="1" alt=""></td>
				<td><img src="images/&#xc2a4;&#xd398;&#xc774;&#xc11c;.gif"
					width="72" height="1" alt=""></td>
				<td><img src="images/&#xc2a4;&#xd398;&#xc774;&#xc11c;.gif"
					width="336" height="1" alt=""></td>
				<td><img src="images/&#xc2a4;&#xd398;&#xc774;&#xc11c;.gif"
					width="174" height="1" alt=""></td>
				<td><img src="images/&#xc2a4;&#xd398;&#xc774;&#xc11c;.gif"
					width="204" height="1" alt=""></td>
			</tr>

		</table>
	</div>

	<!--F 푸터메뉴 -->
	<%@ include file="footer.jsp" %>
</body>
<script type="text/javascript">
    $(document).ready(function(){
      var imgs;
      var img_count;
      var img_position = 1;

      imgs = $(".slide ul");
      img_count = imgs.children().length;

      $('#back').click(function () {
        back();
      });
      $('#next').click(function () {
        next();
      });

      function back() {
        if(1<img_position){
          imgs.animate({
            left:'+=1000px'
          });
          img_position--;
        }
      }
      function next() {
        if(img_count>img_position){
          imgs.animate({
            left:'-=1000px'
          });
          img_position++;
        }
      }


      


    });
  </script>
</html>
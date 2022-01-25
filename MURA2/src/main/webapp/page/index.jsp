<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MURA :: 당신의 식탁을 더 맛있게</title>
<style type="text/css">
.bt1{
width: 250px; 
height: 65px;
align-content: center

background-color: #fff;
border-color: #a84781;
color:#a84781;
border-width: 6px;
border-style: double;
border-radius: 5px;
padding: 10px;
text-align: center;
text-decoration: none;
display: run-in;
font-size: 30px;
cursor: pointer;
margin: 4px;
}

/* @media (max-width: 800px) {
  * {
    background-image: url("images/momo.jpg");
  }
}  */

*{
font-family: 'Nanum Pen Script', cursive;
}

.im{
bottom: 0px;
position: relative;
margin: 5px;
}

.do{

position:static;
}

p{
text-align: center;
text-decoration: underline;
text-shadow: navy;
vertical-align: super;
}

.btn {
width:270px;
height:75px;
  background: none;
  border: 2px solid;
  border-style:solid;
  border-width: 3px;
  border-bottom-width: 8px;
  font: inherit;
  font-size: 40px;
  letter-spacing: inherit;
  margin: 5px;
  padding: 4px;
  text-transform: inherit;
  transition: color 1s;
  cursor: pointer;
  border-radius: 5px;
}


@-webkit-keyframes sheen {
  0% {
    transform: skewY(-45deg) translateX(0);
  }
  100% {
    transform: skewY(-45deg) translateX(12.5em);
  }
}
@keyframes sheen {
  0% {
    transform: skewY(-45deg) translateX(0);
  }
  100% {
    transform: skewY(-45deg) translateX(12.5em);
  }
}
.wrapper {
  display: block;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
}

.img{
position: relative;
right: 80px;
top: 3px;
z-index: 1;
}

.tr1{
width: 100%;
height: 90px;
box-shadow: 1px;
}

.cart{
width: 260px;
height: 400px;
border: black 2px solid;
color: black;
position: fixed;
left: 50px;
top: 400px;
z-index: 1;
}

.cart::after {
width: 260px;
height: 400px;
background-color: #fff;
content:"";
position: absolute;
left: 0;
top: 0;
z-index:-1;
opacity: 0.8;
}

.back{
/* background-image: url("images/pink.jpg"); */
background-size: cover;
}


</style>

<style media="screen">
      *{
        margin: 0; padding: 0;
      }
      .slide{
        width: 1000px;
        height: 600px;
        overflow: hidden;
        position: relative;
        margin: 0 auto;
      }
      .slide ul{
        width: 5000px;
        position: absolute;
        top:0;
        left:0;
        font-size: 0;
      }
      .slide ul li{
        display: inline-block;
      }
      #back{
        position: absolute;
        top: 250px;
        left: 0;
        cursor: pointer;
        z-index: 1;
      }
      #next{
        position: absolute;
        top: 250px;
        right: 0;
        cursor: pointer;
        z-index: 1;
      }
     </style>
     
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="script.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<link rel="icon" type="image/x-icon" href="images/mura_logo.png">
<link href="css/style.css" rel="stylesheet" type="text/css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap" rel="stylesheet">
</head>
<body>
<div class="back">
	<!--N 네비메뉴 -->
	<%@ include file="nav.jsp" %>
	<br><br>
	
	<!-- 상단 로고 -->
	<div class="logo">
	  <a href="/MURA2/page/index.mur"> 
	  <img src="images/mura_logo2.png" width="230" height="230" border="0" alt=""></a>
	</div>
	
	<br><br><br>
	
	<!-- 검색 토글 -->
	<div class="search-wrapper">
	<form action="/MURA2/page/recipe/recipeList.mur?find=tag_li" method="post" name="find_frm" onsubmit="return check()">
			    <div class="input-holder">
			        <input type="text" name="find_box" class="search-input" placeholder="재료를 입력하세요!"/>
			        <button type="submit" class="search-icon" onclick="searchToggle(this, event);"><span></span></button>
			    </div>
			    <span class="close" onclick="searchToggle(this, event);"></span>
	</form>
	</div>
			
	<br><br><br><br>		
	
	<!-- 상단 메뉴바 -->
	<%@ include file="menubar.jsp" %>
	<br>
	<hr style="width:100%;height:3px;border:none;background-color:#a84781;">
	<br><br>
	
	<!-- 카테고리 이동 -->
	<div class="category">
	<table  width="1000" border="0" cellpadding="0" cellspacing="0">
	  <tr>
	    <td>
	    <a href="/MURA2/page/recipe/recipeList.mur?find=category_li&find_box=한식">
	      <img alt="" src="images/korea.png" width="100" height="100"></a>
	    </td>

	    <td>
   	    <a href="/MURA2/page/recipe/recipeList.mur?find=category_li&find_box=일식">
	      <img alt="" src="images/japan.png" width="100" height="100"></a>
	    </td>

	    <td>
   	    <a href="/MURA2/page/recipe/recipeList.mur?find=category_li&find_box=양식">
	      <img alt="" src="images/western.png" width="100" height="100"></a>
	    </td>

	    <td>
   	    <a href="/MURA2/page/recipe/recipeList.mur?find=category_li&find_box=중식">
	      <img alt="" src="images/china.png" width="100" height="100"></a>
	    </td>

	    <td>
   	    <a href="/MURA2/page/recipe/recipeList.mur?find=category_li&find_box=분식">
	      <img alt="" src="images/bunsik.png" width="100" height="100"></a>
	    </td>

	    <td>
   	    <a href="/MURA2/page/recipe/recipeList.mur?find=category_li&find_box=디저트">
	      <img alt="" src="images/desert.png" width="100" height="100"></a>
	    </td>
	    
	  </tr>
	</table>
	</div>
	
	<br><br>
	<!-- 슬라이드쇼 -->
	<div class="slide">
      <img id="back" src="img/left.jpg" alt="" width="100">
      <ul>
        <li><img src="img/name1.png" alt="" width="1000" height="600"></li>
        <li><img src="img/name2.jpg" alt="" width="1000" height="600"></li>
        <li><img src="img/name3.jpg" alt="" width="1000" height="600"></li>
        <li><img src="img/name4.png" alt="" width="1000" height="600"></li>
        <li><img src="img/name5.jpg" alt="" width="1000" height="600"></li>
      </ul>
      <img id="next" src="img/right.jpg" alt="" width="100">
    </div>
<br>

<div align="center">
<img alt="" src="images/midlebar_index.png">
</div>  
  
<div align="center">
	<table style="display: inline-flex; border-collapse: collapse; table-layout: fixed;	position: relative; 
	border:2px solid #a84781; padding: 5px; border-radius:10px;" border="0">
		<tr height="30">
			<td width="230">레시피</td>
			<td width="50">조회수</td>
		</tr>
		<c:forEach var="article" items="${articleList}" end="9">
		<tr height="30">
			<td align="left" width="230">
			<div style="width:200px; text-overflow:ellipsis; overflow:hidden; white-space:nowrap;" title="잉 기모링">
			<a href="/MURA2/page/recipe/recipeContent.mur?num=${article.idx_li}&pageNum=1&thumb_li=${article.thumb_li}">${article.wsubject_li}</a>
			<img alt="" src="recipe/images/hot.gif" border="0" height="20"></div>
			</td>
			<td align="center" width="50">${article.readcount_li}</td>
		</tr>
		</c:forEach>
	</table>
	
	<table style="display: inline-flex; border-collapse: collapse; position: relative; top: 30px; right: -7px;" border="0">
		
		<tr style="margin-bottom: 5px;">
			<td><img src="images/icons/kin.png" width="50" height="60"></td>
			<td><img src="images/icons/gin.png" width="50" height="60"></td>
			<td><img src="images/icons/dong.png" width="50" height="60"></td>
		</tr>

		<tr>
		<c:forEach var="article2" items="${articleList2}" end="2">
			<td><a href="/MURA2/page/recipe/recipeContent.mur?num=${article2.idx_li}&pageNum=1&thumb_li=${article2.thumb_li}">
			<img alt="" src="recipe/upload/${article2.thumb_li}" width="230" height="180"></a></td>
		</c:forEach>
		</tr>	

		<tr height="30">
		<c:forEach var="article2" items="${articleList2}" end="2">
			<td style="background-color: #FFBCD9; color: white; text-shadow: -1px 0 black, 0 1px black, 1px 0 black, 0 -1px black;">
			<a style="color: white" href="/MURA2/page/recipe/recipeContent.mur?num=${article2.idx_li}&pageNum=1&thumb_li=${article2.thumb_li}">
			${article2.wsubject_li}</a></td>
		</c:forEach>
		</tr>	
	</table>
</div>
<br><br>  
  

<div class="cart">
<b>&nbsp;최근 둘러본 레시피</b>

	<table>
		<tr>
			<td width="100">
				<a href=""><img align="left" alt="" src="images/nuguri.jpg" width="90" height="90" style="padding-right: 10px; margin-top: 5px;"></a></td>
				<td width="150" align="left" valign="middle"><a href="">너구리 맛있게 먹는법</a>
			</td>
		</tr>
		<tr>
			<td width="100">
				<a href=""><img align="left" alt="" src="images/jind.jpg" width="90" height="90" style="padding-right: 10px;"></a></td>
				<td width="150" align="left" valign="middle"><a href="">찜닭 존나 맛있닭</a>
			</td>
		</tr>
		<tr>
			<td width="100">
				<a href=""><img align="left" alt="" src="images/burin.jpg" width="90" height="90" style="padding-right: 10px;"></a></td>
				<td width="150" align="left" valign="middle"><a href="">직접 만들어먹는 뿌링클</a>
			</td>
		</tr>
		<tr>
			<td width="100">
				<a href=""><img align="left" alt="" src="images/dak.jpg" width="90" height="90" style="padding-right: 10px;"></a></td>
				<td width="150" align="left" valign="middle"><a href="">매콤한 족발대신 오독오독 닭발 어때요?</a>
			</td>
		</tr>
		
	</table>

</div>
<br><br>
	
<%@ include file="footer.jsp" %>

</div>
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
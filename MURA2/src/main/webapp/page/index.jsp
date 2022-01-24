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

.button {
width:250px;
height:60px;
margin:15px;
  padding: 5px;
  text-align: center;
  text-decoration: none;
  color: black;
  font-size: 30px;
  text-shadow: -2px 0 white, 0 2px white, 2px 0 white, 0 -2px white;
  border-radius: 0.3em;
  transition: all 0.2s ease-in-out;
  position: relative;
  overflow: hidden;
  background-color: transparent;
  z-index: 1;
  border: none;
}

.button:after{
background-color: #a84781;
width:250px;
height:60px;width:250px;
height:60px;
opacity: 0.5;
color:black;
content: "먼지풀풀";
position: absolute;
left: 0px;
top: 24px;
}

.button:before {
  content: "";
  background-color: rgba(255, 255, 255, 0.5);
  height: 100%;
  width: 3em;
  display: block;
  position: absolute;
  top: 0;
  left: -4.5em;
  transform: skewX(-45deg) translateX(0);
  transition: none;
}
.button:hover {
  background-color: transparent;
  color: gray;
  /* border: 1px solid #fff; */
  font-size: 24px;
  font-weight: normal;
}
.button:hover:before {
  transform: skewX(-45deg) translateX(13.5em);
  transition: all 0.5s ease-in-out;
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
	  <img src="images/mura_logo2.png" width="230" height="230" border="0" alt=""></a>
	</div>
	
	<br><br><br>
	
	<div class="search-wrapper">
			    <div class="input-holder">
			        <input type="text" class="search-input" placeholder="재료를 입력하세요!"/>
			        <button class="search-icon" onclick="searchToggle(this, event);"><span></span></button>
			    </div>
			    <span class="close" onclick="searchToggle(this, event);"></span>
	</div>
			
	
	<br><br><br><br>		
	
	<!-- 상단 메뉴바 -->
	<div class="tr1">
	<table border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td>
		<a href="/MURA2/page/recipe/recipeList.mur">
		<input style="margin-left: 300px" type="button" class="button" name="레시피 보기" value="레시피 보기"></a></td>

		<c:choose>
			<c:when test="${id_mem eq null}">
				<td>
				<input type="button" class="button" name="레시피 작성" value="레시피 작성" onClick="alert('로그인 후 이용해 주세요!!');">
				</td>
			</c:when>

			<c:otherwise>
				<td><a href="/MURA2/page/recipe/recipeWriteForm.mur"> 
				<input type="button" class="button" name="레시피 작성" value="레시피 작성"></a></td>
			</c:otherwise>
		</c:choose>
		
		<td>
		<a href="/MURA2/userboard/boardList.mur">
		<input type="button" class="button" name="레시피 요청" value="레시피 요청" ></a></td>
		
		<td>
		<a href="/MURA2/userboard/qaboardList.mur">
		<input style="margin-right: 300px" type="button" class="button" name="Q&A" value="Q&A" ></a></td>
	</tr>
	</table>
	</div>
	
	<br><br>
	
	
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
	<table style="display: inline-flex; border-collapse: collapse; table-layout: fixed;	position: relative;" border="0">
		<tr height="30">
			<td width="230">레시피</td>
			<td width="50">조회수</td>
		</tr>
		<c:forEach var="article" items="${articleList}" end="9">
		<tr height="30">
			<td align="left" width="230"><a href=""><div style="width:200px; text-overflow:ellipsis; overflow:hidden; white-space:nowrap;" title="잉 기모링">${article.wsubject_li}</div></a></td>
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
			<td><img alt="" src="images/burin.jpg" width="230" height="230"></td>
			<td><img alt="" src="images/dak.jpg" width="230" height="230"></td>
			<td><img alt="" src="images/jind.jpg" width="230" height="230"></td>
		</tr>	
		<tr height="30">
			<td style="background-color: #FF8C8C; color: white; text-shadow: -1px 0 black, 0 1px black, 1px 0 black, 0 -1px black;">첫번째로 맛있는 음식 </td>
			<td style="background-color: #5ABEFF; color: white; text-shadow: -1px 0 black, 0 1px black, 1px 0 black, 0 -1px black;">두번째로 맛있는 음식 </td>
			<td style="background-color: #acffef; color: white; text-shadow: -1px 0 black, 0 1px black, 1px 0 black, 0 -1px black;">세번째로 맛있는 음식 </td>
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MURA :: 당신의 식탁을 더 맛있게</title>
<script type="text/javascript" src="script.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<link rel="icon" type="image/x-icon" href="images/mura_logo.png">
<link href="css/style.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
</head>

<body bgcolor="#FFFFFF">

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
	  <img src="images/topLogo.jpg" width="1194" height="230" border="0" alt=""></a>
	</div>
	
	<div>
	<table id="Table_01" width="1194" height="1081" border="0" cellpadding="0" cellspacing="0">
	
	<tr>
		<td>
			<a href="a">
			<img src="images/recipe_btn.jpg" width="250" height="70" border="0" alt=""></a></td>
		<td>
			<a href="a">
			<img src="images/write_btn.jpg" width="158" height="70" border="0" alt=""></a></td>
		<td colspan="2">
			<img src="images/menu_margin.jpg" width="408" height="70" alt=""></td>
		<td>
			<a href="a">
			<img src="images/request_btn.jpg" width="174" height="70" alt=""></a></td>
		<td>
			<a href="a">
			<img src="images/qa_btn.jpg" width="204" height="70" border="0" alt=""></a></td>
	</tr>
	
	<!-- 검색창 -->
	<tr>
		<td colspan="6">
			<img src="images/search_area.jpg" width="1194" height="282" alt="">
			<div class="search-wrapper">
			    <div class="input-holder">
			        <input type="text" class="search-input" placeholder="재료를 입력하세요!" />
			        <button class="search-icon" onclick="searchToggle(this, event);"><span></span></button>
			    </div>
			    <span class="close" onclick="searchToggle(this, event);"></span>
			</div>
        </td>
	</tr>
	
	<!-- 중간 메뉴바 -->
	<tr>
		<td colspan="6">
			<img src="images/midle_bar.jpg" width="1194" height="84" alt=""></td>
	</tr>
	
	<tr>
		<td colspan="3">
			<img src="images/best10_area.jpg" width="480" height="414" alt=""></td>
		<td colspan="3">
			<img src="images/hot3_area.jpg" width="714" height="414" alt=""></td>
	</tr>
	
	<!-- 여백 -->
	<tr>
		<td>
			<img src="images/&#xc2a4;&#xd398;&#xc774;&#xc11c;.gif" width="250" height="1" alt=""></td>
		<td>
			<img src="images/&#xc2a4;&#xd398;&#xc774;&#xc11c;.gif" width="158" height="1" alt=""></td>
		<td>
			<img src="images/&#xc2a4;&#xd398;&#xc774;&#xc11c;.gif" width="72" height="1" alt=""></td>
		<td>
			<img src="images/&#xc2a4;&#xd398;&#xc774;&#xc11c;.gif" width="336" height="1" alt=""></td>
		<td>
			<img src="images/&#xc2a4;&#xd398;&#xc774;&#xc11c;.gif" width="174" height="1" alt=""></td>
		<td>
			<img src="images/&#xc2a4;&#xd398;&#xc774;&#xc11c;.gif" width="204" height="1" alt=""></td>
	</tr>
	
	</table>
</div>

 	<!-- 검색창 -->
	<div class="search-wrapper">
	    <div class="input-holder">
	        <input type="text" class="search-input" placeholder="Type to search" />
	        <button class="search-icon" onclick="searchToggle(this, event);"><span></span></button>
	    </div>
	    <span class="close" onclick="searchToggle(this, event);"></span>
	</div>
	
	<!--F 푸터메뉴 -->
    <footer class="footer">
		<hr style="width:75%;height:6px;border:none;background-color:#a84781;">
		<div class="container" style="padding-top:7px;" align="center">
			<div class="row">
        		<div class="col-md-4 media"><div class="pull-left"><i class="fa fa-info-circle fa-2x fa-fw"></i></div>
					<div class="media-body" style="float:left;width:33%">
					<h3>(주)MURA</h3>
					<p class="text-muted">대표이사: 성세연<br>서울특별시 영등포구<br>010-1234-1234<br>jinsu9337@naver.com
					</p>
					</div>
      			</div>
        		<div class="col-md-4 media"><div class="pull-left"><i class="fa fa-file-o fa-2x fa-fw"></i></div>
					<div class="media-body" style="float:left;width:33%">
					<h3>Site Info</h3>
					<p class="text-muted">"MURA" Designed by <a href="http://readiz.com" target="_blank">YJS</a><br/>with <a href="http://yongzz.com" target="_blank">yongzz</a>, <a href="http://wincomi.com" target="_blank">wincomi</a>, <a href="http://markquery.com" target="_blank">Ungki. H</a><br/><a href="http://blog.readiz.com/22">Further Information</a>
					</p>
					</div>
				</div>
        		<div class="col-md-4 media"><div class="pull-left"><i class="fa fa-link fa-2x fa-fw"></i></div>
					<div class="media-body" style="float:left;width:33%"><h3>Other Links</h3>
						<p class="text-muted">
							<a href="/MURA2/page/index.jsp" title="홈">Top</a> | <a href="/tag" title="태그">태그</a>
						</p><br><br>
					</div>
				</div>
			</div>
			<br><br>
			<div class="row">
				<div class="col-md-12" >
					<hr style="width:75%;height:6px;border:none;background-color:#a84781;"><br>
					<p class="text-muted">Copyright ⓒ 2021-2022 MURA All rights reserved.</p>
				</div>
			</div>
		</div>
    </footer>
</body>
</html>
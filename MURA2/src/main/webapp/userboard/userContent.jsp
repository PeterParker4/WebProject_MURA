<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MURA :: 요청 게시판 글 보기</title>
<style type="text/css">



*{
font-family: "bmh";
}

.s2{
height: 25px;
width: 60px;
border: thin;
border-radius: 5px;
border-color: aqua;
background-color: #330033;
color: white;
font-weight: normal;
cursor: pointer;
float: right;
margin: 5px;
text-align: center;
padding: 0px;
font-size: 17px;
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
width: 40%;

}

.title{
font-size: 36px;
font-weight: bolder;
letter-spacing: 5px;
}

.je{
color: #a84781;
font-weight: bold;
padding-top: 4px;
}
</style>

<link rel="icon" type="image/x-icon" href="../images/mura_logo.png">
<link href="../page/css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
function deleteCheck(){
	if(confirm("정말로 삭제하시겠습니까?"); == true){
		document.form.submit();
		alert("삭제되었습니다.");
	}else{
		return;
	}
}
</script>
</head>


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
	  <img src="../page/images/topLogo.jpg" width="1194" height="230" border="0" alt=""></a>
	</div>


<!--  <body bgcolor="${bodyback_c }">
<div align="center"> <b>글 상세 보기</b> <br><br>  -->

<div style="display: flex; justify-content: center; align-items: center;">
<div align="center" class="div1"><br><br>
<form>

<hr size="4px;" color="#a84781">

<pre><b class="title">고등어구이 속 성세연가시 ${userArticle.wsubject_ut }</b></pre>

<hr size="4px;" color="#a84781">

<div style="background-color: #DDDDDD; height: 30px; width: 100%;">

<div class="read2">&nbsp; 
작성자 &nbsp;
<b>${userArticle.nn_mem } |</b>

조회수&nbsp;
${userArticle.readcount_ut }
</div>


<div class="read">작성일 &nbsp;
${userArticle.date_ut } &nbsp;</div>
</div>
<hr>
<br><br>


<pre>${userArticle.wcontent_ut }</pre>

<br><br>
<hr>



<input type="button" class="s2" value="글수정"
onclick="document.location.href='/MURA2/userboard/userUpdateForm.mur?idx_ut=${userArticle.idx_ut }&pageNum=${pageNum }'">
&nbsp;&nbsp;&nbsp;&nbsp;

<a class="s2" onclick="return confirm('정말로 삭제하시겠습니까?')"
href="/MURA2/userboard/userDeletePro.mur?idx_ut=${userArticle.idx_ut }&pageNum=${pageNum}">삭제</a>

<input type="button" class="s2" value="글목록"
onclick="document.location.href='/MURA2/userboard/boardList.mur?pageNum=${pageNum }'">

<br><br>
<hr>

댓글주세요

</form>
</div>
</div>


<br><br>

<!--F 푸터메뉴 -->
<div>
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

</div>

</body>
</html>
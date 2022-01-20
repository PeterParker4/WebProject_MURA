<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MURA :: Q&A 유저 게시판 글쓰기</title>
<style type="text/css">

.s1{
width: 50px;
height: 20px;
padding: 4px;
border: thin;
border-radius: 5px;
border-color: aqua;
background-color: #a84781;
color: white;
font-weight: bold;

}

.s2{
height: 28px;
border: thin;
border-radius: 5px;
border-color: aqua;
background-color: #330033;
color: white;
font-weight: bold;
cursor: pointer;
}

.s2:hover{
background-color: orange;
color:black;
}

.tb{
width: 40%;
}

.sl{
width: 80px;
height: 30px;
border-radius: 4px;
color: black;
font-weight: bold;
}

.tx{
width: 90%;
height: 20px;
border-radius: 4px;
}

.txt{
border-radius: 4px;
border-color: graytext;
}

.s3{
font-style:inherit;
font-weight:bolder;
font-family:sans-serif;
color: threeddarkshadow;
cursor: pointer;
height: 25px;
}

*{
font-family:
font-size: 21px;
letter-spacing: 2px;
}


</style>
<script type="text/javascript" src="pjmscript.js"></script>
<link rel="icon" type="image/x-icon" href="../images/mura_logo.png">
<link href="css/style.css" rel="stylesheet" type="text/css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap" rel="stylesheet">
</head>

<body bgcolor="${bodyback_c }">

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

<div align="center"></div><br><br>
<form action="/JspProject/pjmboard/pjmwritePro.do" name="pjmwriteForm" method="post"
onsubmit="return WriteSave()">
<input type="hidden" name="wnum_qt" value="${wnum_qt }">
<input type="hidden" name="ref_qt" value="${ref_qt }">
<input type="hidden" name="step_qt" value="${step_qt }">
<input type="hidden" name="depth_qt" value="${depth_qt }">

<table class="tb">

<tr>
<td align="center" colspan="2" bgcolor="${value_c}">
<img src="images/qna.jpg" width="100" height="100">
<img src="images/help.jpg" width="150" height="150">
</td>

<tr>
	<td align="right" colspan="2" bgcolor="${value_c }">
		<a class="s3" href="/JspProject/pjmboard/list.do">글목록</a> 
	</td>
</tr>

<tr>
	<td class="s1">카테고리</td>
	<td width="330" align="center">
		<input type="radio" name="board" value="user"/>유저게시판
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="radio" name="board" value="qa"/>Q&A게시판
	</td>
</tr>



<tr>
	<td class="s1">제목</td>
	<td align="left">
		<c:if test="${wnum_qt==0 }">
		<input type="text" class="tx" size="50" maxlength="50" name="subject">
		</c:if>
		<c:if test="${wnum_qt!=0 }">
		<input type="text" class="tx" size="50" maxlength="50" name="subject" value="[답변]">
		</c:if>
	</td>
</tr>

<tr>
	<td class="s1">닉네임</td>
	<td width="330">
		<c:if test="${id_mem == sid }">
		"${nn_mem } "
		</c:if>
		<c:if test="${id_mem != sid }">
		비회원입니다. 로그인 후 이용해주세요.
		</c:if>
	</td>
</tr>



<tr>
	<td class="s1">내용</td>
</tr>

<tr>
	<td colspan="2">
		<textarea rows="30" cols="100%" name="content"></textarea>
	</td>
</tr>



<tr>
	<td colspan="2" align="right">
		<input type="submit" class="s2" value="글쓰기">
		<input type="reset" class="s2" value="다시작성">
		<input type="button" class="s2" value="취소" onClick="window.location='/JspProject/pjmboard/list.do'">
	</td>
</tr>

</table>
</form>
<br>
<br>

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
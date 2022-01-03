<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<!-- 참조 -->
<title>JSP 게시판 웹 사이트</title>
</head>
<body>
	<form action="loginAction.jsp" method="post">
		<table>
		<tr>
			<td width="100" align="right">아이디:</td>
			<td width="200">&nbsp;&nbsp; 
			<input type="text" name="id_mem" size="20">
			</td>
		</tr>
		
		
		<tr>
			<td width="100" align="right">비밀번호:</td>
			<td width="200">&nbsp;&nbsp; 
			<input type="password" name="pw_mem" size="20">
			</td>
		</tr>
		

		<tr>
			<td colspan="2" align="center"><input type="submit" value="로그인">&nbsp;&nbsp;
				<input type="button" value="회원가입"
				onClick="#"></td>
		</tr>
		
		
		<tr>
			<td colspan="2" align="center"><input type="submit" value="id 찾기">&nbsp;&nbsp;
				<input type="button" value="비번찾기"
				onClick="#"></td>
		</tr>
	</table>
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 탈퇴</title>
</head>
<body onload="begin()">
<form action="member.mur?cmd=deleteProc" name="myForm" method="post" onsubmit="return checkIt()">
<table width="260" border="1" align="center">
<tr>
	<td colspan="2" align="center">
	<b>회원탈퇴</b>
	</td>
</tr>	

<tr>
	<td width="150"><b>비밀번호입력:</b></td>
	<td width="110">
		<input type="password" name="pw_mem" size="15">
	</td>
</tr>

<tr>
	<td colspan="2" align="center">
	<input type="submit" value="회원탈퇴">
	<input type="button" value="취소" onClick="javascript:window.location='member.mur?cmd=login'">
	</td>
</tr>
</table>
</form>
</body>
</html>
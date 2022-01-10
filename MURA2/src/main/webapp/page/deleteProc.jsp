<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴</title>
</head>
<body>
<c:set var="result" value="${result }"/>
<div align="center">
<c:if test="${result eq 0 }">
<script type="text/javascript">
alert("비밀번호가 맞지 않습니다.");
history.go(-1);
</script>
</c:if>
<font size="5" face="궁서체">

</font>
</div>
</body>
</html>
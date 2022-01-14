<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="dao" class="board.BoardDAO" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<%
request.setCharacterEncoding("utf-8");

String pageNum = request.getParameter("pageNum");
String num = request.getParameter("mi_num");	
int result=dao.DeleteRecommand(Integer.parseInt(num));
	
		
		out.println("<script>");
		out.println("alert('비추천 완료하였습니다.')");
		out.println("window.history.back()");
		out.println("</script>");

%>
</body>
</html>
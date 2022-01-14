<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="dao" class="board.BoardDAO" />
<jsp:useBean id="recommand" class="board.RecommandDAO" />
<jsp:useBean id="vo" class="board.RecommandVO" />
<jsp:setProperty property="*" name="vo"/>
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


String loginID = (String)session.getAttribute("loginID");

%>

<%
boolean flag = recommand.recommandinsert(vo); 

int check = recommand.recommand(Integer.parseInt(num), loginID);


if(check==0) {
out.println("<script>");
out.println("alert('추천 완료하였습니다.')");
out.println("window.history.back()");
out.println("</script>");
int result = dao.UpdateRecommand(Integer.parseInt(num));

}else {
	
	out.println("<script>");
	out.println("alert('이미 추천하였습니다.')");
	out.println("window.history.back()");
	out.println("</script>");
}
	 %>	

</body>
</html>












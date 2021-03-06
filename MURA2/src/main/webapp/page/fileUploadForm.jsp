<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>File Upload Form</title>
</head>
<body>
<div align="center">
<!-- enctype="multipart/form-data" : 이 속성을 지정하면 데이터도 파일형태로 넘어가며
큰 용량의 데이터도 전송 가능하게 한다.
	
	MultipartRequest(javax.servlet.http.HttpServletRequest request, : 연결할 request 객체를 의미함
                        java.lang.String saveDirectory, : 서버 측에 저장될 경로를 의미함
                        int maxPostSize, : 최대 파일의 크기를 의미함
                        java.lang.String encoding, : 파일의 인코딩 방식을 의미함
                        FileRenamePolicy policy) : 파일의 중복처리를 위한 인자를 의미함
 -->
<form action="fileUpload.jsp" method="post" enctype="multipart/form-data">
  <table border="1">
    <tr>
      <td colspan="2" align="center">
        <h3>파일 업로드 폼</h3>
      </td>
    </tr>
    
    <tr>
      <td>올린 사람 : </td>
      <td>
        <input type="text" name="name">
      </td>
    </tr>
    
    <tr>
      <td>제목 : </td>
      <td>
        <input type="text" name="subject">
      </td>
    </tr>

    <tr>
      <td>파일명1 : </td>
      <td>
        <input type="file" name="fileName1">
      </td>
    </tr>

    <tr>
      <td>파일명2 : </td>
      <td>
        <input type="file" name="fileName2">
      </td>
    </tr>
    
    <tr>
      <td colspan="2" align="center">
        <input type="submit" value="전송">
      </td>
    </tr>
    
  </table>

</form>
</div>
</body>
</html>
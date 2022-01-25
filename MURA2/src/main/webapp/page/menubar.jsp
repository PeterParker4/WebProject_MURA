<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style type="text/css">

.tr1{
width: 100%;
height: 90px;
box-shadow: 1px;
}

.button {
width:250px;
height:60px;
margin:15px;
  padding: 5px;
  text-align: center;
  text-decoration: none;
  color: white;
  font-size: 30px;
  text-shadow: -2px 0 black, 0 2px black, 2px 0 black, 0 -2px black;
  border-radius: 0.3em;
  transition: all 0.2s ease-in-out;
  position: relative;
  overflow: hidden;
  background-color: #a84781;
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

</style>
</head>
<body>
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
		<input type="button" class="button" name="요청 / Q&A" value="요청 / Q&A" ></a></td>
		
		<td>
		<a href="/MURA2/page/recipe/recipeRanking.mur">
		<input style="margin-right: 300px" type="button" class="button" name="레시피 랭킹" value="레시피 랭킹" ></a></td>
	</tr>
	</table>
	</div>
</body>
</html>
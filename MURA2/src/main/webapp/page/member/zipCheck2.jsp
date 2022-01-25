<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>우편번호 검색</title>
<link href="../css/style.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="script.js"></script>
</head>
<body bgcolor="#FFF">
<div align="center">
<b>우편 번호 찾기</b>
<form action="zipCheck2.mur" name="zipForm" method="post">
<table>
				<tr>
					<td>동 이름 :<input name="dong" type="text"> 
					<input type="button" value="검색" onClick="dongCheck()">
					</td>
				</tr>
			</table>
			<input type="hidden" name="check" value="n">
		</form>
		<table>
			<c:if test="${check eq 'n' }">
				<c:if test="${zipcodeList.isEmpty() }">

					<tr>
						<td align="center"><br> 검색된 결과가 없습니다.</td>
					</tr>
				</c:if>

				<c:if test="${!zipcodeList.isEmpty() }">
					<tr>
						<td align="center"><br> ※※ 검색 후, 아래 우편번호를 클릭하면 자동으로
							입력됩니다.</td>
					</tr>

					<c:forEach var="vo" items="${zipcodeList}">
						<tr><td align="left">
						<a href="javascript:sendAddress2('${vo.getZipcode() }', '${vo.getSido() }', '${vo.getGugun() }', '${vo.getDong() }', '${vo.getRi() }','${vo.getBunji() }')">
									${vo.getZipcode() }&nbsp;${vo.getSido() }&nbsp;${vo.getGugun() }&nbsp;
									${vo.getDong() }&nbsp;${vo.getRi() }&nbsp;${vo.getBunji() } </a><br>
							</td>
						</tr>
					</c:forEach>
				</c:if>
			</c:if>

			<tr>
				<td align="center"><a href="javascript:self.close()">닫기</a></td>
			</tr>
		</table>
	</div>
</body>
</html>
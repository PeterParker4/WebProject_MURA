<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${check == 1}">
<meta http-equiv="Refresh" content="0;url=/MURA2/page/recipe/recipeList.mur?pageNum=${pageNum}">
</c:if>

<c:if test="${check == 0}">
회원정보가 일치하지 않습니다. 로그인 후 다시 시도하세요.<br>
<input type="button" class="s2" value="돌아가기"
onclick="javascript:history.go(-1)">
</c:if>

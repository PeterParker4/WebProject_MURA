<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${check == 1}">
<meta http-equiv="Refresh" content="0;url=/MURA2/page/recipe/recipeContent.mur?num=${num}&pageNum=${pageNum}&thumb_li=${thumb_li}">
</c:if>

<c:if test="${check == 0}">
댓글 삭제에 실패했습니다.<br>
<a href="javascript:history.go(-1)">[돌아가기]</a>
</c:if>
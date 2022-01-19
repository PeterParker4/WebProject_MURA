<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
  <c:when test="${check == 1}">
    <script type="text/javascript">
	alert("이미 추천한 게시글입니다.");
	location.href = document.referrer;
	</script>
  </c:when>

  <c:otherwise>
    <script type="text/javascript">
	alert("추천을 완료하였습니다.");
	location.href = document.location.href="/MURA2/page/recipe/recipeRecommendProc.mur?num=${num}&pageNum=${pageNum}&board_num=${board_num}";
	</script>
  </c:otherwise>
</c:choose>

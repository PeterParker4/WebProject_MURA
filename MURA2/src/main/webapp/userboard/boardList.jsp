<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
    <title>Document</title>
    <style>
        *{margin:0;padding:0}
        .allWrap{width: 800px;margin:0 auto;}
        .tabBox{margin:20px 0}
        .tab-link{width: 47%;display: inline-block;padding:10px;text-align: center;background-color:#929090;border-radius: 20px;color:#fff;cursor: pointer;
        }
        .tab-link.current{
            background-color: #de4c4c;
            font-weight: 600;
        }
        .tab-content{
            display: none;
        }
        .tab-content.current{
            display: block;
            width: 100%;
            height: 500px;
            background-color:#d5d8d7;
            font-size: 15px;
            text-align: center;
        }
        
    </style>
<script type="text/javascript">
function check() {
	if(document.find_frm.find_box1.value==""){
		alert("검색어를 입력해 주세요");
		return false;
	}
  }

  function frm_sub(i) {
	i_frm.action="/MURA2/userboard/boardList.mur?pageNum="+i;
	i_frm.submit();
  }

</script>    
    
</head>
<body>

<div align="center"><b>요청 / Q&A 게시판</b>
<hr>

  <div class="allWrap">     
	<div class="tabBox">
          <p class="tab-link current" data-tab="tab-1"><span><img src="http://mmctxt.com/link/img/icon01.png" alt="icon"></span> 요청게시판</p>
          <p class="tab-link"  data-tab="tab-2" onclick="window.location='/MURA2/userboard/qaboardList.mur'"><span><img src="http://mmctxt.com/link/img/icon02.png" alt="icon"></span> Q&A 게시판</p>
    </div>
	
	<div  id="tab-1" class="tab-content current">
		<h1>요청 게시판</h1><br>
	
	<div align="center"><b>글목록(전체 글:${userCount} )</b><br>
	
	<c:if test="${userCount == 0 }">
	<table width="700" border="1" cellpadding="0" cellspacing="0">
	  <tr align="center">
	    <td>게시판에 저장된 글이 없습니다.</td>
	  </tr>
	</table>
	</c:if>
	
	<c:if test="${userCount > 0 }">
	<table width="700" border="1" cellpadding="0" cellspacing="0" align="center">
	
		<tr height="10">
		  <td align="center" width="100">글번호</td>			
		  <td align="center" width="300">제목</td>
		  <td align="center" width="100">작성자</td>
		  <td align="center" width="150">작성일</td>
		  <td align="center" width="50">조회수</td>
		</tr>
	
	<c:forEach var="userBoardArticle" items="${userBoardArticleList }">
	
	<tr height="30">
		<td align="center" width="100"><c:out value="${number1 }"/></td>
		<c:set var="number" value="${number1 - 1 }"> </c:set>
	
		<td width="300">	
		<a href="/MURA2/userboard/content.mur?num=${userBoardArticle.wnum_ut}&pageNum=${currentPage1}">
		${userBoardArticle.wsubject_ut}</a>
		<c:if test="${userBoardArticle.readcount_ut >= 20 }">
			<img alt="" src="images/hot.png" border="0" height="16">
			</c:if>
		</td>	
	
		<td align="center" width="100">
		${userBoardArticle.nn_mem }
		</td>
		<td align="center" width="150">
		${userBoardArticle.date_ut }
		</td>		
		<td align="center" width="50">
		${userBoardArticle.readcount_ut }
		</td>
		
	</tr>
	</c:forEach>
	</table>
	</c:if>	
	
	<c:if test="${userCount > 0 }">
	 <c:set var="imsi1" value="${userCount % pageSize1 == 0 ? 0 : 1 }"/>
	 <c:set var="pageCount1" value="${userCount / pageSize1 + imsi1 }"/>
	 <c:set var="pageBlock1" value="${3}"/>
	 <fmt:parseNumber var="result1" value="${(currentPage1 - 1) / pageBlock1 }" integerOnly="true"/>
	 
	 <c:set var="startPage1" value="${result1 * pageBlock1 + 1 }"/>
	 <c:set var="endPage1" value="${startPage1 + pageBlock1 - 1 }"/>
	 
	 <c:if test="${endPage1 > pageCount1 }">
	 	<c:set var="endPage1" value="${pageCount1 }"/>
	 </c:if>
	 
	 <c:if test="${startPage1 > pageBlock1 }">
	 	<a href="/MURA2/userboard/boardList.mur?pageNum=${startPage1 - pageBlock1 }" onclick="frm_sub(${startPage1 - pageBlock1})">[이전]</a>
	 </c:if>
	 
	 <c:forEach var="i" begin="${startPage1 }" end="${endPage1 }">
	 	<a href="/MURA2/userboard/boardList.mur?pageNum=${i}" onclick="frm_sub(${i})">[${i}]</a>
	 </c:forEach>
	 
	 <c:if test="${endPage1 < pageCount1 }">
		<a href="/MURA2/userboard/boardList.mur?pageNum=${startPage1 + pageBlock1 }" onclick="frm_sub(${startPage1 + pageBlock1})">[다음]</a> 
	 </c:if>
	</c:if>
	<br><br>
	
	<form method="post" name="i_frm">
  	<input type="hidden" name="find_box1" value="${find_box1 }">
  	<input type="hidden" name="find1" value="${find1 }">
	</form>
	
	<form action="/MURA2/userboard/boardList.mur" method="post" name="find_frm"
onsubmit="return check()">

	<select name="find1" size="1">
  	<option value="nn_mem">작성자</option>
  	<option value="wsubject_ut">제목</option>
  	<option value="wcontent_ut">내용</option>
  </select>
  &nbsp;
  <input type="text" name="find_box1">
  &nbsp;
  <input type="submit" value="검색">

</form>
	
	</div>

	</div>
	
	<div  id="tab-2" class="tab-content">

	</div>
	<tr>	
	<td colspan="2" align="right">
		<input type="button" value="목록" onclick="window.location='/MURA2/userboard/boardList.mur'">
		<input type="button" value="작성하기" onclick="window.location='/MURA2/userboard/writeForm.mur'">
		<input type="reset" value="취소">
	</td>
	</tr>
	
	<script>
        $('.tab-link').click(function () {
        var tab_id = $(this).attr('data-tab');

        $('.tab-link').removeClass('current');
        $('.tab-content').removeClass('current');

        $(this).addClass('current');
        $("#" + tab_id).addClass('current');

    });
	</script>
</body>
</html>
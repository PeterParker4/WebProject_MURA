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
    <title>MURA :: Q&A 게시판</title>
    <style>
        *{margin:0;padding:0}
        .allWrap{width: 800px;margin:0 auto;}
        .tabBox{margin:20px 0}
        .tab-link{width: 47%;display: inline-block;padding:10px;text-align: center;background-color:#929090;border-radius: 20px;color:#fff;cursor: pointer;
        }
        .tab-link.current{
            background-color: #a84781;
            font-weight: 600;
        }
        .tab-content{
            display: none;
        }
        .tab-content.current{
            display: block;
            width: 100%;
            height: 500px;
            background-color: white;
            font-size: 15px;
            text-align: center;
        }
        
    </style>
<script type="text/javascript">
function check() {
	if(document.find_frm.find_box.value==""){
		alert("검색어를 입력해 주세요");
		return false;
	}
  }

  function frm_sub(i) {
	i_frm.action="/MURA2/userboard/qaboardList.mur?pageNum="+i;
	i_frm.submit();
  }

</script>    
    
</head>
<body>

<div align="center">

<div class="logo">
	  <a href="/MURA2/page/index.jsp"> 
	  <img src="../page/images/topLogo.jpg" width="1194" height="230" border="0" alt=""></a>
</div>

<hr>

  <div class="allWrap">     
	<div class="tabBox">
          <p class="tab-link" data-tab="tab-1" onclick="window.location='/MURA2/userboard/boardList.mur'"><span><img src="http://mmctxt.com/link/img/icon01.png" alt="icon"></span> 요청게시판</p>
          <p class="tab-link current"  data-tab="tab-2"><span><img src="http://mmctxt.com/link/img/icon02.png" alt="icon"></span> Q&A 게시판</p>
    </div>
	
	<div  id="tab-1" class="tab-content">

	</div>
	
	<div  id="tab-2" class="tab-content current">
			<h1>Q&A 게시판</h1><br>
	
	<div align="center"><b>글목록(전체 글:${qaCount} )</b><br>
	
	<c:if test="${qaCount == 0 }">
	<table width="700" border="1" cellpadding="0" cellspacing="0">
	  <tr align="center">
	    <td>게시판에 저장된 글이 없습니다.</td>
	  </tr>
	</table>
	</c:if>
	
	<c:if test="${qaCount > 0 }">
	<table width="700" border="1" cellpadding="0" cellspacing="0" align="center">
	
		<tr height="10">
		  <td align="center" width="100">글번호</td>			
		  <td align="center" width="300">제목</td>
		  <td align="center" width="100">작성자</td>
		  <td align="center" width="150">작성일</td>
		  <td align="center" width="50">조회수</td>
		</tr>
	
	<c:forEach var="qaBoardArticle" items="${qaBoardArticleList }">
	
	<tr height="30">
		<td align="center" width="100"><c:out value="${number }"/></td>
		<c:set var="number" value="${number - 1 }"> </c:set>
	
		<td width="300">
		
		<c:if test="${qaBoardArticle.depth_qt > 0}">
		<img src="images/level.gif" width="${5 * qaBoardArticle.depth_qt }" height="16">
		<img src="images/reply.png">		
		</c:if>
		
		<c:if test="${qaBoardArticle.depth_qt == 0 }">
		<img src="images/level.gif" width="${5 * qaBoardArticle.depth_qt }" height="16">
		</c:if>
			
		<a href="/MURA2/userboard/content.mur?num=${qaBoardArticle.idx_qt}&pageNum=${currentPage}">
		${qaBoardArticle.wsubject_qt}</a>
			<c:if test="${qaBoardArticle.readcount_qt >= 20 }">
			<img alt="" src="images/hot.png" border="0" height="16">
			</c:if>
		</td>	
	
		<td align="center" width="100">
		${qaBoardArticle.nn_mem }
		</td>
		<td align="center" width="150">
		${qaBoardArticle.date_qt }
		</td>		
		<td align="center" width="50">
		${qaBoardArticle.readcount_qt }
		</td>
		
	</tr>
	</c:forEach>
	</table>
	</c:if>	
	
	<c:if test="${qaCount > 0 }">
	 <c:set var="imsi" value="${qaCount % pageSize == 0 ? 0 : 1 }"/>
	 <c:set var="pageCount" value="${qaCount / pageSize + imsi }"/>
	 <c:set var="pageBlock" value="${3}"/>
	 <fmt:parseNumber var="result" value="${(currentPage - 1) / pageBlock }" integerOnly="true"/>
	 
	 <c:set var="startPage" value="${result * pageBlock + 1 }"/>
	 <c:set var="endPage" value="${startPage + pageBlock - 1 }"/>
	 
	 <c:if test="${endPage > pageCount }">
	 	<c:set var="endPage" value="${pageCount }"/>
	 </c:if>
	 
	 <c:if test="${startPage > pageBlock }">
	 	<a href="/MURA2/userboard/qaboardList.mur?pageNum=${startPage - pageBlock }" onclick="frm_sub(${startPage - pageBlock})">[이전]</a>
	 </c:if>
	 
	 <c:forEach var="i" begin="${startPage }" end="${endPage }">
	 	<a href="/MURA2/userboard/qaboardList.mur?pageNum=${i}" onclick="frm_sub(${i})">[${i}]</a>
	 </c:forEach>
	 
	 <c:if test="${endPage < pageCount }">
		<a href="/MURA2/userboard/qaboardList.mur?pageNum=${startPage + pageBlock }" onclick="frm_sub(${startPage + pageBlock})">[다음]</a> 
	 </c:if>
	</c:if>
	<br><br>
	
	<form method="post" name="i_frm">
  	<input type="hidden" name="find_box" value="${find_box }">
  	<input type="hidden" name="find" value="${find }">
	</form>
	
	<form action="/MURA2/userboard/qaboardList.mur" method="post" name="find_frm"
onsubmit="return check()">

  <select name="find" size="1">
  	<option value="nn_mem">작성자</option>
  	<option value="wsubject_ut">제목</option>
  	<option value="wcontent_ut">내용</option>
  </select>
  &nbsp;
  <input type="text" name="find_box">
  &nbsp;
  <input type="submit" value="검색">

</form>
	

	</div>
	
	</div>
	
	</div>
	<tr>	
	<td colspan="2" align="right">
		<input type="button" value="목록" onclick="window.location='/MURA2/userboard/qaboardList.mur'">
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
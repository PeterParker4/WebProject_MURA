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
	if(document.find_frm.find_box2.value==""){
		alert("검색어를 입력해 주세요");
		return false;
	}
  }

  function frm_sub(i2) {
	i2_frm.action="/MURA2/userboard/qaboardList.mur?pageNum="+i2;
	i2_frm.submit();
  }

</script>    
    
</head>
<body>

<div align="center"><b>요청 / Q&A 게시판</b>
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
		<td align="center" width="100"><c:out value="${number2 }"/></td>
		<c:set var="number2" value="${number2 - 1 }"> </c:set>
	
		<td width="300">
		
		<c:if test="${qaBoardArticle.depth_qt > 0}">
		<img src="images/level.gif" width="${5 * qaBoardArticle.depth_qt }" height="16">
		<img src="images/reply.png">		
		</c:if>
		
		<c:if test="${qaBoardArticle.depth_qt == 0 }">
		<img src="images/level.gif" width="${5 * qaBoardArticle.depth_qt }" height="16">
		</c:if>
			
		<a href="/MURA2/userboard/content.mur?num=${qaBoardArticle.wnum_qt}&pageNum=${currentPage2}">
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
	 <c:set var="imsi2" value="${qaCount % pageSize2 == 0 ? 0 : 1 }"/>
	 <c:set var="pageCount2" value="${qaCount / pageSize2 + imsi2 }"/>
	 <c:set var="pageBlock2" value="${3}"/>
	 <fmt:parseNumber var="result2" value="${(currentPage2 - 1) / pageBlock2 }" integerOnly="true"/>
	 
	 <c:set var="startPage2" value="${result2 * pageBlock2 + 1 }"/>
	 <c:set var="endPage2" value="${startPage2 + pageBlock2 - 1 }"/>
	 
	 <c:if test="${endPage2 > pageCount2 }">
	 	<c:set var="endPage2" value="${pageCount2 }"/>
	 </c:if>
	 
	 <c:if test="${startPage2 > pageBlock2 }">
	 	<a href="/MURA2/userboard/qaboardList.mur?pageNum=${startPage2 - pageBlock2 }" onclick="frm_sub(${startPage2 - pageBlock2})">[이전]</a>
	 </c:if>
	 
	 <c:forEach var="i2" begin="${startPage2 }" end="${endPage2 }">
	 	<a href="/MURA2/userboard/qaboardList.mur?pageNum=${i2}" onclick="frm_sub(${i2})">[${i2}]</a>
	 </c:forEach>
	 
	 <c:if test="${endPage2 < pageCount2 }">
		<a href="/MURA2/userboard/qaboardList.mur?pageNum=${startPage2 + pageBlock2 }" onclick="frm_sub(${startPage2 + pageBlock2})">[다음]</a> 
	 </c:if>
	</c:if>
	<br><br>
	
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
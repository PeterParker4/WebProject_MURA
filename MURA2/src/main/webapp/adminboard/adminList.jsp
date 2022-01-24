<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<title>MURA :: 전체유저정보</title>
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
        
    .s2{
		height: 25px;
		border: thin;
		border-radius: 5px;
		border-color: aqua;
		background-color: #330033;
		color: white;
		font-weight: bold;
		cursor: pointer;
		}
	
	.s2:hover{
	background-color: orange;
	color:black;
	}

</style>

    
</head>
<body>

<div align="center">

<div class="logo">
	  <a href="/MURA2/page/index.jsp"> 
	  <img src="../page/images/topLogo.jpg" width="1194" height="230" border="0" alt=""></a>
</div>

<hr>

  <div class="allWrap">     
	
		<h1>전체유저정보</h1><br>
	
	<div align="center"><b>회원목록(전체회원수:)</b><br><br>
	
	<form action="/MURA2/adminboard/adminList.mur" method="post" name="find_frm" onsubmit="return check()">
	  회원 ID 입력<br>
	  <input type="text" name="id_mem">
	  &nbsp;
	  <input type="submit" value="검색">
	</form>
	
	<c:if test="${userCount == 0 }">
	<table width="700" border="1" cellpadding="0" cellspacing="0">
	  <tr align="center">
	    <td>저장된 회원정보가 없습니다.</td>
	  </tr>
	</table>
	</c:if>
	</div>
	
<%-- 	<c:if test="${userCount > 0 }"> --%>
	${memberInfo.id_mem} 님의 회원정보입니다.<br>
	<table width="1300" border="1" cellpadding="0" cellspacing="0">
	
	<tr height="30">
		<td align="center" width="100"></td>

		<td align="center" width="100">
		${memberInfo.id_mem }
		</td>
		<td align="center" width="100">
		${memberInfo.nn_mem }
		</td>		
		<td align="center" width="100">
		${memberInfo.pw_mem }
		</td>
		<td align="center" width="100">
		${memberInfo.name_mem }
		</td>
		<td align="center" width="100">
		${memberInfo.email_mem }
		</td>		
		<td align="center" width="100">
		${memberInfo.gender_mem }
		</td>
		<td align="center" width="100">
		${memberInfo.tel_mem }
		</td>
		<td align="center" width="100">
		${memberInfo.zipcode_mem }
		</td>		
		<td align="center" width="100">
		${memberInfo.zc1_mem }
		</td>
		<td align="center" width="100">
		${memberInfo.zc2_mem }
		</td>
		<td align="center" width="100">
		${memberInfo.join_mem }
		</td>		
		<td align="center" width="100">
		${memberInfo.date_mem }
		</td>
		
</tr>
	</table>
<%-- 	</c:if> --%>


	</div>

	</div>
	

	<table>
	<tr>	
	<td colspan="2" align="right">
		<input type="button" class="s2" value=" 목록 " onclick="window.location='/MURA2/adminboard/adminList.mur'">
		<input type="reset" class="s2" value=" 취소 ">
	</td>
	</tr>
	</table>
	</div>
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
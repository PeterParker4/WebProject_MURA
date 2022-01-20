<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<style type="text/css">


body {
  background-image:#34495e;
}

.joinForm {
  width:400px;
  height:400px;
  padding: 30px, 20px;
  background-color:#FFFFFF;
  text-align:center;
  border-radius: 15px;
}

.joinForm h2 {
  text-align: center;
  margin: 30px;
}

.textForm {
  border-bottom: 2px solid #adadad;
  margin: 20px;
  padding: 10px 5px;
}


.id {
  width: 100%;
  border:none;
  outline:none;
  color: #636e72;
  font-size:16px;
  height:25px;
  background: none;
}

.btn {
  position:relative;
  left:40%;
  transform: translateX(-50%);
  margin-bottom: 40px;
  width:80%;
  height:40px;
  background: linear-gradient(125deg, #a84781, yellow, green);
  background-position: left;
  background-size: 200%;
  color:white;
  font-weight: bold;
  border:none;
  cursor:pointer;
  transition: 0.4s;
  display:inline;
}

.btn:hover {
  background-position: right;
}
.btn2{
background-color:#fff;
margin:4px;
width:40%;
height:50%;
border-radius: 10px;
transition: 0.8s;
display:inline;
cursor:pointer;
}

.btn2:hover{
color:#fff;
background-color: black;
}

</style>
</head>
<script type="text/javascript" src="script.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<link rel="icon" type="image/x-icon" href="images/mura_logo.png">
<link href="css/style.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<body>
	<!-- 상단 로고 -->
	<div class="logo">
	  <a href="/MURA2/page/index.jsp"> 
	  <img src="images/topLogo.jpg" width="1194" height="230" border="0" alt=""></a>
	</div>



<div align="center">	
<form action="cog.jsp" method="POST" class="joinForm" onsubmit="DoJoinForm__submit(this); return false;">
                     
                                                                        
      
      
      <h5>MURA에 오신 것을 환영합니다. ^_^<br>가입해서 많은 서비스를 이용하세요 ! </h5>
      
      <div class="textForm">
        <input name="loginId" type="text" class="id" placeholder="아이디">
        <input type="button" value="중복확인" class="btn2" onclick="">
      </div>
      <div class="textForm">
        <input name="nickname" type="text" class="id" placeholder="닉네임">
      </div>
      <div class="textForm">
        <input name="loginPw" type="password" class="id" placeholder="비밀번호">
      </div>
       <div class="textForm">
        <input name="loginPwConfirm" type="password" class="id" placeholder="비밀번호 확인">
      </div>
      <div class="textForm">
        <input name="name" type="text" class="id" placeholder="이름">
      </div>
       <div class="textForm">
        <input name="email" type="text" class="id" placeholder="이메일">
      </div>
      
      <div class="textForm">
        <div class="id">성별 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
        <label><input type="checkbox" name="gender" value="남자" checked="true">남자</label>
        <label><input type="checkbox" value="여자" checked="true">여자</label>
        </div>
      </div>
      <div class="textForm">
        <input name="cellphoneNo" type="text" class="id" placeholder="전화번호  ( - ) 빼고 입력">
      </div>
      
      <div class="textForm">
        <input name="zipcode" type="text" class="id" placeholder="우편번호">
        <input type="button" class="btn2" value="찾기" onclick="">
      </div>
      
      <div class="textForm">
        <input name="address1" type="text" class="id" placeholder="집주소">
      </div>
      
      <div class="textForm">
        <input name="address2" type="text" class="id" placeholder="상세주소">
      </div>
      
      
      
      <input type="submit" class="btn" value="J O I N"/>
    </form>
</div>	

</body>
</html>
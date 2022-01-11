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
<form action="member.mur?cmd=signinProc" method="post" class="joinForm" name="signinForm">
                     
                                                                        
      <h2>회원가입</h2>
      
      <div class="textForm">
        <input name="id_mem" type="text" class="id" placeholder="아이디">
        <input type="button" value="중복확인" class="btn2" onclick="idCheck(this.form.id_mem.value)">
      </div>
      <div class="textForm">
        <input name="nn_mem" type="text" class="id" placeholder="닉네임">
      </div>
      <div class="textForm">
        <input name="pw_mem" type="password" class="id" placeholder="비밀번호">
      </div>
       <div class="textForm">
        <input name="repass_mem" type="password" class="id" placeholder="비밀번호 확인">
      </div>
      <div class="textForm">
        <input name="name_mem" type="text" class="id" placeholder="이름">
      </div>
       <div class="textForm">
        <input name="email_mem" type="text" class="id" placeholder="이메일">
      </div>
      
       <div class="textForm">
         <div class="id">성별 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
        <select name="gender_mem">
        <option value="남자">남자</option>
        <option value="여자">여자</option>
        </select>
        </div> 
      </div> 
      <div class="textForm">
        <input name="tel_mem" type="text" class="id" placeholder="전화번호  ( - ) 빼고 입력">
      </div>
      
      <div class="textForm">
        <input name="zipcode_mem" type="text" class="id" placeholder="우편번호">
        <input type="button" class="btn2" value="찾기" onclick="zipCheck()">
      </div>
      
      <div class="textForm">
        <input name="zc1_mem" type="text" class="id" placeholder="집주소">
      </div>
      
      <div class="textForm">
        <input name="zc2_mem" type="text" class="id" placeholder="상세주소">
      </div>
      
      
      <!-- submit과  button의 차이 -->
      <input type="button" class="btn" value="J O I N" onClick="inputCheck()">&nbsp;&nbsp;
    </form>
</div>	

</body>
</html>
 /* 검색 토글 */

function searchToggle(obj, evt) {
	var container = $(obj).closest('.search-wrapper');
	if (!container.hasClass('active')) {
		container.addClass('active');
		evt.preventDefault();
	}
	else if (container.hasClass('active') && $(obj).closest('.input-holder').length == 0) {
		container.removeClass('active');
		// clear input
		container.find('.search-input').val('');
	}
	
}

function idCheck(id_mem) {
	if(id_mem=="") {
		alert("아이디를 입력해 주세요.")
		document.signinForm.id.focus(); 
	}else {
		url="member.mur?cmd=idCheck&id_mem=" + id_mem;
		window.open(url, "post", "width=300, height=150");
	}
}

// 회원가입 alret
function inputCheck() {
	if(document.signinForm.id_mem.value=="") {
		alert("아이디를 입력해주세요.");
		document.signinForm.id_mem.focus();
		return;
	}
	if(document.signinForm.idDuplicatin.value != "idCheck") {
		alert("아이디 중복체크를 해주세요.");
		document.signinForm.id_mem.focus();
		return;
	}
	if(document.signinForm.nn_mem.value=="") {
		alert("닉네임을 입력해주세요.");
		document.signinForm.nn_mem.focus();
		return;
	}
	if(document.signinForm.pw_mem.value=="") {
		alert("비밀번호를 입력해주세요.");
		document.signinForm.pw_mem.focus();
		return;
	}
	if(document.signinForm.repass_mem.value=="") {
		alert("비밀번호를 확인해주세요.");
		document.signinForm.repass_mem.focus();
		return;
	}
	if(document.signinForm.pw_mem.value!=document.signinForm.repass_mem.value) {
		alert("비밀번호가 일치하지 않습니다.");
		document.signinForm.repass_mem.focus();
		return;
	}
	if(document.signinForm.name_mem.value=="") {
		alert("이름을 입력해주세요.");
		document.signinForm.name_mem.focus();
		return;
	}
	if(document.signinForm.email_mem.value=="") {
		alert("이메일을 입력해주세요.");
		document.signinForm.email_mem.focus();
		return;
	}

	var str=document.signinForm.email_mem.value;
	var atPos=str.indexOf('@');
	var atLastPos=str.lastIndexOf('@');
	var dotPos=str.indexOf('.');
	var spacePos=str.indexOf(' ');
	var commaPos=str.indexOf(',');
	var eMailSize=str.length;
	
	if(atPos > 1 && atPos == atLastPos && dotPos > 3 && spacePos == -1 && commaPos == -1 && atPos + 1 < dotPos && dotPos + 1 < eMailSize);
	else {
		alert('E_mail 주소 형식을 잘못 입력하셨습니다. \n\r 다시 입력해주세요.')
		document.signinForm.email_mem.focus();
		return;
	}
	
	if(document.signinForm.gender_mem.value=="") {
		alert("성별을 체크해주세요.");
		document.signinForm.gender_mem.focus();
		return;
	}
	
	if(document.signinForm.tel_mem.value=="") {
		alert("전화번호를 입력해주세요.");
		document.signinForm.tel_mem.focus();
		return;
	}
	
	
	if(document.signinForm.zipcode_mem.value=="") {
		alert("우편번호를 입력해 주세요.");
		document.signinForm.zipcode_mem.focus();
		return;
	}
	
	if(document.signinForm.zc1_mem.value=="") {
		alert("주소를 입력해 주세요.");
		document.signinForm.zc1_mem.focus();
		return;
	}
	
	if(document.signinForm.zc2_mem.value=="") {
		alert("상세 주소를 입력해 주세요.");
		document.signinForm.zc2_mem.focus();
		return;
	}
	
	document.signinForm.submit();
	
}

function zipCheck() {
	url="zipCheck.jsp?check=y" 
	window.open(url, "post", "toolbar=no, width=500, height=300, directories=no, status=yes, scrollbars=yes, menubar=no");
}

function sendAddress(zipcode, sido, gugun, dong, ri, bunji){
	var address=sido+" "+gugun+" "+dong+" "+ri+" "+bunji;
	opener.document.signinForm.zipcode_mem.value=zipcode;
	opener.document.signinForm.zc1_mem.value=address;
}

function dongCheck() {

	if(document.zipForm.dong.value == "") {
		alert("동 이름을 입력해 주세요.")
		document.zipForm.dong.focus();
		return; 
	}
	document.zipForm.submit();
}

function backToLogin() {
	document.login.submit();
	// 로그인 화면으로 돌아가게 구현
}



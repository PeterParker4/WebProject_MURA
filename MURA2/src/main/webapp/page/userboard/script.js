$(document).ready(function(){
	
	$('ul.tabs li').click(function(){
		var tab_id = $(this).attr('data-tab');

		$('ul.tabs li').removeClass('current');
		$('.tab-content').removeClass('current');

		$(this).addClass('current');
		$("#"+tab_id).addClass('current');
	})

});

function writeSave() {
	
	if(document.userWriteForm.wsubject_ut.value==""){
		alert("제목을 입력하세요.");
		document.writeForm.wsubject_ut.focus();
		return false;
	}
	
	if(document.userWriteForm.wcontent_ut.value==""){
		alert("내용을 입력하세요.");
		document.writeForm.wcontent_ut.focus();
		return false;
	}
	
}

function qaWriteSave() {
	
	if(document.qaWriteForm.wsubject_qt.value==""){
		alert("제목을 입력하세요.");
		document.writeForm.wsubject_ut.focus();
		return false;
	}
	
	if(document.qaWriteForm.wcontent_qt.value==""){
		alert("내용을 입력하세요.");
		document.writeForm.wcontent_ut.focus();
		return false;
	}
	
}

function check(){
	
	if(document.userWriteForm)
	
	return false;
	
}




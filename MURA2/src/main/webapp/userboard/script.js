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
	
	if(document.writeForm.wsubject_ut.value==""){
		alert("제목을 입력하세요.");
		document.writeForm.subject.focus();
		return false;
	}
	
	if(document.writeForm.wcontent_ut.value==""){
		alert("내용을 입력하세요.");
		document.writeForm.content.focus();
		return false;
	}
	
}

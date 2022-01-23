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

 /* 검색 체크 */
function check() {
	if(document.find_frm.search-input.value == "null") {
		alert("검색어를 입력하세요.");
		return false;
	}
}
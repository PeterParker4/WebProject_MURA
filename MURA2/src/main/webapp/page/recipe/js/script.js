function writeSave() {
	if (document.recipeWriteForm.category_li.value == "") {
		alert("카테고리를 입력하세요.");
		document.recipeWriteForm.category_li.focus();
		return false;
	}

	if (document.recipeWriteForm.wsubject_li.value == "") {
		alert("제목을 입력하세요.");
		document.recipeWriteForm.wsubject_li.focus();
		return false;
	}
	
	if (document.recipeWriteForm.tag_li.value == "") {
		alert("재료를 입력하세요.");
		document.recipeWriteForm.tag_li.focus();
		return false;
	}
	
	if (document.recipeWriteForm.wcontent_li.value == "") {
		alert("내용을 입력하세요.");
		document.recipeWriteForm.wcontent_li.focus();
		return false;
	}

}

function deleteSave() {
	if(document.delForm.pass.value == "") {
		alert("비밀번호를 입력하세요.");
		document.delForm.pass.focus();
		return false;
	}
}
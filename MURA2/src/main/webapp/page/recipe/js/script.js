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

function shareTwitter(sendSubject, num, pageNum) {
    var sendSubject = sendSubject; // 전달할 텍스트
    /*var sendUrl = "/MURA2/page/recipe/recipeContent.mur?num="+ num + "&pageNum=" + pageNum; // 전달할 URL*/ 
    var sendUrl = "trello.com/b/gZWYkU7Y/프로젝트-관리mura"; // 전달할 URL
	window.open("https://twitter.com/intent/tweet?text=" + sendSubject + "&url=" + sendUrl);
}

function shareFacebook(num, pageNum) {
    /*var sendUrl = "/MURA2/page/recipe/recipeContent.mur?num="+ num + "&pageNum=" + pageNum; // 전달할 URL
	window.open("http://www.facebook.com/sharer/sharer.php?u=" + sendUrl);*/
    var sendUrl = "trello.com/b/gZWYkU7Y/프로젝트-관리mura"; // 전달할 URL
	window.open("http://www.facebook.com/sharer/sharer.php?u=" + sendUrl);
}

function shareKakao(sendSubject, num, pageNum) {
 
  // 사용할 앱의 JavaScript 키 설정
  Kakao.init('9a7922cc0be8e065f26667a91ec30695'); //카카오에서 발급받은 API키
 
  // 카카오링크 버튼 생성
  Kakao.Link.createDefaultButton({
    container: '#btnKakao', // 카카오공유버튼ID
    objectType: 'feed',
    content: {
      title: sendSubject, // 보여질 제목
      description: "MURA :: 당신의 식탁을 더 맛있게", // 보여질 설명
      imageUrl: "devpad.tistory.com/", // 콘텐츠 URL
      link: {
         mobileWebUrl: "devpad.tistory.com/",
         webUrl: "devpad.tistory.com/"
      }
    }
  });
}
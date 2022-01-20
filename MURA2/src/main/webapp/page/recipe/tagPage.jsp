<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>태그 추가삭제하기</title>
    <link rel="stylesheet" type="text/css" href="css/tag_create.css">
    <script type="module" src="js/tag_create.js"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>

    <div style="margin-top:40px; margin-left:40px;" class="content">
        <div style="display: flex;">
            <h3 style="width: 150px; margin-right:30px;">재료 태그 입력<h3/>
            <input type="text" id="tag" size="20" placeholder="엔터 버튼 클릭시 태그 입력" />
        </div>

        <ul id="tag-list">
        </ul>
    </div>

</body>
</html>

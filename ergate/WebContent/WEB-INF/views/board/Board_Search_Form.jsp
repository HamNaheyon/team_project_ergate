<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>board_search_form</title>

	<link rel = "stylesheet" type = "text/css" href = "${contextPath}/resources/css/Board_Search_Form_Style.css">

</head>
<body>
    <div class="ncontainer">
        <div class="nav-empty"></div>
        <div class="nav-search">
            <form action="list" method="GET" class="text-center" id="ncontainer">
				<div class="searchcategory">
					<input type="hidden" name="type" value="${pagination.boardStyle}">
					<select name="sk" class="form-control" style="width: 100px; display: inline-block;">
						<option value="title">글제목</option>
						<option value="content">내용</option>
						<option value="titcont">제목+내용</option>
						<option value="writer">작성자</option>
					</select>
				</div>
                <div class="iparea">
                    <input type = "search" name = "sv">
                </div>
                <div class="btnarea">
                    <button id="searchbtn">
                        <img src = "${contextPath}/resources/img/MagnifyingGlass_white.png">
                    </button>
                </div>
            </form>
        </div>
        <div class="nav-empty"></div>
    </div>
</body>
</html>
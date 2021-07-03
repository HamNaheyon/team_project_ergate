<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>posting</title>

	<link rel = "stylesheet" type = "text/css" href = "${contextPath}/resources/css/posting_style.css">
	<jsp:include page="../common/header.jsp"/>
</head>
<body>

	<jsp:include page="Board_Search_Form.jsp"/>
	<jsp:include page="Board_SideMenu.jsp"/>
	
	
    
		<form action="${contextPath}/board2/insert?type=${param.type}" method="post" 
			  enctype="multipart/form-data" role="form" onsubmit="return boardValidate();">
    <div class="pcontainer">
   
        <div class="postingsc">
            <h3>게시글 작성</h3>
        </div>
        <div class="pcategory cborder">
            <div class="label">
                <label for="category">카테고리*</label>
            </div>
            <div class="select">
                <select id="category" name="category">
                    <option>웹 개발자</option>
                    <option>앱 개발자</option>
                </select>
            </div>
        </div>
        <div class="title cborder">
            <div class="label">
                <label for="category">제목*</label>
            </div>
            <div class="select">
                <input name="category" id="category" type="text" placeholder = "제목을 입력해주세요">  
            </div>
        </div>
        <div class="contents cborder">
            <div class="label">
                <label for="contents">내용*</label>
            </div>
            <div class="cbselect">
                <input name="contents" id="contents" type="text" placeholder = "내용을 입력해주세요">
            </div>
        </div>
        <div class="uploadfile cborder">
            <div class="label">
                <label for="uploadfile">첨부파일</label>
            </div>
            <div class="select">
                <input name="uploadfile" id="uploadfile" type="file">
                <!-- <img src="images/file.png" style="width:100px;" border="0" onclick='document.all.uploadfile.click(); document.all.uploadfile2.value=document.all.uploadfile.value'> -->
                <!-- <input name="uploadfile2" id="uploadfile2" type="text" style="display:none;"> -->
            </div>
        </div>
        <div class="uploadfile cborder">
            <div class="label">
                <label for="thumbnail">썸네일</label>
            </div>
            <div class="select">
                <input name="uploadfile" id="uploadfile" type="file">
                <!-- <img src="images/file.png" style="width:100px;" border="0" onclick='document.all.uploadfile.click(); document.all.uploadfile2.value=document.all.uploadfile.value'> -->
                <!-- <input name="uploadfile2" id="uploadfile2" type="text" style="display:none;"> -->
            </div>
        </div>
        <div class="write cborder">
            <div class="select">
                <div class="sbutton">
                    <button type="button">작성취소</button>
                </div>
                <div class="sbutton">
                    <button type="button">내용초기화</button>
                </div>
            </div>
        </div>
        <div>
            <div class="complet">
                <button type="button">작성완료</button>
            </div> 
        </div>
    </div>
   </form>
    
    <div class="finclude">
   		<br>
		<jsp:include page="../common/footer.jsp"/>
    </div>

	<script>
		
		(function printToday() {
			var today = new Date();
			var month = (today.getMonth() + 1);
			var date = today.getDate();
			var str = today.getFullYear() + "-"
					+ (month < 10 ? "0" + month : month) + "-"
					+ (date < 10 ? "0" + date : date);
			$("#today").html(str);
		})();

		// 유효성 검사 
		function boardValidate() {
			if ($("#boardTitle").val().trim().length == 0) {
				alert("제목을 입력해 주세요.");
				$("#title").focus();
				return false;
			}

			if ($("#boardContent").val().trim().length == 0) {
				alert("내용을 입력해 주세요.");
				$("#content").focus();
				return false;
			}
		}

		// 이미지 영역을 클릭할 때 파일 첨부 창이 뜨도록 설정하는 함수
		$(function() {
			$(".boardImg").on("click", function() {
				var index = $(".boardImg").index(this);
				$("#img" + index).click();
			});

		});
		
		// 각각의 영역에 파일을 첨부 했을 경우 미리 보기가 가능하도록 하는 함수
		function LoadImg(value, num) {
			if (value.files && value.files[0]) {
				var reader = new FileReader();
				reader.readAsDataURL(value.files[0]);
				reader.onload = function(e) {

					$(".boardImg").eq(num).children("img").attr("src",
							e.target.result);
				}

			}
		}
	</script>

</body>
</html>
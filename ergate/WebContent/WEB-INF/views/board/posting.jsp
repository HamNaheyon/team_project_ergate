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
	

	
    
		<%-- <form action="${contextPath}/board2/insert?style=${pagination.boardStyle}" method="post"  --%>
		<form action="${contextPath}/board2/insert" method="post" 
			  name="insertFrm" enctype="multipart/form-data" role="form" onsubmit="return boardValidate();">
    <div class="pcontainer">
        <div class="postingsc">
            <h3>게시글 작성</h3>
        </div>
        <div class="ptype tborder">
            <div class="label">
                <label for="ptype">게시판종류*</label>
            </div>
            <div class="select">
            	<c:if test="${style == 1}">
                <select id="boardStyle" name="boardStyle">
                    <option value="1">제안서</option>
                </select>
                </c:if>
            	<c:if test="${style == 2}">
                <select id="boardStyle" name="boardStyle">
                    <option value="2">포트폴리오</option>
                </select>
                </c:if>
            </div>
        </div>
        <div class="pcategory cborder" >
            <div class="label">
                <label for="category">카테고리*</label>
            </div>
            <div class="select">
                <select id="categoryCode" name="categoryCd" onsubmit="return boardCategory();">
                    <option value="0" selected>=== 카테고리를 선택해주세요 ===</option>
                    <option value="1">웹 개발자</option>
                    <option value="2">앱 개발자</option>
                </select>
            </div>
        </div>
        <div class="title cborder">
            <div class="label">
                <label for="category">제목*</label>
            </div>
            <div class="select">
                <input name="boardTitle" id="boardTitle" type="text" placeholder = "제목을 입력해주세요" required>  
            </div>
        </div>
	   	
        <div class="contents cborder">
            <div class="label">
                <label for="contents">내용*</label>
            </div>
           <div class="cbselect">
            	<textarea name="boardContent" id="contents" placeholder = "내용을 입력해주세요" required></textarea>
            </div>
        </div>
        <div class="uploadfile cborder">
            <div class="label">
                <label for="thumbnail">썸네일</label>
            </div>
            <div class="select">
                <input name="img0" id="imgfile" type="file" accept="image/*">
                <!-- <img src="images/file.png" style="width:100px;" border="0" onclick='document.all.uploadfile.click(); document.all.uploadfile2.value=document.all.uploadfile.value'> -->
                <!-- <input name="uploadfile2" id="uploadfile2" type="text" style="display:none;"> -->
            </div>
        </div>
        <div class="uploadfile cborder">
<!--             <div class="label">
                <label for="uploadfile">첨부파일</label>
            </div> -->
            <c:if test="${style == 1}">
	            <div class="label">
	                <label for="thumbnail">첨부파일</label>
	            </div>
	            <div class="select">
                    <input type="file" accept=".pdf, .doc, .docx, .hwp">
	            </div>
            </c:if>
            <c:if test="${style == 2}">
	            <div class="select">
	                    <button type="button" id="addvalue" onclick="add();">이미지 추가</button>
	    				<div id="addimg"></div>
	                <!-- <img src="images/file.png" style="width:100px;" border="0" onclick='document.all.uploadfile.click(); document.all.uploadfile2.value=document.all.uploadfile.value'> -->
	                <!-- <input name="uploadfile2" id="uploadfile2" type="text" style="display:none;"> -->
	            </div>
            </c:if>
        </div>
        
        <div class="write cborder">
            <div class="select">
                <div class="sbutton">
                    <button type="button" name="boardback" onclick="history.back();">작성취소</button>
                </div>
                <div class="sbutton">
                    <button type="reset" class="reset">내용초기화</button>
                </div>
            </div>
        </div>
        <div>
            <div class="complet">
                <button type="submit">작성완료</button>
            </div> 
        </div>
    </div>
   </form>
    
    <div class="finclude">
   		<br>
		<jsp:include page="../common/footer.jsp"/>
    </div>

	<script>
		
		// 이미지 추가
        let count = 1;

        function add(){
            var addValue = document.getElementById('addvalue');

            var p = document.createElement("div");

            p.innerHTML = addValue.value;

            var ip = document.createElement("input");
            var btn = document.createElement("button");

            btn.innerHTML = "삭제";

            ip.setAttribute("type", "file");
            ip.setAttribute("name", "img" + count++);
            ip.setAttribute("class", "boardImg");
            btn.setAttribute("onclick", "deleteImage(this)");

            p.appendChild(ip);
            p.appendChild(btn);

            document.getElementById('addimg').appendChild(p); 

            addValue.value = ' ';
        }

        function deleteImage(el){
            el.parentElement.remove();
            count--;
        }
        
        function boardValidate(){
        	
        	const cd = $("#categoryCode").val();
        	if(cd == 0){
        		swal({
					"icon" : "warning",
					"title" : "카테고리를 선택해주세요"
				}).then(function(){
					$("#categoryCode").focus();
				});
        		return false;
        		
        	}else{
        		document.insertFrm.action = "${contextPath}/board2/insert?style=" + $("#boardStyle").val();
            	document.insertFrm.submit();
        	}
        }
        
/*         // 게시글 작성내용 지우기
        $("#reset").on("click", function(){
        	$("#contents").val("");
        }); */
	</script>
	

</body>
</html>
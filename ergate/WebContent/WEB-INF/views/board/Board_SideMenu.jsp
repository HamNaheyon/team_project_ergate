<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Board_SideMenu</title>

	<link rel = "stylesheet" type = "text/css" href = "${contextPath}/resources/css/Board_SideMenu_Style.css">
    
</head>
<body>
    <div class="smcontainer">
        <div class="smbt">
            <div class="smboardtypeNM proposal">
                <a href = "${contextPath}/board/list?type=1" id="iframeposting">제안서</a>
            </div>
            <div class="smboardtypeNM portfolio">
                <a href = "${contextPath}/board/list?type=2" id="iframeposting">포트폴리오</a>
            </div>
        </div>
        <div class="smbc">
            <div class="boardcategory">
                <div class="webdeveloper"><a href="${contextPath}/board/list?cp=${pagination.currentPage}&style=${pagination.boardStyle}&cg=1">웹개발자</a></div>
                <div class="appdeveloper"><a href="${contextPath}/board/list?cp=${pagination.currentPage}&style=${pagination.boardStyle}&cg=2">앱개발자</a></div>
            </div>
        </div>
        <div class="smbp">
        <c:if test="${!empty freLoginMember || !empty comLoginMember}">
            <div class="posting"><a href="../board2/insertForm">게시글작성</a></div>
        </c:if>
        </div>
    </div>

    <script>
        function iframeposting(url){
            document.getElementById('iframechange').src=url;
        }
    </script>
</body>
</html>
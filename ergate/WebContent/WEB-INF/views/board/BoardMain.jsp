<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>portfolio_list</title>
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

    <link rel = "stylesheet" type = "text/css" href = "${contextPath}/resources/css/BoardMain.css">
	<jsp:include page="../common/header.jsp"/>

</head>
<body>
	<jsp:include page="Board_Search_Form.jsp"/>
	<%-- <jsp:include page="../common/Board_SideMenu.jsp"/> --%>
	<jsp:include page="Board_SideMenu.jsp"/>
    <div class="pfcontainer">
        <div class="boardroute"><h4 id="boardroute">${pagination.boardName} > ${category.categoryName}</h4></div>
        <div class="pftitle">
            <h3 id="portfoliotitle">${pagination.boardName}</h3>
        </div>
        <div class="pfsort">
            <select id="pfsort" name="pfsort">
                <option name="sort" value="최신순">최신순</option>
                <option name="sort" value="경력">경력</option>
                <option name="sort" value="언어">언어</option>
            </select>
        </div>
        <div class="pfboardcontents">
        	<div id="pfcontents">
				<c:choose>
					<c:when test="${empty boardlist}">
		                <div id="pfthumbnail">
		                    <p>게시글이 존재하지 않습니다.</p>
		                </div>
					</c:when>
					<c:otherwise>
						<c:forEach items ="${boardList}" var="board">
							
			                <c:choose>
			                	
			                	<c:when test="${ empty board.fileName[0]}"> 
			                		<div id="pfthumbnail">
			                    		<img src="${contextPath}/resources/img/developer.png" style="width:95%;">
			                		</div>
			                	</c:when>
			     	
			                	<c:otherwise>
			                		<div id="pfthumbnail">
			                    		<img src="${contextPath}/${board.filePath[0]}${board.fileName[0]}" style="width:95%;">
			                		</div>
			                	</c:otherwise>
			                </c:choose>
			                <div id="pftitle"><h4>${board.boardType}</h4></div>
			                <div id="pfviews"><h6>${board.readCount}</h6></div>
						
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</div>

        </div>
        <div class="pfpaging">
            			<%---------------------- Pagination start----------------------%>
			<%-- 페이징 처리 시 주소를 쉽게 작성할 수 있도록 필요한 변수를 미리 선언 --%>
			
			<c:set var="pageURL" value="list?type=${pagination.boardType}"/>
			
			<c:set var="prev" value="${pageURL}&cp=${pagination.prevPage}"/><%-- &ca=${category.prevPage} --%>
			<c:set var="next" value="${pageURL}&cp=${pagination.nextPage}"/><%-- &ca=${category.nextPage} --%>
			
			<div class="my-5">
				<ul class="pagination">
					
					<%-- 현재 페이지가 10페이지 초과인 경우 --%>
					<c:if test="${pagination.currentPage > pagination.pageSize}">
						<li><a class="page-link" href="${prev}">&lt;&lt;</a></li>
					</c:if>
					
					<%-- 현재 페이지가 2페이지 초과인 경우 --%>
					<c:if test="${pagination.currentPage > 2}">
						<li><a class="page-link" href="${pageURL}&cp=${pagination.currentPage-1}">&lt;</a></li>
					</c:if>
					
					<%-- 페이지 목록 --%>
					<c:forEach var="p" begin="${pagination.startPage}" end="${pagination.endPage}">
												 <%-- 1                     10  --%>
						
							<c:choose>
								<c:when test="${p == pagination.currentPage}">
									<li class="page-item active"><a class="page-link">${p}</a></li>
									
								</c:when>
								
								<c:otherwise>
									<li><a class="page-link" href="${pageURL}&cp=${p}">${p}</a></li>
								</c:otherwise>
							</c:choose>
						
					</c:forEach>
					
					
					
					
					<%-- 현재 페이지가 마지막페이지 미만인 경우 --%>
					<c:if test="${pagination.currentPage < pagination.maxPage}">
						<a class="page-link" href="${pageURL}&cp=${pagination.currentPage+1}">&gt;</a>
					</c:if>
					
					<%-- 현재 페이지가 마지막페이지 미만인 경우 --%>
					<c:if test="${pagination.currentPage - pagination.maxPage + pagination.pageSize < 0}">
						<a class="page-link" href="${next}">&gt;&gt;</a>
					</c:if>


				</ul>
			</div>
			<%---------------------- Pagination end----------------------%>
        </div>
    </div>
        <div class="finclude">
			<jsp:include page="../common/footer.jsp"/>
        </div>
    
</body>
</html>
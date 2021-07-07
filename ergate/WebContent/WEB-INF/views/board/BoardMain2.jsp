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
    <link rel = "stylesheet" type = "text/css" href = "${contextPath}/resources/css/BoardMain_Style.css">
	<jsp:include page="../common/header.jsp"/>

</head>
<body>

	<jsp:include page="Board_Search_Form.jsp"/>
	<jsp:include page="Board_SideMenu.jsp"/>
    <div class="pfcontainer">
	
    		<div class="boardroute">
    			<c:if test="${pagination.boardStyle==1 && pagination.categoryCd==''}">
    				<h4 id="boardroute">제안서 > 전체</h4>	
    			</c:if>
    			<c:if test="${pagination.boardStyle==1 && pagination.categoryCd==1}">
    				<h4 id="boardroute">제안서 > 웹개발자</h4>	
    			</c:if>
    			<c:if test="${pagination.boardStyle==1 && pagination.categoryCd==2}">
    				<h4 id="boardroute">제안서 > 앱개발자</h4>	
    			</c:if>
    			<c:if test="${pagination.boardStyle==2 && pagination.categoryCd==''}">
    				<h4 id="boardroute">포트폴리오 > 전체</h4>	
    			</c:if>
    			<c:if test="${pagination.boardStyle==2 && pagination.categoryCd==1}">
    				<h4 id="boardroute">포트폴리오 > 웹개발자</h4>	
    			</c:if>
    			<c:if test="${pagination.boardStyle==2 && pagination.categoryCd==2}">
    				<h4 id="boardroute">포트폴리오 > 앱개발자</h4>	
    			</c:if>
    		</div>
    
        
        
        <div class="pftitle">
        	<c:if test="${pagination.boardStyle == 1}">
            	<h3 id="portfoliotitle">제안서 게시판</h3>
            </c:if>
        	<c:if test="${pagination.boardStyle == 2}">
            	<h3 id="portfoliotitle">포트폴리오 게시판</h3>
            </c:if>
        </div>
<!--         <div class="pfsort">
            <select id="pfsort" name="pfsort">
                <option name="sort" value="최신순">최신순</option>
                <option name="sort" value="경력">경력</option>
                <option name="sort" value="언어">언어</option>
            </select>
        </div> -->
        <div class="pfboardcontents">
        	<div id="pfcontents">
        	
        		<c:if test="${!empty param.sk && !empty param.sv}">
        			<c:set var="searchstr" value="&sk=${param.sk}$sv=${param.sv}" />
        		</c:if>
        		
        	
				<c:choose>
					<c:when test="${empty boardList}">
		                <div id="pfthumbnail">
		                    <p>게시글이 존재하지 않습니다.</p>
		                </div>
					</c:when>
					<c:otherwise>
						<c:forEach items ="${boardList}" var="board">
							
		                	<a href="${contextPath}/detailBoard?boardNo=${board.boardNo}&cp=${pagination.currentPage}&style=${pagination.boardStyle}&type=${board.boardType}${searchStr}">

				                <c:choose>
	
				                	<c:when test="${ empty board.fileName[0]}"> 
					                	<div id="pfthumbnail" style=float:left;>
				                    		<img src="${contextPath}/resources/img/developer.png" style="width:95%;">
				                		</div>
				                	</c:when>
	
				                	<c:otherwise>
					                	<div id="pfthumbnail">
				                    		<img src="${contextPath}/${board.filePath[0]}${board.fileName[0]}" style="width:95%;">
				                		</div>
				                	</c:otherwise>
	
				                </c:choose>
				                
		                	</a>
		                	
			                <div id="pftitle"><h4>${board.boardTitle}</h4></div>
			                <div id="pfwriter">
				                <c:if test="${board.boardType == 1}">
				                	<h4>프리랜서 회원</h4>
				                </c:if>
				                <c:if test="${board.boardType == 2}">
				                	<h4>기업 회원</h4>
				                </c:if>
			                </div>
			                <div id="pfviews"><h6>${board.readCount}</h6></div>
						
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</div>

        </div>
        <div class="pfpaging">
            			<%---------------------- Pagination start----------------------%>
			<%-- 페이징 처리 시 주소를 쉽게 작성할 수 있도록 필요한 변수를 미리 선언 --%>
			
			<c:set var="pageURL" value="list?style=${pagination.boardStyle}"/>
			
			<c:set var="prev" value="${pageURL}&cp=${pagination.prevPage}${searchStr}"/><%-- &ca=${category.prevPage} --%>
			<c:set var="next" value="${pageURL}&cp=${pagination.nextPage}${searchStr}"/><%-- &ca=${category.nextPage} --%>
			
			<div class="my-5">
				<ul class="pagination">
					
					<%-- 현재 페이지가 10페이지 초과인 경우 --%>
					<c:if test="${pagination.currentPage > pagination.pageSize}">
						<li><a class="page-link" href="${prev}">&lt;&lt;</a></li>
					</c:if>
					
					<%-- 현재 페이지가 2페이지 초과인 경우 --%>
					<c:if test="${pagination.currentPage > 2}">
						<li><a class="page-link" href="${pageURL}&cp=${pagination.currentPage-1}${searchStr}">&lt;</a></li>
					</c:if>
					
					<%-- 페이지 목록 --%>
					<c:forEach var="p" begin="${pagination.startPage}" end="${pagination.endPage}">
												 <%-- 1                     10  --%>
						
							<c:choose>
								<c:when test="${p == pagination.currentPage}">
									<li class="page-item active"><a class="page-link">${p}</a></li>
								</c:when>
								<c:otherwise>
									<li><a class="page-link" href="${pageURL}&cp=${p}${searchStr}">${p}</a></li>
								</c:otherwise>
							</c:choose>
						
					</c:forEach>
					
					<%-- 현재 페이지가 마지막페이지 미만인 경우 --%>
					<c:if test="${pagination.currentPage < pagination.maxPage}">
						<a class="page-link" href="${pageURL}&cp=${pagination.currentPage+1}${searchStr}">&gt;</a>
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
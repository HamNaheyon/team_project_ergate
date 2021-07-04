<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>com_myPost</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

    <style>
        div{
            box-sizing:border-box;

        }

        .fre_mblist{
            background-color:rgb(166,206,231);
            height:30px;
        }

        .fre_mbcontents{
            height:15px;
            
        }
        
        .fre_mblist li, .fre_mbcontents li{
            margin-left:0;
            list-style-type: none;
            
            height: 30px;
            
            border-right:2px solid white;
            border-left:2px solid white;
            
            text-align : center;
            float:left;
        }

        #fre_mblistno{width:11%;}
        #fre_mblisttitle{width:20%;}
        #fre_mblistwriter{width:15%;}
        #fre_mblistcontents{width:35%;}
        #fre_mblistdt{width:15%;}

        #mbn{width:11%;}
        #mbt{width:20%;}
        #mbw{width:15%;}
        #mbc{width:35%;}
        #mbd{width:15%;}
    </style>
</head>
<body>
    <jsp:include page="../common/header.jsp"></jsp:include>
      <div id="fre_container">
       		<jsp:include page="com_sideMenu.jsp"></jsp:include>
        <div class="fre_mb-form">
            <div class="myboard">
                <h4 class="fre_mbtitle">내 게시글</h4>
                <br>
                <hr>
            </div>
            <div class="fre_mblist">
                <ul>
                    <li id="fre_mblistno">게시글 번호</li>
                    <li id="fre_mblisttitle">제목</li>
                    <li id="fre_mblistwriter">작성자</li>
                    <li id="fre_mblistcontents">조회수</li>
                    <li id="fre_mblistdt">작성일자</li>
                </ul>
            </div>
            <div class="fre_mbcontents">
            <c:choose>
            	<c:when test="${empty boardList }">
            		<ul>
            		<li>게시글이 없습니다</li>
            		</ul>
            	</c:when>
            	<c:otherwise>
            		<c:forEach items="${boardList}" var="board">
                <ul>
                    <li id="mbn">${board.boardNo}</li>
                    <li id="mbt">${board.boardTitle}</li>
                    <li id="mbw">${board.memberId}</li>
                    <li id="mbc">${board.readCount }</li>
                    <li id="mbd">${board.createDate }</li>
                </ul>
            		</c:forEach>
            	</c:otherwise>
            </c:choose>
            <div>
          	<%-- 페이징 처리 시 주소를 쉽게 작성할 수 있도록 필요한 변수를 미리 선언 --%>
			<c:set var="pageURL" value="list?no=${pagination.memberNo}"/>
			
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
            </div>
        </div>
</body>
</html>
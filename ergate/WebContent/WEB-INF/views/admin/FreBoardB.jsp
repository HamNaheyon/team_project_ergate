<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="../common/side.jsp"></jsp:include> 
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <title>html문서 제목</title>
     <style>
   
         #main-freBoardB{
             width: 88%;
             height: 70%;
             float:left;
         }
         .but-style{
            background-color: white; color:rgb(166  , 206, 231); font-weight: bold;
            border-color: rgb(166  , 206, 231);
            border-radius: 12px;
        }
     </style>
     
</head>
<body>
	<%-- 검색 상태 유지를 위한 쿼리스트링용 변수선언 --%>
					<c:if test="${!empty param.sk && !empty param.sv}">
					<%--검색은 게시글 목록 조회에 단순히 sk,sv 파라미터를 추가한것 
						->목록 조회 결과 환면을 만들기 위해 boardList.jsp로 요청 위임 되기 때문에
						request객체가 유지되고, 파라미터도 유지된다.
					--%>
					<c:set var="searchStr" value="&sk=${param.sk}&sv=${param.sv}"/>
					</c:if>
    <div id="main-freBoardB">
    <table class="table">
      <thead style="background-color: rgb(166  , 206, 231); color: white; font-weight: bold;">
        
          <tr><th>게시글 번호</th><th>게시글 제목</th><th>아이디</th><th>날짜</th><th>스타일</th><th>블라인드 처리 여부</th><th>상세보기</th></tr>
      </thead>
      <tbody>
				<c:choose>
					<c:when test="${empty adminBoardList}">
					<tr>
						<td colspan="6"> 게시물이 없습니다.</td>
					</tr>
					</c:when>
					<c:otherwise>
						<c:forEach items="${adminBoardList}" var="board">
							<tr>
								<td>${board.boardNo}</td>
								<td>${board.boardTitle }</td>
								<td>${board.memberId }</td>
								<td>${board.createDT}</td>
								<td>${board.boardStyle}</td>
								<td>${board.boardStatus}</td>
								<c:if test="${board.boardStatus eq 'Y'}">
								<td><button class='Del'>블라인드</button></td>
								</c:if>
								<c:if test="${board.boardStatus eq 'N'}">
								<td ><button class='Re'>블라인드 해제</button></td>
								</c:if>
							</tr>
						
						</c:forEach>
					</c:otherwise>
				</c:choose>
      </tbody>
    </table>
    
 			<c:set var="pageURL" value="freBoardB?type=${pagination.boardTypeNo }"/>
			<c:set var="prev" value="${pageURL}&cp=${pagination.prevPage }"/>
			<c:set var="next" value="${pageURL}&cp=${pagination.nextPage }"/>
			
			<div class="my-5">
				<ul class="pagination" style="padding-left: 35%">
				<%-- 현재 페이지가 10패이지 초과인 경우 --%>
				<c:if test = "${pagination.currentPage >pagination.pageSize }">
					<li><a class="page-link" href="${prev}">&lt;&lt;</a></li>
				</c:if>	
				<%--현재 페이지가 2페이지 초과인 경우 이전페이지 --%>			
				<c:if test = "${pagination.currentPage >2 }">
					<li><a class="page-link" href="${pageURL}&cp=${pagination.currentPage-1}">&lt;</a></li>
				</c:if>
				
				
				<%-- 페이지 목록 --%>
				<c:forEach var="p" begin="${pagination.startPage}" end="${pagination.endPage}">
					
					<c:choose>
						<c:when test="${p==pagination.currentPage}">
						<li class="page-item active"><a class="page-link">${p}</a></li>
						</c:when>
						
						<c:otherwise>
						<li><a class="page-link" href="${pageURL}&cp=${p}">${p}</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<%--현재 페이지가 마지막 페이지 미만인 경우 --%>			
				<c:if test = "${pagination.currentPage <pagination.maxPage }">
				<li><a class="page-link" href="${pageURL}&cp=${pagination.currentPage+1}">&gt;</a></li>
				</c:if>		
				
				<%--현재 페이지가 마지막 페이지 미만인 경우 --%>			
				<c:if test = "${pagination.currentPage-pagination.maxPage+pagination.pageSize<0 }">
					<li><a class="page-link" href="${next}">&gt;&gt;</a></li>
				</c:if>				
				</ul>
			</div>
	
	
	
	
	
	
      <div>
        <select aria-label="Default select example" style="margin-left: 35%;">
          <option value="1" selected>게시글 번호</option>
          <option value="2">게시글 제목</option>
          <option value="3">아이디</option>
          <option value="4">날짜</option>
          <option value="5">블라인드 처리여부</option>
          <option value="6">탈퇴 여부</option>
        </select>
      <input type="search"> <button id="searchbtn" class="but-style">검색</button>
    </div>
    
    
    
    </div>


<script>
	
		$('.Del').on("click",function(){
			let boardNo = $(this).parent().parent().children().eq(0).text().trim();
			console.log(boardNo);
			// $(this) : 클릭된 td 태그
			// parent() : 부모 요소(tr)
			// children() : 모든 자식요소 (td 4개)
			// eq(0) : 모든 자식 요소 중 0번 째 인덱스 자식 (숫자 써진 td)			
			// text() : 요소에 작성된 내용 얻어오기
			location.href="${contextPath}/admin2/freDel?boardNo="+boardNo+"&type=1&cp="+${pagination.currentPage};
		});
		$('.Re').on("click",function(){
			let boardNo = $(this).parent().parent().children().eq(0).text().trim();
			console.log(boardNo);
			// $(this) : 클릭된 td 태그
			// parent() : 부모 요소(tr)
			// children() : 모든 자식요소 (td 4개)
			// eq(0) : 모든 자식 요소 중 0번 째 인덱스 자식 (숫자 써진 td)			
			// text() : 요소에 작성된 내용 얻어오기
			location.href="${contextPath}/admin2/freRe?boardNo="+boardNo+"&type=1&cp="+${pagination.currentPage};
		});
	
</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
</body>
</html>
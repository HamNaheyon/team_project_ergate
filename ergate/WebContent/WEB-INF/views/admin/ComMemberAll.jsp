<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <jsp:include page="../common/side.jsp"></jsp:include> 
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <title>html문서 제목</title>
     <style>
       .but-style{
            background-color: white; color:rgb(166  , 206, 231); font-weight: bold;
            border-color: rgb(166  , 206, 231);
            border-radius: 12px;
        }
         #main-Member-All{
         float:left;
             width: 85%;
             height: 70%;
         }
     </style>
     
</head>
<body>
    <div id="main-Member-All">
 
    <table class="table" id="tx">
      <thead style="background-color: rgb(166  , 206, 231); color: white; font-weight: bold;">
        
          <tr><th>회원번호</th><th>기업이름</th><th>사업자 번호</th><th>아이디</th><th>가입 날짜</th><th>이메일</th><td>탈퇴 여부</td><td>상세조회</td></>
      </thead>
      <tbody>
     	<c:choose>
					<c:when test="${empty adminMemberList}">
					<tr>
						<td colspan="8"> 게시물이 없습니다.</td>
					</tr>
					</c:when>
					<c:otherwise>
						<c:forEach items="${adminMemberList}" var="member">
							<tr>
								<td>${member.memberNo }</td>
								<td>${member.companyName }</td>
								<td>${member.companyNo }</td>
								<td>${member.memberId}</td>
								<td>${member.enrollDate}</td>
								<td>${member.memberEmail}</td>
								<td>${member.memberStatus}</td>
								<td><a class ="look">상세보기</a></td>
							</tr>
						
						</c:forEach>
					</c:otherwise>
				</c:choose>
      </tbody>
    </table>
   			<c:set var="pageURL" value="ComMemberAll?type=${pagination.memberGrade }"/>
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
          <option value="1" selected>회원 번호</option>
          <option value="2">기업 이름</option>
          <option value="3">사업자 번호</option>
          <option value="4">아이디</option>
          <option value="5">가입 날짜</option>
          <option value="6">이메일</option>
          <option value="7">탈퇴여부</option>
        </select>
      <input type="search"> <button id="searchbtn" class=" but-style">검색</button>
    </div>
    
    
    
    </div>



<script>
	
		$('.look').on("click",function(){
			let memberNo = $(this).parent().parent().children().eq(0).text().trim();
			// $(this) : 클릭된 td 태그
			// parent() : 부모 요소(tr)
			// children() : 모든 자식요소 (td 4개)
			// eq(0) : 모든 자식 요소 중 0번 째 인덱스 자식 (숫자 써진 td)			
			// text() : 요소에 작성된 내용 얻어오기
			location.href="${contextPath}/admin/ComMemberSel?memberNo="+memberNo;
		});
	
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
</body>
</html>
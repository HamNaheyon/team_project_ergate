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
       a{
       text-decoration: none;}
        a:hover{
       color :white;
       }
         #main-freMemberAll{
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
    <div id="main-freMemberAll">
    <table class="table">
      <thead style="background-color: rgb(166  , 206, 231); color: white; font-weight: bold;">
        
          <tr><th>회원번호</th><th>이름</th><th>아이디</th><th>가입 날짜</th><th>이메일</th><td>탈퇴 여부</td><td>상세조회</td></tr>
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
								<td>${member.memberName }</td>
								<td>${member.memberId }</td>
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
  <c:set var="pageURL" value="freMemberAll?type=${pagination.memberGrade }${searchStr}"/>
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
            <form action="#" method="GET" id="searchForm">
			<input type="hidden" name="type" value="F">
			<select name="sk"aria-label="Default select example" style="margin-left: 35%;">
 			<option value="comMemberNo" selected>회원 번호</option>
          <option value="freMemName">이름</option>
          <option value="id">아이디</option>
          <option value="comMemDt">가입 날짜</option>
          <option value="comMemEmail">이메일</option>
          <option value="comMemGrade">탈퇴여부</option>
			</select> <input name="sv"type="search">
			<button id="searchbtn" class="but-style">검색</button>
			
			</form>
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
			location.href="${contextPath}/admin/FreMemberSel?memberNo="+memberNo;
		});
	
</script>
<script>
    // 검색 내용이 있을 경우 검색창에 해당 내용을 작성해두는 기능
    (function(){
       var searchKey = "${param.sk}"; 
       // 파라미터 중 sk가 있을 경우   ex)  "abc"
       // 파라미터 중 sk가 없을 경우   ex)  ""
       var searchValue = "${param.sv}";
       
       // 검색창 select의 option을 반복 접근
       $("select[name=sk] > option").each(function(index, item){
          // index : 현재 접근중인 요소의 인덱스
          // item : 현재 접근중인 요소
                   // content            content
          if( $(item).val() == searchKey  ){
             $(item).prop("selected", true);
          }
       });      
       
       // 검색어 입력창에 searcValue 값 출력
       $("input[name=sv]").val(searchValue);
    })();
    
	</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
</body>
</html>
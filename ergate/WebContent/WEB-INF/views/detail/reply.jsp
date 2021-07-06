<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<style>
/*댓글*/
.commentsWrite >table {	
	width: 100%;
	margin-top: 10px; 
}
.rWriter {
	display: inline-block;
	vertical-align: top;
	font-size : 1.2em;
	font-weight: bold;
}
.rDate { display: inline-block; }
.rContent, .commentsBtnArea {
	height: 100%;
	width: 100%;
	font-size: 20px;
}
.commentsBtnArea { text-align: right; }
.commentsUpdateContent {
	resize: none;
	width: 100%;
}
.comments-row{
	border-top : 1px solid #ccc;
	padding : 15px 0;
}
#commentsContentArea{
	width: 90%;
}
#commentsContentArea > textArea{
	width: 100%;
}
</style>

<div id="comments-area ">

	<!-- 댓글 작성 부분 -->
	<div class="commentsWrite">
		<table >
			<tr>
				<td id="commentsContentArea">
					<textArea rows="3" id="commentsContent"></textArea>
				</td>
				<td id="commentsBtnArea">
					<button class="btn btn-primary" id="addcomments" onclick="addcomments();">
						댓글<br>등록
					</button>
				</td>
			</tr>
		</table>
	</div>

 	
	<!-- 댓글 출력 부분 -->
	<div class="commentsList mt-5 pt-2">
		<ul id="commentsListArea">
			<c:forEach items="${rList}" var="comments">
				<li class="comments-row">
					<div>
						<p class="rWriter">${comments.memberId}</p>
						<p class="rDate">작성일 : <fmt:formatDate value="${comments.commentsDt}" pattern="yyyy년 MM월 dd일 HH:mm"/></p>
					</div>
	
					<p class="rContent">${comments.commentsContent}</p>
					
					<c:choose>
					<c:when test="${comments.memberNo == comLoginMember.memberNo}">
						<div class="commentsBtnArea">
							<button class="btn btn-primary btn-sm ml-1" id="updatecomments" onclick="showUpdatecomments(${comments.commentsNo}, this)">수정</button>
							<button class="btn btn-primary btn-sm ml-1" id="deletecomments" onclick="deletecomments(${comments.commentsNo})">삭제</button>
						</div>
					</c:when>
					<c:when test="${comments.memberNo == freLoginMember.memberNo}">
					<div class="commentsBtnArea">
							<button class="btn btn-primary btn-sm ml-1" id="updatecomments" onclick="showUpdatecomments(${comments.commentsNo}, this)">수정</button>
							<button class="btn btn-primary btn-sm ml-1" id="deletecomments" onclick="deletecomments(${comments.commentsNo})">삭제</button>
						</div>
					</c:when>
					</c:choose>
				</li>
			</c:forEach>
		</ul>
	</div>
</div>

<script>

// 로그인한 회원의 회원 번호, 비로그인 시 "" (빈문자열)
const loginMemberNo = "${freLoginMember.memberNo}" || "${comLoginMember.memberNo}" ;

// 현재 게시글 번호
const boardNo = ${board.boardNo};

// 수정 전 댓글 요소를 저장할 변수 (댓글 수정 시 사용)
let beforecommentsRow;

//-----------------------------------------------------------------------------------------
// 댓글 등록
function addcomments()	{
	// 작성된 댓글 내용 얻어오기 
	const commentsContent = $("#commentsContent").val();
	
	// 로그인이 되어있지 않은 경우
	if(loginMemberNo == ""){
		swal("로그인후 이용해 주세요.");
	}else{ // 로그인이 된 경우
		if(commentsContent.trim() == ""){ // 작성된 댓글이 없을 경우
			swal("댓글 작성 후 클릭해주세요.");
		}else{
			
			// 필터(정규식)
			/*
				let arr = ['욕욕욕욕'];
				for(){}
			*/
			console.log(loginMemberNo);
			console.log(boardNo);
			console.log(commentsContent);
			// 로그인 O, 댓글 작성 O
			$.ajax({
				url : "${contextPath}/comments/insertComments", // 필수 속성(반드시 ajax안에 써야하는 코드)
				type : "POST",  // 데이터 전달 방식
				
				// k, v 형태
				// const loginMemberNo 를 memberNo로 넘긴다
				data : {"memberNo" : loginMemberNo,  
						"boardNo" : boardNo,
						"commentsContent" : commentsContent},
				success : function(result){
					console.log(result);
					if(result > 0){ // 댓글 삽입이 성공한 경우
						swal({"icon" : "success" , "title" : "댓글 등록 성공"});
					
						$("#commentsContent").val("");  // 댓글 작성 내용 삭제
						selectcommentsList(); // 비동기로 댓글 목록 갱신
					}else{
						swal({"icon" : "error" , "title" : "댓글 실패"});
						
						$("#commentsContent").val("");  // 댓글 작성 내용 삭제
						selectcommentsList(); // 비동기로 댓글 목록 갱신
					}
				},
				error : function(){console.log("댓글 삽입 실패");}
			});
		}
	}
}	


//-----------------------------------------------------------------------------------------
//해당 게시글 댓글 목록 조회
function selectcommentsList(){
	$.ajax({
		url : "${contextPath}/comments/list",
		data : {"boardNo" : boardNo},
		type : "POST",
		dataType : "JSON", // 응답되는 데이터의 형식이 JSON임을 알려줌 -> 자바스크립트의 객체로 변환됨.
		success : function(rList){
			console.log(rList);
	        $("#commentsListArea").html(""); // 기존 정보 초기화
			// 왜? 새로 읽어온 댓글 목록으로 다시 만들어서 출력하려고
			 
			$.each(rList, function(index, item){
				//  $.each() : jQuery의 반복문
				// rList : ajax 결과로 받은 댓글이 담겨잇는 객체 배열
				// 
				// item : 순차 접근 시 현재 접근한 배열 요소(댓글 객체 하나)
					 
				var li = $("<li>").addClass("comments-row");
				
				// 작성자, 작성일, 수정일 영역 
				var div = $("<div>");
				var rWriter = $("<p>").addClass("rWriter").text(item.memberName);
				var rDate = $("<p>").addClass("rDate").text("작성일 : " + item.commentsDt);
				div.append(rWriter).append(rDate)
				   
				// 댓글 내용
				var rContent = $("<p>").addClass("rContent").html(item.commentsContent);
				   
				// 대댓글, 수정, 삭제 버튼 영역
				var commentsBtnArea = $("<div>").addClass("commentsBtnArea");
				   
				// 현재 댓글의 작성자와 로그인한 멤버의 아이디가 같을 때 버튼 추가
				if(item.memberNo == loginMemberNo){
				      
					// ** 추가되는 댓글에 onclick 이벤트를 부여하여 버튼 클릭 시 수정, 삭제를 수행할 수 있는 함수를 이벤트 핸들러로 추가함. 
					var showUpdate = $("<button>").addClass("btn btn-primary btn-sm ml-1").text("수정").attr("onclick", "showUpdatecomments("+item.commentsNo+", this)");
					var deletecomments = $("<button>").addClass("btn btn-primary btn-sm ml-1").text("삭제").attr("onclick", "deletecomments("+item.commentsNo+")");
					      
					commentsBtnArea.append(showUpdate).append(deletecomments);
				}
				    
				// 댓글 요소 하나로 합치기
				li.append(div).append(rContent).append(commentsBtnArea);
				    
				// 합쳐진 댓글을 화면에 배치
				$("#commentsListArea").append(li);
			});
		},
		error : function(){console.log("댓글 목록 조회 실패");}
		
	});
}


// -----------------------------------------------------------------------------------------
// 일정 시간마다 댓글 목록 갱신
 /* const commentsInterval = setInterval(function(){
	 selectcommentsList();
 },5000); */
 

// -----------------------------------------------------------------------------------------
// 댓글 수정 폼

function showUpdatecomments(commentsNo, el){
	// 이미 열려있는 댓글 수정 창이 있을 경우 닫아주기
	if($(".commentsUpdateContent").length > 0){
		$(".commentsUpdateContent").eq(0).parent().html(beforecommentsRow);
	}
	
	// 댓글 수정화면 출력 전 요소를 저장해둠.
	beforecommentsRow = $(el).parent().parent().html();
	
	   
   // 작성되어있던 내용(수정 전 댓글 내용) 
   var beforeContent = $(el).parent().prev().html();

   // 이전 댓글 내용의 크로스사이트 스크립트 처리 해제, 개행문자 변경
   // -> 자바스크립트에는 replaceAll() 메소드가 없으므로 정규 표현식을 이용하여 변경
   beforeContent = beforeContent.replace(/&amp;/g, "&");   
   beforeContent = beforeContent.replace(/&lt;/g, "<");   
   beforeContent = beforeContent.replace(/&gt;/g, ">");   
   beforeContent = beforeContent.replace(/&quot;/g, "\"");   
   
   beforeContent = beforeContent.replace(/<br>/g, "\n");   
   
   
   // 기존 댓글 영역을 삭제하고 textarea를 추가 
   $(el).parent().prev().remove();
   var textarea = $("<textarea>").addClass("commentsUpdateContent").attr("rows", "3").val(beforeContent);
   $(el).parent().before(textarea);
   
   // 수정 버튼
   var updatecomments = $("<button>").addClass("btn btn-primary btn-sm ml-1 mb-4").text("댓글 수정").attr("onclick", "updatecomments(" + commentsNo + ", this)");
   
   // 취소 버튼
   var cancelBtn = $("<button>").addClass("btn btn-primary btn-sm ml-1 mb-4").text("취소").attr("onclick", "updateCancel(this)");
   
   var commentsBtnArea = $(el).parent();
   
   $(commentsBtnArea).empty(); 
   $(commentsBtnArea).append(updatecomments); 
   $(commentsBtnArea).append(cancelBtn); 
}

//-----------------------------------------------------------------------------------------
//댓글 수정 취소 시 원래대로 돌아가기
function updateCancel(el){
	$(el).parent().parent().html(beforecommentsRow);
}

//-----------------------------------------------------------------------------------------
// 댓글 수정
function updatecomments(commentsNo, el){

	// 수정된 댓글 내용
	const commentsContent = $(el).parent().prev().val();
	
	$.ajax({
		url : "${contextPath}/comments/updateComments",
		type : "POST",
		data : {"commentsNo" : commentsNo,
				"commentsContent" : commentsContent},
		success : function(result){
			if(result > 0){
				swal({"icon" : "success" , "title" : "댓글 수정 성공"});
				selectcommentsList();
			}
		},
		error : function(){
			console.log("댓글 수정 실패");
		}
	});
}


//-----------------------------------------------------------------------------------------
//댓글 삭제
function deletecomments(commentsNo){
	
	   if(confirm("정말로 삭제하시겠습니까?")){
		      var url = "${contextPath}/comments/deleteComments";
		      
		      $.ajax({
		         url : url,
		         data : {"commentsNo" : commentsNo},
		         success : function(result){
		            if(result > 0){
		               selectcommentsList(boardNo);
		               
		               swal({"icon" : "success" , "title" : "댓글 삭제 성공"});
		            }
		            
		         }, error : function(){
		            console.log("ajax 통신 실패");
		         }
		      });
		   }
}


</script>



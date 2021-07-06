<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>

<link rel="shortcut icon" href="#">

	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>제안서 상세</title>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
   	<style>
   	@font-face {
    font-family: 'Cafe24SsurroundAir';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2105_2@1.0/Cafe24SsurroundAir.woff') format('woff');
    font-weight: normal;
    font-style: normal;
	}
	/* div{
		border: 1px solid black;
	} */
	/* 전체 감싸고 있는 아이디 */
	#container{
		margin: auto;
		width:90%;
		height:2500px;
	}
	/* 타이틀, 조회수, 썸네일 */
	#con-img{
		width : 65%;
		height: 20%;
		float: left;
	}
	#img-text{
		width : 100%;
		height : 10%;
	}
	#la1{
        float: left;
        font-size: 30px;
        font-weight: bold;
        line-height : 57px;
       }
    #la2{
       float: right;
       font-size: 23px;
       line-height : 57px;
    }
	.img-title{
		width : 100%;
		height: 90%;
	}
	img{
       display: block; 
       margin: 0px auto; 
       }
	
	/* 작성자 설명  */
       #con-text{
       	width: 30%;
       	height: 20%;
       	float: right;
       }
       /* 내용 */
       #detail-text{
       	margin-top: 60px;
       	padding-top : 40px;
       	padding-left : 20px;
       	width: 100%;
       	height: 80%;
		background-color: rgba(166, 206, 231, 0.2);
		font-size : 25px;
		color: balck;
		font-family: "Cafe24SsurroundAir";
		
       }
       /* 채팅 버튼 */
       #chat-btn{
       	width: 100%;
       	height: 10%;
       }
       #chat-btn > button {
       	background-color: rgb(166, 206, 231);
           border: 5px solid white;
           width: 100%;
           height: 100%;
           font-weight: bold;
           font-family: 'MaplestoryOTFBold';
           text-shadow: 1px 1px 5px #000;
           color: white;
       }
       #chat-btn > button:hover{
       	background-color: rgb(152, 203, 235);
           text-shadow: -2px 0 black, 0 2px black, 2px 0 black, 0 -2px black;
           border:3px outset rgb(152, 203, 235);
       }
       #etc-btn{
       
       	margin-top: 30px;
       	float: right;
       	width: 30%;
       	height: 4%;
       }
       
        #btn-size1{
        	width:100%;
        	height:50%;
        }
        
        #btn-size2{
        	float: left;
        	width:100%;
        	height:50%;
        }
        #btn-size1>button{
        	background-color: rgb(166, 206, 231);
        	border: 5px solid white;
        	font-weight: bold;
        	font-family: 'MaplestoryOTFBold';
           text-shadow: 1px 1px 5px #000;
        	width:50%;
        	height:100%;
        	float: left;
           color: white;
        }
        
       #btn-size1>button:hover{
       	background-color: rgb(152, 203, 235);
           text-shadow: -2px 0 black, 0 2px black, 2px 0 black, 0 -2px black;
           border:3px outset rgb(152, 203, 235);
       }
        #return-btn{
        	background-color: rgb(166, 206, 231);
        	border: 5px solid white;
        	font-weight: bold;
        	font-family: 'MaplestoryOTFBold';
           text-shadow: 1px 1px 5px #000;
        	width:100%;
        	height:100%;
           color: white;
        }
        #return-btn:hover{
       	background-color: rgb(152, 203, 235);
           text-shadow: -2px 0 black, 0 2px black, 2px 0 black, 0 -2px black;
           border:3px outset rgb(152, 203, 235);
       }
       /* 제안서, 제안서 설명, 댓글 바 */
       #main-btn{
       	width:60%;
       	/* height: 3%; */
       	float: left;
       	background-color: white;
       }
       #main-btn>a{
       	margin:2px;
       	border: 1px solid black;
       	float: left;
       	padding : 15px;
       	padding-right : 25px;
       	padding-left : 25px;
       	font-size: 26px; font-weight: bold;
       	color: black;
           text-decoration-line : none;
       }
       .menu-fixed {
		  position: fixed;
		  top: 10px;
		  left:5%;
		  background-color: white;
		}
		/* 내용 들어갈 부분*/
		#con-main-text{
			width: 65%;
			height: 69.9%;
			float: left;
			background-color: white;
		}
		.navi-name{
			margin-top: 5px;
		 	float: left;
	        font-size: 25px;
	        font-weight: bold;
		}
		#name-con{
			margin-top: 45px;
			margin-bottom: 40px;
			width: 100%;
			height:30%;
			border: 2px solid rgba(166, 206, 231, 0.7);
		}	
		
		#plan-con{
			margin-top: 65px;
			margin-bottom: 40px;
			width: 100%;
			height: 43%;
			border: 2px solid rgba(166, 206, 231, 0.7);
			font-size : 30px;
		}
		#comment-con{
			margin-top: 65px;
			width: 100%;
			height: 20%;
			border: 2px solid rgba(166, 206, 231, 0.7);
			overflow: auto;
		}
	</style>
</head>
<body id = "body-top">
${board}
${Attachment}
	<jsp:include page="../common/header.jsp"/>
  	<div id="container">
  		<div id="con-img">
	        <div id="img-text">
	            <lable id="la1">${board.boardTitle}</lable>
	            <lable id="la2">조회수 ${board.readCount}</lable>
	        </div>
	       <c:choose>
	        	<c:when test="${empty at.filePath}"> 
		        	<div class="img-title">
		            	<img src="${contextPath}/resources/img/developer.png" width="auto" height="100%">
		        	</div>
	        	</c:when>
	        	<c:otherwise>
	        		<c:forEach items="${board.atList}" var="at">
						<c:choose>
							<c:when test="${at.fileLevel == 0 && !empty at.fileName}">
								<c:set var="img0" value="${contextPath}/${at.filePath}${at.fileName}"/>
							</c:when>
						</c:choose>
					</c:forEach>
	        	</c:otherwise>
	        </c:choose>
	        
	    </div>
	    <div id="con-text">
	    	<div id="detail-text">
			    <c:choose>
			    	<c:when test="${empty board.companyName}">
				    	아이디 : ${board.memberId} <br>
				    	희망 근무 시간 : 
				    	<c:choose>
				    		<c:when test = "${ board.minTime}" >
				    		${board.minTime}
				    		</c:when>
				    		<c:otherwise>
				    		00:00
				    		</c:otherwise>
				    	</c:choose>  ~ 
				    	<c:choose>
				    		<c:when test = "${!empty board.maxTime}" >
				    		${board.maxTime}
				    		</c:when>
				    		<c:otherwise>
				    		00:00
				    		</c:otherwise>
				    	</c:choose>
				    	<br>
				    	희망 급여 : 
				    	<c:choose>
				    		<c:when test = "${!empty board.minSalary}" >
				    		${board.minSalary}
				    		</c:when>
				    		<c:otherwise>
				    		0
				    		</c:otherwise>
				    	</c:choose>  ~ 
				    	<c:choose>
				    		<c:when test = "${!empty board.maxSalary}" >
				    		${board.maxSalary}
				    		</c:when>
				    		<c:otherwise>
				    		0
				    		</c:otherwise>
				    	</c:choose>
				    	<br>
				    	분야 : 
			    		<c:if test = "${!empty board.categoryName}" >
			    			${board.categoryName} 
				    	<br>
			    		</c:if>
				    	근무 형태 : 
				    	<c:choose>
				    		<c:when test = "${!empty board.work}" >
				    		${board.work} 
				    		</c:when>
				    		<c:otherwise>
				    		희망 형태 없음
				    		</c:otherwise>
				    	</c:choose>
				    	<br>
				    	<c:if test = "${!empty board.experience}" >
			    			프리랜서 경험 : ${board.experience} 
				    	 <br>
			    		</c:if>
				    	<c:if test = "${!empty board.skil}" >
			    			스킬 : ${board.skil}
			    		<br>
			    		</c:if>
				    	</c:when>
			    	<c:otherwise>
			    		기업 명 : ${board.companyName}  <br>
			    		담당자 :  ${board.manager} <br>
			    	</c:otherwise>
		    	</c:choose>
				             이메일 : ${board.memberEmail} 
           </div>
	    	<div id="chat-btn">
	    		<button>1:1 채팅하기</button>
	    	</div>
	    </div>
	    
	    <div id="etc-btn">
		    <c:if test="${loginMember.memberNo == board.memberNo }"> 
		    	<div id="btn-size1">
			    	<c:if test="${loginMember.memberNo == board.memberNo}">
			    		<button id="update-btn" onclick="btnAmend();">게시글 수정</button>
			    	</c:if>
			    	<c:if test="${loginMember.memberNo == board.memberNo || memeber.memberId.val('admin')}">
			    		<button id="delete-btn" onclick="btnDeletion();">게시글 삭제</button>
			    	</c:if>
		    	</div>
		    </c:if> 
	    	<div id="btn-size2">
	    	<c:choose>
	    	<c:when test="${memeber.memberId.val('admin')}">
		    	<a href="admin/ComBoardAll?style=${param.style}&cp=${param.cp}">
		    		<button id="return-btn">이전 페이지로 이동</button>
		    	</a>
	    	</c:when>
	    	<c:otherwise>
		    	<a href="board/list?style=${param.style}&cp=${param.cp}">
		    		<button id="return-btn">이전 페이지로 이동</button>
		    	</a>
	    	</c:otherwise>
	    	</c:choose>
	    	</div>
	    </div>
  		<div id="main-btn">
  			<a id="name-btn" href="#con-main-text">제안서</a>
  			<a id="plan-btn" href="#plan-text">제안서 설명</a>
  			<a id="comment-btn" href="#comment-text">댓글</a>
  		</div>
  		<div id="con-main-text">
  			<label id="name-text" class="navi-name">제안서</label>
			<div id="name-con">
				<c:forEach items="${board.atList}" var="at">
						<c:choose>
							<c:when test="${at.fileLevel == 1 && !empty at.fileName}">
								<c:set var="img1" value="${contextPath}/${at.filePath}${at.fileName}"/>
							</c:when>
							<c:when test="${at.fileLevel == 2 && !empty at.fileName}">
								<c:set var="img2" value="${contextPath}/${at.filePath}${at.fileName}"/>
							</c:when>
							<c:when test="${at.fileLevel == 3 && !empty at.fileName}">
								<c:set var="img3" value="${contextPath}/${at.filePath}${at.fileName}"/>
							</c:when>
						</c:choose>
					</c:forEach>
  			</div>
  			<hr id="plan-text">
  			
  			<label class="navi-name">제안서 설명</label>
  			<div id="plan-con">${board.boardContent}</div>
  			
  			<hr id="comment-text">
  			
  			<label  class="navi-name">댓글</label>
  			<div id="comment-con">
  			<jsp:include page="reply.jsp"></jsp:include>
  			</div>
  		
  		</div>
  	</div>
	  <script>
	  
	  /* 스크롤 메뉴 */
      $(document).ready(function() {
             var menu_offset = $('#main-btn').offset();
             $(window).scroll(function() {
               if ($(document).scrollTop() > menu_offset.top) {
                     $('#main-btn').addClass('menu-fixed');
               }else {
                     $('#main-btn').removeClass('menu-fixed');
               }
             });
       });
      
        function btnAmend(){
        	swal({
        		  title: "게시글을 수정하시겠습니까?",
        		  icon: "warning",
        		  buttons: true,
        		  dangerMode: true,
        		})
        };
        function btnDeletion(){
        	swal({
      		  title: "정말로 삭제하시겠습니까?",
      		  icon: "warning",
      		  buttons: true,
      		  dangerMode: true,
      		})
      		.then((willDelete) => {
      		  if (willDelete) {
      		    swal("게시글이 삭제되었습니다.", {
      		      icon: "success",
      		    });
      		  } else {
      		    swal("게시글 삭제를 취소 하였습니다.");
      		  }
      		});
        }
    </script>
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>
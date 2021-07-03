<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>기업 상세</title>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
   	<style>
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
	#img-title{
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
       	width: 100%;
       	height: 80%;
		background-color: rgba(166, 206, 231, 0.2);
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
	  top: 0px;
	  left:5%;
		}
		/* 내용 들어갈 부분*/
		#con-main-text{
			width: 65%;
			height: 69.9%;
			float: left;
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
		}
		#comment-con{
			margin-top: 65px;
			width: 100%;
			height: 20%;
			border: 2px solid rgba(166, 206, 231, 0.7);
		}
	
	</style>
</head>
<body id = "body-top">
	<jsp:include page="../common/header.jsp"/>

  	<div id="container">
  		<div id="con-img">
	        <div id="img-text">
	            <lable id="la1">타이틀</lable>
	            <lable id="la2">조회수 ${board.readCount}</lable>
	        </div>
	        <div id="img-title">
	            <img src="${contextPath}/resources/img/ergate_backgroundnone.png" width="auto" height="100%">
	        </div>
	    </div>
	    <div id="con-text">
	    	<div id="detail-text">
	    		설명 설명~ <br>
	    		
	    	</div>
	    	<div id="chat-btn">
	    		<button>1:1 채팅하기</button>
	    	</div>
	    </div>
	    
	    <div id="etc-btn">
	    	<div id="btn-size1">
	    		<button id="update-btn" onclick="btnAmend();">게시글 수정</button>
	    		<button id="delete-btn" onclick="btnDeletion();">게시글 삭제</button>
	    	</div>
	    	<div id="btn-size2">
	    		<button id="return-btn">이전 페이지로 이동</button>
	    	</div>
	    </div>
  		<div id="main-btn">
  			<a id="name-btn" href="#con-main-text">제안서</a>
  			<a id="plan-btn" href="#plan-text">제안서 설명</a>
  			<a id="comment-btn" href="#comment-text">댓글</a>
  		</div>
  		<div id="con-main-text">
  			<label id="name-text" class="navi-name">제안서</label>
  			<div id="name-con"></div>
  			
  			<hr id="plan-text">
  			
  			<label class="navi-name">제안서 설명</label>
  			<div id="plan-con"></div>
  			
  			<hr id="comment-text">
  			
  			<label  class="navi-name">댓글</label>
  			<div id="comment-con"></div>
  		
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
        	/*// 작성자 본인
        	swal({
        		  title: "게시글을 수정하시겠습니까?",
        		  icon: "warning",
        		  buttons: true,
        		  dangerMode: true,
        		})
        		.then((willDelete) => {
        		  if (willDelete) {
        		    swal("게시글 수정!", {
        		      icon: "success",
        		    });
        		  } else {
        		    swal("게시글 수정을 취소 하였습니다", {
        		      icon: "error",
        		    });
        		  }
        		});
        	*/
        	
        	// 로그인X , 작성자X
        	swal({
			  title: "게시글 작성자만 수정할수 있습니다.",
			  icon: "error",
			  button: "확인",
			});
        	
        };
        function btnDeletion(){
        	/* 작성자 삭제
        	swal({
      		  title: "게시글을 정말 삭제하시겠습니까?",
      		  icon: "warning",
      		  buttons: true,
      		  dangerMode: true,
      		})
      		.then((willDelete) => {
      		  if (willDelete) {
      		    swal("게시글이 삭제되었습니다", {
      		      icon: "success",
      		    });
      		  } else {
      		    swal("게시글 삭제를 취소 하였습니다", {
      		      icon: "error",
      		    });
      		  }
      		}); */
      		
        	// 로그인X , 작성자X
        	swal({
			  title: "게시글 작성자만 삭제할수 있습니다.",
			  icon: "error",
			  button: "확인",
			});
        };
    </script>
	<jsp:include page="../common/footer.jsp"/>

	
</body>
</html>
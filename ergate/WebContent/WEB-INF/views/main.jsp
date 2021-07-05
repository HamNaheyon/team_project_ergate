<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>main</title>
		
		<style>
		
        @font-face {
        font-family: 'MaplestoryOTFBold';
        src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_20-04@2.1/MaplestoryOTFBold.woff') format('woff');
        font-weight: normal;
        font-style: normal;
        }
        .main{
            height: 1000px;
            width: 1200px;
            margin : auto;
            box-sizing: border-box;
        }
        .header{
            height: 10%;
            width: 1200px;
        }
        .content{
            height: 90%;
            width: 100%;
        }
        .logo{
            width: 10%;
            height: 100%;
            float: left;
        }
        #logo_img{
            width: 60%;
        }
        .work_ant{
            text-align: center;
            font-family: 'MaplestoryOTFBold';
            font-size: 30px;
        }
        .bg-image{
            background: no-repeat center center scroll;
            height: 100%;
            width: 100%;
        }

        
        div.bg-image{
            height: 60%;
            width: 100%;
        }
        .include-header{
        	width :100%;
        	height: 250px;
        	text-align: center;
        }
    </style>
</head>
<body>
    <!-- header 들어갈 부분 -->
	<div class="main-container">
		<div class="include-header">
		<!--부트스트랩 CSS 추가 코드가 작성되어있다. -->
		  <jsp:include page="common/header.jsp"/>
		</div>
		<style>
  		.btn{
            color: black;
            width: 100pt;
            height: 90pt;
            background-color: #e1e1e1;
            border: 4px solid rgb(107, 140, 172);
            border-radius: 8px;
        }
        .btn:hover{
            box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24), 0 17px 50px 0 rgba(0,0,0,0.19);
        }
        .btn-com{
            position: relative;
            bottom: 430px;
            left: 520px;
        }
        
        .btn-fre{
            position: relative;
            bottom: 430px;
            left: 450px;
            text-align: center;
        }
		</style>
	    <div class="main">
	        <!-- 메인 화면 이미지 -->
	        <div class="content">
	           <div class="bg-image"><img src="${contextPath}/resources/img/main.png" style="padding-left: 140px;">
	                <!-- 로그인 버튼 -->
	                <button class="btn-fre btn" onclick="location.href='${contextPath}/board/list?style=1'">제안서</button>
	                <button class="btn-com btn" onclick="location.href='${contextPath}/board/list?style=2'">포트폴리오</button>
	            </div>
	        </div>
	    </div>
	</div>
        <!-- footer 들어갈 부분 -->
	<jsp:include page="common/footer.jsp"/>
   
</body>
</html>
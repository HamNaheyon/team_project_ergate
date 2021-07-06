<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" scope="application" value="${ pageContext.servletContext.contextPath }" />
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>header</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <!-- sweetalert -->
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
</head>
<style>
    .wrap {
        height: 100%;
        width: 100%;
        background-position: center;
        background-size: cover;
        position: absolute;
    }

    .form-wrap {
        width: 380px;
        height: 480px;
        position: relative;
        margin: 6% auto;
        background: #fff;
        padding: 5px;
        overflow: hidden;
    }

    .button-wrap {
        width: 230px;
        margin: 35px auto;
        position: relative;
        border-radius: 30px;
    }

    .togglebtn {
        padding: 10px 30px;
        cursor: pointer;
        background: transparent;
        border: 0;
        outline: none;
        position: relative;
    }

    #btn {
        top: 0;
        left: 0;
        position: absolute;
        width: 110px;
        height: 100%;
        background-color: rgba(178, 204, 255, 0.5);
        border-radius: 30px;
        transition: .5s;
    }

    .input-group {
        top: 180px;
        position: absolute;
        width: 280px;
        transition: .5s;
    }

    .input-field {
        width: 100%;
        padding: 10px 0;
        margin: 5px 0;
        border: none;
        border-bottom: 1px solid #999;
        outline: none;
        background: transparent;
    }

    .submit {
        width: 85%;
        padding: 10px 30px;
        cursor: pointer;
        display: block;
        border: 0;
        outline: none;
        border-radius: 3px;
        margin-left: 30px;
    }

    #login {
        left: 50px;
    }

    #p-login {
        left: 450px;
    }

    @font-face {
        font-family: 'MaplestoryOTFBold';
        src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_20-04@2.1/MaplestoryOTFBold.woff') format('woff');
        font-weight: normal;
        font-style: normal;
    }

    div {
        /* border:1px solid rgb(166,206,231); */
        box-sizing: border-box;
    }
    /*************  *************/
    .header {
        width: 100%;
        height: 120px;
    }

    .header-1 {
        width: 100%;
        height: 28%;
        background-color: rgb(166, 206, 231);
    }

    #header-menu {
        list-style-type: none;
        width: 100%;
        height: 100%;
    }

    #header-menu>li {
        width: 20%;
        height: 100%;
        float: right;
        text-align: center;
        line-height: 36.844px;
    }

    #header-menu>li>a {
        width: 100%;
        height: 100%;


        color: white;
        font-weight: 550;
        font-size: 18px;
    }

    #header-menu li a:hover {
        background-color: rgb(132, 176, 204);
        cursor:pointer;
    }

    /************* 타이틀 *************/
    .header-2 {
        width: 100%;
        height: 72%;
        padding: 10px;
    }

    #maintitle {
    
    	margin-top : 50px;
        display: block; 
        margin: 0px auto; 
    }
    .login{
        margin-left: 65px;
        margin-bottom: 15px;
        margin-top: 15px;
        font-size: 17px;
        cursor: pointer;
        border-radius: 8px;
    }
    .signUp{
        margin-left: 65px;
        font-size: 17px;
        padding: 10px 30px;
        cursor: pointer;
        border-radius: 8px;
    }
</style>

<body>

   		
        <div class="header">
 	        <!-- 로그인 여부에 따라서 로그인 창 숨기기 -->
 	        
            <div class="header-1">
                <ul id="header-menu">
       
       		<c:choose>
       				<c:when test="${empty freLoginMember && empty comLoginMember && empty admin}">
                    <li> <a data-bs-toggle="modal" data-bs-target="#exampleModal">로그인/회원가입</a> </li>
                	</c:when>
                	<c:when test="${!(empty freLoginMember)}">
                    <li><a href="${contextPath}/member/logout">로그아웃</a></li>
	                    <li><a href="${contextPath}/member/fre_myPage">마이페이지</a></li>
                	</c:when>
                	<c:when test="${!(empty comLoginMember)}">
                    <li><a href="${contextPath}/member/logout">로그아웃</a></li>
	                    <li><a href="${contextPath}/member/com_myPage">마이페이지</a></li>
                	</c:when>
                	
                </c:choose>
                </ul>
            </div>
            <div class="header-2 fixing" id="title">
            	<!-- 메인 페이지 이동  -->
                <a href="${contextPath}"><img id="maintitle" src="${contextPath}/resources/img/ergatelogo.png"></a>
            </div>
        </div>
        
        
        
    <!-- Modal -->
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">로그인</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="form-wrap">
                        <div class="button-wrap">
                            <div id="btn"></div>
                            <button type="button" class="togglebtn" onclick="login()">프리랜서</button>
                            <button type="button" class="togglebtn" onclick="com()">기업</button>
                        </div>
                        <form id="login" action="${contextPath}/member/login" method="POST" class="input-group">
                            <input type="text" class="input-field" name="freId" id="freId" placeholder="아이디를 입력하세요" required>
                            <input type="password" class="input-field" name="frePw" id="frePw" placeholder="비밀번호를 입력하세요" required>
                            
                            <div style="text-align: center;">
                                <button type="submit" class="submit login">프리랜서 로그인</button>
                                <button type="button" class="submit signUp" onclick="location.href='${contextPath}/member/fre_signUp_Required'">회원가입</button>
                            </div>
                        </form>
                        <form id="p-login" action="${contextPath}/member/login" method="POST" class="input-group">
                            <input type="text" class="input-field" name="comId" id="comId" placeholder="아이디를 입력하세요" required>
                            <input type="password" class="input-field" name="comPw" id="comPw" placeholder="비밀번호를 입력하세요" required>
                            <div style="text-align: center;">
                                <button type="submit" class="submit login">기업 로그인</button>
                                <button type="button" class="submit signUp" onclick="location.href='${contextPath}/member/com_signUp'">회원가입</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    	<%-- 로그인 실패와 같은 메세지가 서버로부터 전달되어 온 경우 출력 --%>
	<c:if test="${ !empty title }">
		<script>
			swal({
				"icon"  : "${icon}",
				"title" : "${title}",
				"text"  : "${text}"
			});
		</script>	
		<%-- 특정 스코프에 있는 속성(번수)를 제거할 수 있음 --%>
		<%-- 서버로부터 전달 받은 메세지를 1회 출력 후 제거 -> 반복 출력 되지 않음 --%>
		<c:remove var="icon"/>
		<c:remove var="title"/>
		<c:remove var="text"/>
	</c:if>
    <script>
        var x = document.getElementById("login");
        var y = document.getElementById("p-login");
        var z = document.getElementById("btn");


        function login() {
            x.style.left = "50px";
            y.style.left = "450px";
            z.style.left = "0";
        }

        function com() {
            x.style.left = "-400px";
            y.style.left = "50px";
            z.style.left = "110px";
        }
    </script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
        crossorigin="anonymous"></script>
</body>

</html>
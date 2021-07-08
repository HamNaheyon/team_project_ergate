<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>기업 회원가입(필수)</title>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <style>
       	input[type="number"]::-webkit-outer-spin-button, input[type="number"]::-webkit-inner-spin-button
		{
		-webkit-appearance: none;
		margin: 0;
		}
        body {
            min-height: 100vh;

            background-color: rgb(166, 206, 231);
        }

        .input-form {
            max-width: 680px;

            margin-top: 80px;
            padding: 32px;

            background: #fff;
            -webkit-border-radius: 10px;
            -moz-border-radius: 10px;
            border-radius: 10px;
            -webkit-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
            -moz-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
            box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15)
        }

        .btn {
            background-color: #e1e1e1;
            color: black;
            border-radius: 3px;
            border: 2px solid rgb(107, 140, 172);

        }

        .btn:hover {
            background-color: #e1e1e1;
            border: 2px solid rgb(107, 140, 172);
            color: black;
            box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24), 0 17px 50px 0 rgba(0,0,0,0.19);
        }
    </style>
</head>

<body>
    <jsp:include page="../common/header.jsp"/>
        <div class="input-form-backgroud row">
                <form class="validation-form" method="POST" action="com_signUp" onsubmit="return validate();">
            <div class="input-form col-md-12 mx-auto">
                <h4 class="mb-3">회원가입</h4>
                <br>
                <hr>
                    <!-- 담당자 -->
                    <div class="row mb-3 form-row">
                        <div class="col-md-3">
                            <label for="manager">담당자</label>
                        </div>
                        <div class="col-md-6">
                            <input type="text" class="form-control" id="manager" name="manager" >
                        </div>
                        <div class="col-md-6 offset-md-3">
                            <span id="checkManager">&nbsp;</span>
                        </div>

                    </div>

                    <!-- 전화번호 -->
                    <div class="row mb-3 form-row">
                        <div class="col-md-3">
                            <label for="phone1">전화번호</label>
                        </div>
                        <!-- 전화번호1 -->
                        <div class="col-md-3">
                            <select class="custom-select" id="phone1" name="phone" >
                                <option>010</option>
                                <option>011</option>
                                <option>016</option>
                                <option>017</option>
                                <option>019</option>
                            </select>
                        </div>

                        <!-- 전화번호2 -->
                        <div class="col-md-3">
                            <input type="number" class="form-control phone" id="phone2" name="phone" >
                        </div>

                        <!-- 전화번호3 -->
                        <div class="col-md-3">
                            <input type="number" class="form-control phone" id="phone3" name="phone" >
                        </div>

                        <div class="col-md-6 offset-md-3">
                            <span id="checkPhone">&nbsp;</span>
                        </div>
                    </div>
                    
                    <!-- 주민번호 -->
                    <div class="row mb-3 form-row">
                    	<div class="col-md-3">
                            <label for="juminNum1">주민번호</label>
                        </div>
                        <!-- 주민번호2 -->
                        <div class="col-md-3">
                            <input type="number" class="form-control jumin" id="juminNum1" name="juminNum" >
                        </div>

                        <!-- 주민번호3 -->
                        <div class="col-md-3">
                            <input type="number" class="form-control jumin" id="juminNum2" name="juminNum" >
                        </div>
                        <div class="col-md-6 offset-md-3">
                            <span id="checkJumin">&nbsp;</span>
                        </div>
                    </div>
					<br>
                    <!-- 이메일 -->
                    <div class="row mb-3 form-row">
                        <div class="col-md-3">
                            <label for="email">Email</label>
                        </div>
                        <div class="col-md-6">
                            <input type="email" class="form-control" id="email" name="email" autocomplete="off"
                                >
                        </div>

                        <div class="col-md-6 offset-md-3">
                            <span id="checkEmail">&nbsp;</span>
                        </div>
                    </div>

                    <!-- 기업명 -->
                    <div class="row mb-3 form-row">
                        <div class="col-md-3">
                            <label for="company">기업 명</label>
                        </div>
                        <div class="col-md-6">
                            <input type="text" class="form-control" id="company" name="company" >
                        </div>
						<br>
                    </div>
					<br> <br>
                    <!-- 사업자 번호 -->
                    <div class="row mb-3 form-row">
                        <div class="col-md-3">
                            <label for="companyNo">사업자 번호</label>
                        </div>
                        <div class="col-md-6">
                            <input type="text" class="form-control" id="companyNo" name="companyNo" >
                        </div>

                    </div>
                    <hr>
                    <!-- 아이디 -->
                    <div class="row mb-5 form-row">
                        <div class="col-md-3">
                            <label for="id">아이디</label>
                        </div>
                        <div class="col-md-6">
                            <input type="text" class="form-control" name="id" id="id" maxlength="12"
                                placeholder="아이디를 입력하세요" autocomplete="off" >
                            <!--  : 필수 입력 항목으로 지정 -->
                            <!-- autocomplete="off" : input 태그 자동완성 기능을 끔 -->

                            <!-- 팝업창 중복체크 여부 판단을 위한 hidden 타입 요소 -->
                            <input type="hidden" name="idDup" id="idDup" value="false">
                        </div>

                        <!-- ajax 중복검사 시 필요없음 -->

                        <div class="col-md-6 offset-md-3">
                            <span id="checkId">&nbsp;</span>
                        </div>
                    </div>


                    <!-- 비밀번호 -->
                    <div class="row mb-3 form-row">
                        <div class="col-md-3">
                            <label for="pwd1">비밀번호</label>
                        </div>
                        <div class="col-md-6">
                            <input type="password" class="form-control" id="pwd1" name="pwd1" maxlength="20"
                                placeholder="비밀번호를 입력하세요" >
                        </div>

                        <div class="col-md-6 offset-md-3">
                            <span id="checkPwd1">&nbsp;</span>
                        </div>
                    </div>


                    <!-- 비밀번호 확인 -->
                    <div class="row mb-3 form-row">
                        <div class="col-md-3">
                            <label for="pwd2">비밀번호 확인</label>
                        </div>
                        <div class="col-md-6">
                            <input type="password" class="form-control" id="pwd2" maxlength="20" placeholder="비밀번호 확인">
                        </div>
                       	

                        <div class="col-md-6 offset-md-3">
                            <span id="checkPwd2">&nbsp;</span>
                        </div>
                    </div>
                    <br>
                    <hr>
                        <input type="checkbox" name="agree" id="agree"
						class="form-check-input custom-control-input">
					<label class="form-check-label custom-control-label"
						for="agree">개인정보 수집에 동의하시겠습니까?</label>
                    <button class="btn btn-primary btn-lg btn-block" type="submit">가입하기</button>
                </form>
            </div>
        </div>
        <jsp:include page="../common/footer.jsp"/>
    <script src="${contextPath}/resources/js/com_member.js"></script>
</body>

</html>
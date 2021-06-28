<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<jsp:include page="../common/header.jsp"/>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>프리랜서 회원(필수)</title>

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
        .btn{
            background-color: #e1e1e1; 
            color: black;
            border-radius: 3px;
            border: 2px solid rgb(107, 140, 172);

        }
        .btn:hover{
            background-color: rgb(132, 176, 204);
            border: 2px solid rgba(107, 140, 172, 0.5);
            color: black;
        }
        .btn-success{
          background-color: rgb(132, 176, 204);;
        }
        #signUp2{
        	display: none;
        }
    </style>
</head>

<body>
    <div class="container">
        <div class="input-form-backgroud row">
                <form class="validation-form" method="POST" action="fre_signUp_Required" novalidate>
            <div class="input-form col-md-12 mx-auto" id="signUp1">
                <h4 class="mb-3">회원가입(필수)</h4>
                <br> <hr>
                    <!-- 이름 -->
                    <div class="row mb-3 form-row">
                        <div class="col-md-3">
                            <label for="name">* 이름</label>
                        </div>
                        <div class="col-md-6">
                            <input type="text" class="form-control" id="name" name="name" >
                        </div>

                        <div class="col-md-6 offset-md-3">
                            <span id="checkName">&nbsp;</span>
                        </div>
                    </div>
					
                    <!-- 전화번호 -->
                    <div class="row mb-3 form-row">
                        <div class="col-md-3">
                            <label for="phone1">* 전화번호</label>
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
                            <label for="email">* Email</label>
                        </div>
                        <div class="col-md-6">
                            <input type="email" class="form-control" id="email" name="email" autocomplete="off"
                                >
                        </div>

                        <div class="col-md-6 offset-md-3">
                            <span id="checkEmail">&nbsp;</span>
                        </div>
                    </div>
                    
					<hr>
                    <!-- 아이디 -->
                    <div class="row mb-5 form-row">
                        <div class="col-md-3">
                            <label for="id">* 아이디</label>
                        </div>
                        <div class="col-md-6">
                            <input type="text" class="form-control" name="id" id="id" maxlength="12"
                                placeholder="아이디를 입력하세요" autocomplete="off" >

                        </div>

                        <div class="col-md-6 offset-md-3">
                            <span id="checkId">&nbsp;</span>
                        </div>
                    </div>


                    <!-- 비밀번호 -->
                    <div class="row mb-3 form-row">
                        <div class="col-md-3">
                            <label for="pwd1">* 비밀번호</label>
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
                            <label for="pwd2">* 비밀번호 확인</label>
                        </div>
                        <div class="col-md-6">
                            <input type="password" class="form-control" id="pwd2" maxlength="20" placeholder="비밀번호 확인"
                                >
                        </div>

                        <div class="col-md-6 offset-md-3">
                            <span id="checkPwd2">&nbsp;</span>
                        </div>
                    </div>
                    <button type="button" class="btn btn-primary float-right" data-toggle="button" aria-pressed="false" id="next">
                        	다음으로
                      </button>
                      <br> <br>  <hr>
                    <div class="custom-control custom-checkbox">
                        <input type="checkbox" class="custom-control-input" id="aggrement" >
                        <label class="custom-control-label" for="aggrement">개인정보 수집 및 이용에 동의합니다.</label>
                    </div>
                    <div class="mb-4"></div>
                    <button class="btn btn-primary btn-lg btn-block" type="submit">가입하기</button>
            </div>
                    
                    
             <div class="input-form col-md-12 mx-auto" id="signUp2">
                <h4 class="mb-3">회원가입(선택)</h4>
                
                <br> <hr>
                    <!-- 연락 가능 시간 1 -->
                    <div class="row mb-3 form-row">
                        <div class="col-md-3">
                            <label for="time">연락 가능 시간</label>
                        </div>
                        <div class="col-md-3">
                            <input type="time" class="form-control" id="time1" name="time1">
                        </div>
                        ~
                        <div class="col-md-3"> 
                            <input type="time" class="form-control" id="time2" name="time2">
                        </div>
                    </div>
                    <br>
                    <!-- 희망 급여 -->
                    <div class="row mb-3 form-row">
                        <div class="col-md-3">
                            <label for="salary">희망 급여</label>
                        </div>

                        <!-- 희망 급여 1 -->
                        <div class="col-md-3">
                            <input type="number" class="form-control salary" id="salary1" name="salary1" required>
                        </div>
                        ~
                        <!-- 희망급여 2 -->
                        <div class="col-md-3">
                            <input type="number" class="form-control salary" id="salary2" name="salary2" required>
                        </div>

                    </div>
                    <br>
					<div class="row mb-3 form-row">
						<div class="col-md-3">
							<label for="feild">분야</label>
						</div>
						<!-- 분야 -->
						<div class="col-md-3">
							<select class="custom-select" id="feild" name="feild">
							<option value="none">=== 선택 ===</option>
								<option>웹개발</option>
								<option>앱개발</option>
							</select>
						</div>
                        <div class="col-md-3">
							<label for="work">근무 형태</label>
						</div>
						<!-- 근무 형태 -->
						<div class="col-md-3">
							<select class="custom-select" id="work" name="work">
							<option value="none">=== 선택 ===</option>
								<option>자가</option>
								<option>회사</option>
							</select>
						</div>
                    </div>
                    <br>
					<div class="row mb-3 form-row">
						<div class="col-md-3">
							<label for="experience">프리랜서 경험</label>
						</div>
						<!-- 분야 -->
						<div class="col-md-3">
							<select class="custom-select" id="experience" name="experience">
							<option value="none">=== 선택 ===</option>
								<option>있습니다</option>
								<option>없습니다</option>
							</select>
						</div>
                        <div class="col-md-3">
							<label for="skil">스킬</label>
						</div>
						<!-- 근무 형태 -->
						<div class="col-md-3">
							<select class="custom-select" id="skil" name="skil">
							<option value="none">=== 선택 ===</option>
								<option>C</option>
								<option>Python</option>
								<option>Java</option>
								<option>C++</option>
								<option>C#</option>
								<option>Visual Basic</option>
								<option>JavaScript</option>
								<option>PHP</option>
								<option>R</option>
								<option>SQL</option>
							</select>
						</div>
                    </div>
                    <div class="row mb-3 form-row">
                        <div class="col-md-3">
                            <div>
                                <label for="gender">성별</label> <br> <br>
                                <input type="radio" name="gender" id="gender" value="M"> 남
                                <input type="radio" name="gender" id="gender" value="F"> 여
                            </div>
                        </div>
                    </div>
                    <br>
                    <button type="button" class="btn btn-primary float-left" data-toggle="button" aria-pressed="false" id="prev">
                        	이전으로
                      </button>
                      <br> <br>  <hr>
                    <div class="mb-4"></div>
                    <button class="btn btn-primary btn-lg btn-block" type="submit">가입하기</button>
            </div>
            </form>
        </div>
    	<jsp:include page="../common/footer.jsp"/>
    	<script src="${contextPath}/resources/js/member.js"></script>
    </div>
</body>

	<script>
	
	$("#signUp1").show();
	$("#signUp2").hide();
	
	$("#next").on("click",function(){
			
	    $("#signUp1").hide();
		$("#signUp2").show();
	});
	
	$("#prev").on("click",function(){
		
		$("#signUp1").show();
	    $("#signUp2").hide();
		
	});
	
	
	
	</script>









</html>
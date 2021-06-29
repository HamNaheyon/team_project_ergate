<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>기업 회원 탈퇴</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
        integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
        crossorigin="anonymous"></script>
    <style>
        input[type="number"]::-webkit-outer-spin-button,
        input[type="number"]::-webkit-inner-spin-button {
            -webkit-appearance: none;
            margin: 0;
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
            box-shadow: 0 12px 16px 0 rgba(0, 0, 0, 0.24), 0 17px 50px 0 rgba(0, 0, 0, 0.19);
        }
        .container{
            width: 400px;
            height: 400px;
        }
    </style>
</head>

<body>
    <div class="container">
        <jsp:include page="../common/header.jsp"></jsp:include>

		<div class="row my-5">
			<jsp:include page="com_sideMenu.jsp"></jsp:include>

			<div class="col-sm-offset-2 col-sm-8">
                <form class="dropOut-form" action="com_secession" method="POST" onsubmit="return secessionValidate();">
                
                <h4 class="mb-3">탈퇴 하기</h4>
                <br>
                <!-- 아이디 -->
						<div class="row mb-3 form-row">
							<div class="col-md-3">
								<h6>아이디</h6>
							</div>
							<div class="col-md-6">
								<h5 id="id">${comLoginMember.comId }</h5>
							</div>
						</div>

						<!-- 비밀번호 -->
						<div class="row mb-3 form-row">
							<div class="col-md-3">
								<h6>현재 비밀번호</h6>
							</div>
							<div class="col-md-6">
								<input type="password" class="form-control" id="currentPwd"
									name="currentPwd" required>
							</div>
						</div>
             	   <hr>
             	   	<h3>탈퇴 사유</h3>
             	   	<hr>
                    <div class="custom-control custom-radio">
                        <input type="radio" name="jb-radio" id="jb-radio-1" class="custom-control-input">
                        <label class="custom-control-label" for="jb-radio-1">잦은 오류가 발생해요</label>
                    </div>
                    <br>
                    <div class="custom-control custom-radio">
                        <input type="radio" name="jb-radio" id="jb-radio-2" class="custom-control-input">
                        <label class="custom-control-label" for="jb-radio-2">서비스가 마음에 들지 않아요</label>
                    </div>
                    <br>
                    <div class="custom-control custom-radio">
                        <input type="radio" name="jb-radio" id="jb-radio-3" class="custom-control-input">
                        <label class="custom-control-label" for="jb-radio-3">대체할만한 서비스를 찾았어요</label>
                    </div>
                    <br>
                    <div class="custom-control custom-radio">
                        <input type="radio" name="jb-radio" id="jb-radio-4" class="custom-control-input">
                        <label class="custom-control-label" for="jb-radio-4">언제 끝나냐</label>
                    </div>
                    <br>
                    <div class="custom-control custom-radio">
                        <input type="radio" name="jb-radio" id="jb-radio-5" class="custom-control-input">
                        <label class="custom-control-label" for="jb-radio-5">기타</label>
                    </div>
                    <br>
                    <input type="checkbox" name="agree" id="agree"
						class="form-check-input custom-control-input">
						<hr>
					<label class="form-check-label custom-control-label"
						for="agree">정말 탈퇴하시겠습니까?</label>
						<br> <br>
                    <button class="btn btn-primary btn-lg btn-block" type="submit">탈퇴하기</button>
                </form>
				</div>
            </div>
        </div>

    <!-- 콘솔 창으로 회원 탈퇴 시 yes,or 팝업 띄우기 -->
    
    <script>
		// 약관 동의가 체크 되었을 때에만 탈퇴 진행
		function secessionValidate(){
			
		    if(!$("#agree").prop("checked")){
		    	swal({"icon" : "info", "title" : "탈퇴 동의를 체크해주세요"})
			    return false;
		    }
		}
	</script>

</body>

</html>
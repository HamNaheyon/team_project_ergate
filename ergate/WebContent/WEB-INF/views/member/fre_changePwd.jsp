<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>기업 비밀번호 변경</title>
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
			<jsp:include page="sideMenu.jsp"></jsp:include>

			<div class="col-sm-8">
                <h4 class="mb-3">비밀 번호 변경</h4>
                <br>
                <hr>
                <form class="validation-form" method="POST" action="fre_changePwd" onsubmit="return pwdValidate();">
                    <!-- 현재 비밀번호 -->
                    <div class="row mb-3 form-row">
                        <div class="col-md-3">
                            <label for="pwd1">현재 비밀번호</label>
                        </div>
                        <div class="col-md-6">
                            <input type="password" class="form-control" id="currentPwd" name="currentPwd" maxlength="20"
                                placeholder="현재 비밀번호를 입력하세요" required>
                            </div>
                    </div>
                    <!-- 변경 비밀번호 -->
                    <div class="row mb-3 form-row">
                        <div class="col-md-3">
                            <label for="pwd1">변경 비밀번호</label>
                        </div>
                        <div class="col-md-6">
                            <input type="password" class="form-control" id="newPwd1" name="newPwd1" maxlength="20"
                                placeholder="변경 비밀번호를 입력하세요" required>
                        </div>
                    </div>


                    <!-- 변경 비밀번호 확인 -->
                    <div class="row mb-3 form-row">
                        <div class="col-md-3">
                            <label for="pwd2">변경 비밀번호 확인</label>
                        </div>
                        <div class="col-md-6">
                            <input type="password" class="form-control" id="newPwd2" name="newPwd2" maxlength="20" placeholder="비밀번호 확인"
                                required>
                        </div>

                        <div class="col-md-6 offset-md-3">
                            <span id="checkPwd2">&nbsp;</span>
                        </div>
                    </div>
                   
        <button class="btn btn-primary btn-lg btn-block" type="submit">변경하기</button>
        </form>
    </div>
    </div>
    <jsp:include page="../common/footer.jsp"/>
    </div>
</body>

	<script>
		function pwdValidate(){
			
		    const regExp = /^[a-zA-Z0-9\#\-\_]{6,20}$/;
		
		    const newPwd1 = $("#newPwd1").val().trim();
		    const newPwd2 = $("#newPwd2").val().trim();
		    
		    
		    // 새 비밀번호가 유효하지 않거나 새 비밀번호와 새 비밀번호 확인이 같지않은 경우 true
		    if (!regExp.test(newPwd1) || (!newPwd1 == newPwd2)) {
				
		    	swal({
		    		"icon" : "error",
		    		"title" : "비밀번호가 유효하지않습니다."
		    	});
		    	return false;
			}
		}
	</script>

</html>
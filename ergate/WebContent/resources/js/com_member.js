// 회원 가입 유호성 검사

// 각 유효성 검사 결과를 저장할 객체
var checkObj = {
    "id": false,
    "pwd1": false,
    "pwd2": false,
    "name": false,
    "phone2": false,
    "jumin2": false,
    "email": false,
};

// 아이디가 입력될 때 마다 유효성 검사
// 조건 : 영어, 숫자 6~12글자

$("#id").on("input", function () {


    const regExp = /^[a-zA-Z0-9]{5,12}$/;

    const inputId = $("#id").val().trim();

    // 입력된 아이디가 정규식에 일치하는 경우 == 유효한 값인 경우
    if (regExp.test(inputId)) {
        // $("#checkId").text("유효한 아이디입니다.").css("color", "green");
        // checkObj.id = true;

        // Ajax를 이용하여 비동기적으로 아이디 중복 검사를 진행

        // jQuery를 이용한 Ajax
        /* $.ajax({url : "주소", 선택속성 }); */

        $.ajax({
            url: "idDupCheck", // 요청 주소(필수로 작성!)
            data: { "id": inputId }, // 전달하려는 값(파라미터)
            type: "post", // 데이터 전달 방식

            success: function (result) {
                // 매개변수 result : 서버에서 비동기로 전달 받은 응답 데이터
                
                if(result > 0){ // 아이디가 중복되는 경우
                    $("#checkId").text("이미 사용중인 아이디입니다.").css("color", "red");
                    checkObj.id = false;
                }else{ // 아이디가 중복되지 않은 경우
                    $("#checkId").text("사용 가능한 아이디입니다.").css("color", "green");
                    checkObj.id = true;
                }


            }, // 비동기 통신 성공 시 동작
            error: function (e) {
                // 매개 변수 e : 예외 발생 시 Exception 객체를 전달 받은 변수

                console.log("ajax 통신 실패");
                console.log(e);

            } // 비동기 통신 실패 시 동작
        });


    } else {
        $("#checkId").text("영어, 숫자 6~12 글자로 작성해주세요").css("color", "red");
        checkObj.id = false;
    }



});

// 담당자 유효성 검사
// 조건 : 한글 두 글자 이상 5글자 이하 ->  /^[가-힣]{2,5}$/;


// 이메일 유효성 검사
// 조건 : 아이디 4글자 이상, 이메일 형식  ->   /^[\w]{4,}@[\w]+(\.[\w]+){1,3}$/;

$("#manager").on("input", function () {

    const regExp = /^[가-힣]{2,5}$/;

    const inputManager = $("#manager").val().trim();

    if (regExp.test(inputManager)) {
        $("#checkManager").text("유효한 이름 입니다.").css("color", "green");

        checkObj.name = true;
    } else {
        $("#checkManager").text("한글 2~5 글자로 입력해주세요").css("color", "red");

        checkObj.name = false;
    }

});
$("#email").on("input", function () {

    const regExp = /^[\w]{4,}@[\w]+(\.[\w]+){1,3}$/;

    const inputEmail = $("#email").val().trim();

    if (regExp.test(inputEmail)) {
        $("#checkEmail").text("사용 가능한 이메일 입니다.").css("color", "green");
        checkObj.email = true;
    } else {
        $("#checkEmail").text("이메일 형식으로 작성하여주세요").css("color", "red");
        checkObj.email = false;
    }

});

// 비밀번호 유효성 검사
$("#pwd1").on("input", function () {

    const regExp = /^[a-zA-Z0-9~!@#$%^&*()_-]{6,20}$/;

    const inputPw = $(this).val().trim();

    if (regExp.test(inputPw)) {
        $("#checkPwd1").text("사용 가능한 비밀번호 입니다.").css("color", "green");
        checkObj.pwd1 = true;
    } else {
        $("#checkPwd1").text("올바른 비밀번호 형식으로 작성하여주세요").css("color", "red");
        checkObj.pwd1 = false;
    }
});

// 비밀번호, 비밀번호 확인 일치 여부 판단
$("#pwd1, #pwd2").on("input", function () {

    const pwd1 = $("#pwd1").val();
    const pwd2 = $("#pwd2").val();

    if (pwd1.trim() == "" && pwd2.trim() == "") { // 둘다 비었을 떄
        $("#checkPwd1").html("&nbsp;");
        $("#checkPwd2").html("&nbsp;");
        checkObj.pwd2 = false;
    } else if (pwd1 == pwd2) {
        $("#checkPwd2").text("비밀번호 일치").css("color", "green");
        checkObj.pwd2 = true;
    } else {
        $("#checkPwd2").text("비밀번호 불 일치").css("color", "red");
        checkObj.pwd2 = false;
    }


});
// 주민번호 유효성 검사
$(".jumin").on("input", function () {

    // 주민번호 input 태그에 4글자 초과 입력하지 못하게 하는 이벤트
    if ($("#juminNum1").val().length > 6) {
        $("#juminNum1").val($("#juminNum1").val().slice(0, 6));
    }
    if ($("#juminNum2").val().length > 7) {
        $("#juminNum2").val($("#juminNum2").val().slice(0, 7));
    }

    const regExp1 = /^\d{6}$/; // 숫자 3~4 글자
    const regExp2 = /^\d{7}$/; // 숫자 3~4 글자

    const jm1 = $("#juminNum1").val();
    const jm2 = $("#juminNum2").val();

    if (regExp1.test(jm1) && regExp2.test(jm2)) {
        $("#checkJumin").text("유효한 주민번호 형식입니다.").css("color", "green");
        checkObj.jumin2 = true;
    } else {
        $("#checkJumin").text("주민번호가 유효하지않습니다..").css("color", "red");
        checkObj.jumin2 = false;
    }
});

$(".phone").on("input", function () {

    // 전화번호 input 태그에 4글자 초과 입력하지 못하게 하는 이벤트
    if ($(this).val().length > 4) {
        $(this).val($(this).val().slice(0, 4));
    }

    const regExp1 = /^\d{3,4}$/; // 숫자 3~4 글자
    const regExp2 = /^\d{4}$/; // 숫자 3~4 글자

    const ph2 = $("#phone2").val();
    const ph3 = $("#phone3").val();

    if (regExp1.test(ph2) && regExp2.test(ph3)) {
        $("#checkPhone").text("유효한 전화번호 형식입니다.").css("color", "green");
        checkObj.phone2 = true;
    } else {
        $("#checkPhone").text("전화번호가 유효하지않습니다..").css("color", "red");
        checkObj.phone2 = false;
    }
});

// 회원가입 버튼 클릭 시 전체 유효성 검사 여부 확인
function validate() {

	 if(!$("#agree").prop("checked")){
    	swal({"icon" : "info", "title" : "개인정보 동의를 체크해주세요"})
	    return false;
    }
	
	
    for (const key in checkObj) {

        if (!checkObj[key]) { //  false 값을 가진 속성이 있을 경우

            let msg;
            switch (key) {
                case "id":
                    msg = "아이디가 유효하지 않습니다.";
                    break;
                case "pwd1":
                    msg = "비밀번호가 유효하지 않습니다.";
                    break;
                case "pwd2":
                    msg = "비밀번호가 일치하지 않습니다. ";
                    break;
                case "name":
                    msg = "담당자 이름이 유효하지 않습니다.";
                    break;
                case "phone2":
                    msg = "전화번호가 유효하지 않습니다. ";
                    break;
                case "email":
                    msg = "이메일이 유효하지 않습니다.";
                    break;
                case "jumin2":
                    msg = "주민번호가 유효하지 않습니다."
					break;
            }
            swal(msg).then(function () {

                const selector = "#" + key;

                $(selector).focus();
            });
			
			// 주석			
            return false; // submit 이벤트 제거(회원가입 실행 X)
        }
    }





}
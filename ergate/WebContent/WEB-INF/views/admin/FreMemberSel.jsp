<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <jsp:include page="../common/side.jsp"></jsp:include>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>html문서 제목</title>
    <style>
    
      .but-style{
            background-color: white; color:rgb(166  , 206, 231); font-weight: bold;
            border-color: rgb(166  , 206, 231);
            border-radius: 12px;
        }
        div{
        box-sizing:border-box;
        }
        #main-sel{
            background-color : white;
            box-sizing: border-box;
            margin: auto;
            border: 1px solid black;
            width: 85%;
            height: 500px;
            color: rgb(166  , 206, 231);
            float:left;
        
        }
        input{
            color: rgb(166  , 206, 231);
        }
        button{
            text-align: center;
        }
        #vlf{
            border: 1px solid black;
            box-sizing: border-box;
            width: 50%;
            height: 100%;
           
            float: left;
            font-size: 20px;
            
        }
        #tjs{
            border: 1px solid black;
            box-sizing: border-box;
            width: 50%;
            float:left;
            height: 100%;
        
           
        }
        input{
            font-size: 20px;
            border: 0px;
        }
    </style>
</head>
<body>
    <div id="main-sel">
        <div id="vlf">
            <h1>필수 사항</h1>
            이름 : <input type="text" value="백기훈" readonly> <br><br>
            휴대폰 번호 : <input type="text" value="000-0000-0000" readonly><br><br>
            이메일 : <input type="text" value="qqq@naver.com" readonly><br><br>
            아이디 : <input type="text" value="acnb37" readonly><br><br>
            주민번호 : <input type="text" value="123456-1234567" readonly><br><br>
            개인정보 유효기간 : <input type="text" value="x년" readonly>
        </div>
        <div id="tjs">
            <h1>선택 사항</h1>
            경력 : <input type="text" value="0년" readonly> <br><br>
            근무 형태 : <input type="text" value="자택근무" readonly> <br><br>
            희망 급여 : <input type="text" value="천억우너" readonly> <br><br>
            프로젝트 시작 가능일 : <input type="text" value="00/00/00~" readonly> <br><br>
            스킬 : <input type="text" value="자바스크립트,자바,c언어,리눅스,유닉스,오라클sql" readonly> <br><br>
            첨부파일 : <input type="text" value="포트폴리오.hwp" readonly> <br><br>
           
        </div>
    </div>
    <div style="text-align: center;">
        <button onclick="history.go(-1)">목록으로</button>
    </div>
    
</body>
</html>
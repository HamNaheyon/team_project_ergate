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
            담당자 : <input type="text" value="백기훈" readonly> <br><br>
            휴대폰 번호 : <input type="text" value="000-0000-0000" readonly><br><br>
            이메일 : <input type="text" value="qqq@naver.com" readonly><br><br>
            아이디 : <input type="text" value="acnb37" readonly><br><br>
            상호명 : <input type="text" value="백기훈컴퍼니" readonly><br><br>
            사업자 번호 : <input type="text" value="415-15-12345" readonly><br><br>
            개인정보 유효기간 : <input type="text" value="x년" readonly>
        </div>
        <div id="tjs">
            <h1>선택 사항</h1>
            첨부파일 : <input type="text" value="제안서.hwp,본인 사진.hwp" readonly> <br><br>
           
        </div>
    </div>
    <div style="text-align: center;">
        <button onclick="history.go(-1)" class="but-style">목록으로</button>
    </div>
    
</body>
</html>
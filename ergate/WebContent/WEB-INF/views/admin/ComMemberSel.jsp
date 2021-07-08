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
     a{
       text-decoration: none;}
      #qq:hover{
       color :white;
       }
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
            height: 800px;
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
            아이디 : ${adminMember.memberId }<br><br>
            담당자 : ${adminMember.manager }<br><br>
            전화번호 : ${adminMember.memberPhone }<br><br>
            이메일 : ${adminMember.memberEmail }<br><br>
            가입일 : ${adminMember.enrollDate }<br><br>
            탈퇴여부(정상:Y,탈퇴:N) : ${adminMember.memberStatus }<br><br>
            상호명 : ${adminMember.companyName}<br><br>
            사업자 번호 : ${adminMember.companyNo }<br><br>
         
        </div>
        <div id="tjs">
           
        </div>
    </div>
    <div style="text-align: center;">
        <button onclick="history.go(-1)" class="but-style">목록으로</button>
    </div>
    
</body>
</html>
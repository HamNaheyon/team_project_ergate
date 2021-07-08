<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
        div{ box-sizing: border-box;
       
        }
        #main {
            margin: auto;
            
            width: 100%;
            height: 870px;
        }
        #h{
            padding-top: 100px;
            width: 100%;
            height: 10%;
        }
        #a{
            width: 100%;
            height: 20%;
        }
        #content{
            width: 100%;
            height: 60%;
        }
        #muk{
            width: 100%;
            height: 10%;
        }
        #q{
            padding-top: 60px;
            
            width: 50%;
            height: 100%;
            font-size: 20px;
            display: inline-block;
            float: left;
        }
        #w{
            padding-top: 145px;
            width: 50%;
            height: 100%;
            font-size: 20px;
            display: inline-block;
            float: left;
        }
        input{
          
            font-size: 20px;
            border: 0px;
        }
    </style>
</head>

<body>
    <div id="main">
        <div id="h" style="text-align: center;"><h1>${aq.questionTitle}</h1></div>
        <div id="a">
            <div id="q">
                게시글 번호 : ${aq.questionNo}<br>
                아이디 : ${aq.memberId}<br>
                이메일 : ${aq.memberEmail}<br>
                회원 타입 : ${aq.memberGrade }<br>
            </div>
            <div id="w">
                <div style="float: right;">신청 날짜 :${aq.questionDate}<br></div>
                
            </div>
        </div>
        <div id="content" style="border: 2px solid black;">${aq.questionContent}</div>
        <div id="muk" style="text-align: center;">
            <button onclick="back();">목록으로</button>
        </div>
    </div>
    
    <script>
    function back(){
    	location.href = "${contextPath}/admin/qusetions?cp="+${param.cp};
    }
    </script>
</body>

</html>
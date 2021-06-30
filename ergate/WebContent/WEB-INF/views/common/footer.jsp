<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>footer</title>
<style>
    div{
        /* border:1px solid rgb(166,206,231); */
        box-sizing:border-box;
    }
    .container{
        position:absolute;
    }

    /*************  *************/
    .footer{
        height:170px;
        background-color:rgb(166,206,231);
    }
    .footer-1{
        width:100%;
        height:30%;
        border-bottom:2px solid white;
    }
    /************* 서브로고 이용약관 개인정보처리방침 *************/
    .footer1{
        height:100%;
        float:left; 
        margin: 10px;      
    }
    .tos{
        font-size: 140%;
        font-weight: bold;
    }
    .pp{
        font-size: 140%;
        font-weight: bold;
    }

    /************* 문의사항 *************/
    .questions{
        float:right;
        text-align:center;
        font-size: 140%;
        font-weight: bold;
    }
    /* .questions h4{
        margin-top:21.280px;
    } */

    /************* 사업자정보 *************/
    .footer-2{
        width:100%;
        height:70%;
    }
    .footer-2 h5{
        margin-left:15px;
        /* margin-top:22.178px; */
        margin-top:13px;
        margin-bottom:13px;
    }
    a{
    	color: black;
        text-decoration-line : none;
    }
    a:hover{
    	color: black;
        text-decoration-line : none;
    }
</style>
</head>
<body>
    <div>
        <div class="footer">
            <div class="footer-1">
                <div class="footer1 subtl">
                    <img id="sublogo" src="${contextPath}/resources/img/subtitle.png" style="width:100px;">
                </div>
                <div class="footer1 tos">이용약관</div>
                <div class="footer1 pp">개인정보처리방침</div>
                <div class="footer1 questions"><a href="questions">문의사항</a></div>
            </div>
            <div class="footer-2">
                <h5>
                    ㈜일개미 (대표이사:일개미) | 서울특별시 중구 남대문로 120 대일빌딩 2F, 3F<br>
                    사업자등록번호 : 851-87-00622<br>
                    서비스 및 기업문의 1544-9970<br>
                    © 2021 Ergate, Inc.<br>
                </h5>
            </div>
        </div>
    </div>
</body>
</html>
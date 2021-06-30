<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>채팅목록</title>

    <style>
        
        div{
            /* border : 1px solid rgb(166,206,231); */
            box-sizing: border-box;
        }
        .container {
            width: 500px;
            height: 700px;
            margin: auto;
        }
        .body{
            width : 100%;
            height : 90%;
            border:4px solid rgb(166,206,231);
        }
        .body > table {
            width: 95%;
            height: 95%;
        }

        .list{
            width : 80%;
            height : 15%;
        }
        .footer{
            width:100%;
            height:10%;
        }
        .footer > button{
            width : 100%;
            height : 100%;

            font-size : 16px;
            border:4px solid rgb(166,206,231);
            background-color : rgb(166,206,231);
        }
        .footer > button:hover{
            border:4px solid rgb(132, 176, 204);
            background-color:rgb(132, 176, 204);
        }

    </style>
</head>
<body>
    <div class="container">
        <div class="body">
            <table>
                <tr>
                    <td width = "20px;"><input type="checkbox"  class="list" ></td>
                    <td width = "100px;"><div class="list">백기훈</div></td>
                </tr>
                <tr>
                    <td width = "20px;"><input type="checkbox"  class="list" ></td>
                    <td width = "100px;"><div class="list">정민서</div></td>
                </tr>
                <tr>
                    <td width = "20px;"><input type="checkbox"  class="list" ></td>
                    <td width = "100px;"><div class="list">하지인</div></td>
                </tr>
                <tr>
                    <td width = "20px;"><input type="checkbox"  class="list" ></td>
                    <td width = "100px;"><div class="list">함나현</div></td>
                </tr>
                <tr>
                    <td width = "20px;"><input type="checkbox"  class="list" ></td>
                    <td width = "100px;"><div class="list">함나현</div></td>
                </tr>
                <tr>
                    <td width = "20px;"><input type="checkbox"  class="list" ></td>
                    <td width = "100px;"><div class="list">함나현</div></td>
                </tr>
                <tr>
                    <td width = "20px;"><input type="checkbox"  class="list" ></td>
                    <td width = "100px;"><div class="list">함나현</div></td>
                </tr>

            </table>
            
        </div>
        <div class="footer">
            <button type="button" name="delete">채팅나가기</button>
        </div>
    </div>
    
</body>
</html>
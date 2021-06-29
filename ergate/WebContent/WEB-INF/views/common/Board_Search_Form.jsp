<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>board_search_form</title>

	<%-- <link rel = "stylesheet" type = "text/css" href = "${contextPath}/resources/css/Board_Search_Form.css"> --%>

    <style>

        div{
            /* border:1px solid rgb(166,206,231); */
            box-sizing:border-box;
        }
        .ncontainer{
            height:70px;
        }
        .nav-empty{
            width:30%;
            height:100%;
            float:left;
        }

        .nav-search{
            width:40%;
            height:100%;
            float:left;
            position:relative;
        }

        .iparea{
            width:70%;
            height:100%;
            float:left;
        }
        .btnarea{
            width:30%;
            height:100%;
            float:left;
        }

        .iparea > input{
            width:100%;
            height:100%;
            border:3px solid rgb(166,206,231);
            box-sizing:border-box;
        }
        .iparea > input:hover{
            border:3px solid rgb(132, 176, 204);
        }
        .btnarea > button{
            width:100%;
            height:100%;
            border:3px solid rgb(166,206,231);
            background-color:rgb(166,206,231);
        }
        .btnarea > button > img{
            height:100%;
        }
        .btnarea > button:hover{
            border:3px solid rgb(132, 176, 204);
            background-color:rgb(132, 176, 204);
        }
        #ncontainer{
            position:absolute;
            height:60%;
            
            top : 0;
            bottom : 0;
            left : 0;
            right : 0;
            margin : auto;
        }

    </style>
</head>
<body>
    <div class="ncontainer">
        <div class="nav-empty"></div>
        <div class="nav-search">
            <form id="ncontainer">
                <div class="iparea">
                    <input type = "search" name = "searchValue">
                </div>
                <div class="btnarea">
                    <button id="searchbtn">
                        <img src = "images/MagnifyingGlass_white.png">
                    </button>
                </div>
            </form>
        </div>
        <div class="nav-empty"></div>
    </div>
</body>
</html>
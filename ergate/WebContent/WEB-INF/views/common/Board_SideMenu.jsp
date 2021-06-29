<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Board_SideMenu</title>

	<%-- <link rel = "stylesheet" type = "text/css" href = "${contextPath}/resources/css/BoardSideMenu.css"> --%>
	
    <style>
        div{
            /* border:1px solid rgb(166,206,231); */
            box-sizing:border-box;
        }
        .smcontainer{
        	width:15%;
        	height:100%;
            border-right:1px solid rgb(166,206,231);
            float:left;
        }
        /************* 웹개발자 앱개발자 게시글 작성 *************/
        .smboardtypeNM{
            width:50%;
            float:left;

            background-color:rgb(166,206,231);
            border:1px solid white;
            width:50%;
            height:100%;
            float:left;
            text-align:center;
        }

        .smboardtypeNM a{
            width:100%;
            height:100%;
            color:white;
            display : inline-block;
            text-decoration : none; 
            text-align : center;

            font-weight : 550;
            font-size : 20px;

            margin-top:4px;
            margin-bottom:4px;
        }
        .smboardtypeNM a:hover{
            background-color:rgb(132, 176, 204);
        }

        .boardcategory > div > a{
            margin-top:5px;
            font-size:23px;
        }


        /************* 웹개발자 앱개발자 게시글 작성 *************/

        .boardcategory > div > a{
            display:inline-block;
            text-decoration:none; 
            margin-left:10px;
        }
        .posting{
            border:1px solid white;
            width:100%;
            height:4%;
            float:left;
            background:rgb(166,206,231);
            text-align:center;
            margin-top:20px;
        }
        .posting > a{
            color:white;
            
            text-decoration : none; 
            font-weight : 550;
            font-size : 20px;
        }
        .posting:hover{
            background-color:rgb(132, 176, 204);
        }
    </style>
    
</head>
<body>
    <div class="smcontainer">
        <div class="smbt">
            <div class="smboardtypeNM proposal">
                <a href = "#" id="iframeposting" onclick="iframeposting('proposals_list.html');">
                    제안서</a>
            </div>
            <div class="smboardtypeNM portfolio">
                <a href = "#" id="iframeposting" onclick="iframeposting('portfolio_list.html');">
                    포트폴리오</a>
            </div>
        </div>
        <div class="smbc">
            <div class="boardcategory">
                <div class="webdeveloper"><a href="#">웹개발자</a></div>
                <div class="appdeveloper"><a href="#">앱개발자</a></div>
            </div>
        </div>
        <div class="smbp">
            <div class="posting"><a href="#" id="ifameposting" onclick="iframeposting('posting.html');" scrolling="no">게시글작성</a></div>
        </div>
    </div>

    <script>
        function iframeposting(url){
            document.getElementById('iframechange').src=url;
        }
    </script>
</body>
</html>
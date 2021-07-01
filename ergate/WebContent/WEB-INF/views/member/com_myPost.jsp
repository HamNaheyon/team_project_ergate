<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>fre_myPost</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

    <style>
        div{
            box-sizing:border-box;

        }

        .fre_mblist{
            background-color:rgb(166,206,231);
            height:30px;
        }

        .fre_mbcontents{
            height:15px;
            
        }
        
        .fre_mblist li, .fre_mbcontents li{
            margin-left:0;
            list-style-type: none;
            
            height: 30px;
            
            border-right:2px solid white;
            border-left:2px solid white;
            
            text-align : center;
            float:left;
        }

        #fre_mblistno{width:11%;}
        #fre_mblisttitle{width:20%;}
        #fre_mblistwriter{width:15%;}
        #fre_mblistcontents{width:35%;}
        #fre_mblistdt{width:15%;}

        #mbn{width:11%;}
        #mbt{width:20%;}
        #mbw{width:15%;}
        #mbc{width:35%;}
        #mbd{width:15%;}
    </style>
</head>
    <div id="fre_container">
    <jsp:include page="../common/header.jsp"></jsp:include>
        <div class="fre_mb-form">
       		<jsp:include page="com_sideMenu.jsp"></jsp:include>
            <div class="myboard">
                <h4 class="fre_mbtitle">내 게시글</h4>
                <br>
                <hr>
            </div>
            <div class="fre_mblist">
                <ul>
                    <li id="fre_mblistno">게시글 번호</li>
                    <li id="fre_mblisttitle">제목</li>
                    <li id="fre_mblistwriter">작성자</li>
                    <li id="fre_mblistcontents">내용</li>
                    <li id="fre_mblistdt">작성일자</li>
                </ul>
            </div>
            <div class="fre_mbcontents">
                <ul>
                    <li id="mbn">1</li>
                    <li id="mbt">내 뜻대로 안 되네</li>
                    <li id="mbw">함나현</li>
                    <li id="mbc">이게 안된다고?</li>
                    <li id="mbd">2021-06-23</li>
                </ul>
            </div>
            <hr>
            <div class="fre_mbcontents">
                <ul>
                    <li id="mbn">1</li>
                    <li id="mbt">내 뜻대로 안 되네</li>
                    <li id="mbw">함나현</li>
                    <li id="mbc">이게 안된다고?</li>
                    <li id="mbd">2021-06-23</li>
                </ul>
            </div>
            <hr>
            <div class="fre_mbcontents">
                <ul>
                    <li id="mbn">1</li>
                    <li id="mbt">내 뜻대로 안 되네</li>
                    <li id="mbw">함나현</li>
                    <li id="mbc">이게 안된다고?</li>
                    <li id="mbd">2021-06-23</li>
                </ul>
            </div>
            <hr>
            <div class="fre_mbcontents">
                <ul>
                    <li id="mbn">1</li>
                    <li id="mbt">내 뜻대로 안 되네</li>
                    <li id="mbw">함나현</li>
                    <li id="mbc">이게 안된다고?</li>
                    <li id="mbd">2021-06-23</li>
                </ul>
            </div>
            <hr>
            <div>
                <nav aria-label="Page navigation example">
                    <ul class="pagination justify-content-center">
                        <li class="page-item disabled">
                        <a class="page-link" href="#" tabindex="-1" aria-disabled="true">&laquo;</a>
                        </li>
                        <li class="page-item"><a class="page-link" href="#">1</a></li>
                        <li class="page-item"><a class="page-link" href="#">2</a></li>
                        <li class="page-item"><a class="page-link" href="#">3</a></li>
                        <li class="page-item">
                        <a class="page-link" href="#">&raquo;</a>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
    </div>

<body>
    
</body>
</html>
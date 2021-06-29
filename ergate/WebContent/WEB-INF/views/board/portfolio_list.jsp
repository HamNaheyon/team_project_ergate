<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>portfolio_list</title>
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

    <%-- <link rel = "stylesheet" type = "text/css" href = "${contextPath}/resources/css/portfolio_list.css"> --%>

    <style>
        div{
            /* border : 1px solid rgb(49, 124, 236); */
            box-sizing: border-box;
        }
        .pfcontainer{
            width:716px;
            height:1120px;
        }
        /************* 게시판제목 *************/
        .pftitle{
            width:100%;
            height:4.5%;
        }
        .pftitle > h3{
            text-align:center;
            margin:auto;
            font-size:30px;
        }
        /************* 게시판정렬 *************/        
        .pfsort{
            width:100%;
            height:2.5%;
        }
        .pfsort > select{
            margin-left:620px;
        }
        /************* 게시판내용 *************/
        .pfboardcontents{
            width:100%;
            height:88.5%;
        }
        .pfboardcontents > div{
            width:33.33%;
            height:20%;
            float:left;
        }
        .pfboardcontents > div > div > img{
            margin-left:16px;
            margin-right:16px;
            margin-top:7.5px;
            margin-bottom:7.5px;
        }
        /************* 게시글썸네일 *************/
        #pfthumbnail{
            width:100%;
            height:70%;
        }
        /************* 게시글제목 *************/
        #pftitle{
            width:100%;
            height:18%;
        }
        #pftitle > h4{
            font-weight:bold;
            font-size:22px; 
            margin-left:16px; 
        }
        /************* 게시글조회수 *************/
        #pfviews{
            width:100%;
            height:12%;
        }
        #pfviews > h6{
            margin-left:165px;
        }
        /************* 게시판페이징 *************/
        .pfpaging{
            width:100%;
            height:4.5%;
        }
    </style>
</head>
<body>
    <div class="pfcontainer">
        <div class="pftitle">
            <h3 id="portfoliotitle">포트폴리오</h3>
        </div>
        <div class="pfsort">
            <select id="pfsort" name="pfsort">
                <option name="sort" value="최신순">최신순</option>
                <option name="sort" value="경력">경력</option>
                <option name="sort" value="언어">언어</option>
            </select>
        </div>
        <div class="pfboardcontents">
            <div id="pfcontents">
                <div id="pfthumbnail">
                    <img src="images/developer.png" style="width:200px;">
                </div>
                <div id="pftitle"><h4>portfoliotitle</h4></div>
                <div id="pfviews"><h6>조회수</h6></div>
            </div>
            <div id="pfcontents">
                <div id="pfthumbnail">
                    <img src="images/developer.png" style="width:200px;">
                </div>
                <div id="pftitle"><h4>portfoliotitle</h4></div>
                <div id="pfviews"><h6>조회수</h6></div>
            </div>
            <div id="pfcontents">
                <div id="pfthumbnail">
                    <img src="images/developer.png" style="width:200px;">
                </div>
                <div id="pftitle"><h4>portfoliotitle</h4></div>
                <div id="pfviews"><h6>조회수</h6></div>
            </div>
            <div id="pfcontents">
                <div id="pfthumbnail">
                    <img src="images/developer.png" style="width:200px;">
                </div>
                <div id="pftitle"><h4>portfoliotitle</h4></div>
                <div id="pfviews"><h6>조회수</h6></div>
            </div>
            <div id="pfcontents">
                <div id="pfthumbnail">
                    <img src="images/developer.png" style="width:200px;">
                </div>
                <div id="pftitle"><h4>portfoliotitle</h4></div>
                <div id="pfviews"><h6>조회수</h6></div>
            </div>
            <div id="pfcontents">
                <div id="pfthumbnail">
                    <img src="images/developer.png" style="width:200px;">
                </div>
                <div id="pftitle"><h4>portfoliotitle</h4></div>
                <div id="pfviews"><h6>조회수</h6></div>
            </div>
            <div id="pfcontents">
                <div id="pfthumbnail">
                    <img src="images/developer.png" style="width:200px;">
                </div>
                <div id="pftitle"><h4>portfoliotitle</h4></div>
                <div id="pfviews"><h6>조회수</h6></div>
            </div>
            <div id="pfcontents">
                <div id="pfthumbnail">
                    <img src="images/developer.png" style="width:200px;">
                </div>
                <div id="pftitle"><h4>portfoliotitle</h4></div>
                <div id="pfviews"><h6>조회수</h6></div>
            </div>
            <div id="pfcontents">
                <div id="pfthumbnail">
                    <img src="images/developer.png" style="width:200px;">
                </div>
                <div id="pftitle"><h4>portfoliotitle</h4></div>
                <div id="pfviews"><h6>조회수</h6></div>
            </div>
            <div id="pfcontents">
                <div id="pfthumbnail">
                    <img src="images/developer.png" style="width:200px;">
                </div>
                <div id="pftitle"><h4>portfoliotitle</h4></div>
                <div id="pfviews"><h6>조회수</h6></div>
            </div>
            <div id="pfcontents">
                <div id="pfthumbnail">
                    <img src="images/developer.png" style="width:200px;">
                </div>
                <div id="pftitle"><h4>portfoliotitle</h4></div>
                <div id="pfviews"><h6>조회수</h6></div>
            </div>
            <div id="pfcontents">
                <div id="pfthumbnail">
                    <img src="images/developer.png" style="width:200px;">
                </div>
                <div id="pftitle"><h4>portfoliotitle</h4></div>
                <div id="pfviews"><h6>조회수</h6></div>
            </div>
            <div id="pfcontents">
                <div id="pfthumbnail">
                    <img src="images/developer.png" style="width:200px;">
                </div>
                <div id="pftitle"><h4>portfoliotitle</h4></div>
                <div id="pfviews"><h6>조회수</h6></div>
            </div>
            <div id="pfcontents">
                <div id="pfthumbnail">
                    <img src="images/developer.png" style="width:200px;">
                </div>
                <div id="pftitle"><h4>portfoliotitle</h4></div>
                <div id="pfviews"><h6>조회수</h6></div>
            </div>
            <div id="pfcontents">
                <div id="pfthumbnail">
                    <img src="images/developer.png" style="width:200px;">
                </div>
                <div id="pftitle"><h4>portfoliotitle</h4></div>
                <div id="pfviews"><h6>조회수</h6></div>
            </div>

        </div>
        <div class="pfpaging">
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
    
</body>
</html>
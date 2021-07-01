<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>portfolio_list</title>
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

    <link rel = "stylesheet" type = "text/css" href = "${contextPath}/resources/css/BoardMain.css">
	<jsp:include page="../common/header.jsp"/>

</head>
<body>
	<jsp:include page="Board_Search_Form.jsp"/>
	<jsp:include page="Board_SideMenu.jsp"/>
    <div class="pfcontainer">
        <div class="boardroute"><h4 id="boardroute">포트폴리오 > 웹개발자</h4></div>
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
                    <img src="${contextPath}/resources/img/freeboard/developer.png" style="width:95%;">
                </div>
                <div id="pftitle"><h4>portfoliotitle</h4></div>
                <div id="pfviews"><h6>조회수</h6></div>
            </div>
            <div id="pfcontents">
                <div id="pfthumbnail">
                    <img src="${contextPath}/resources/img/freeboard/developer.png" style="width:95%;">
                </div>
                <div id="pftitle"><h4>portfoliotitle</h4></div>
                <div id="pfviews"><h6>조회수</h6></div>
            </div>
            <div id="pfcontents">
                <div id="pfthumbnail">
                    <img src="${contextPath}/resources/img/freeboard/developer.png" style="width:95%;">
                </div>
                <div id="pftitle"><h4>portfoliotitle</h4></div>
                <div id="pfviews"><h6>조회수</h6></div>
            </div>
            <div id="pfcontents">
                <div id="pfthumbnail">
                    <img src="${contextPath}/resources/img/freeboard/developer.png" style="width:95%;">
                </div>
                <div id="pftitle"><h4>portfoliotitle</h4></div>
                <div id="pfviews"><h6>조회수</h6></div>
            </div>
            <div id="pfcontents">
                <div id="pfthumbnail">
                    <img src="${contextPath}/resources/img/freeboard/developer.png" style="width:95%;">
                </div>
                <div id="pftitle"><h4>portfoliotitle</h4></div>
                <div id="pfviews"><h6>조회수</h6></div>
            </div>
            <div id="pfcontents">
                <div id="pfthumbnail">
                    <img src="${contextPath}/resources/img/freeboard/developer.png" style="width:95%;">
                </div>
                <div id="pftitle"><h4>portfoliotitle</h4></div>
                <div id="pfviews"><h6>조회수</h6></div>
            </div>
            <div id="pfcontents">
                <div id="pfthumbnail">
                    <img src="${contextPath}/resources/img/freeboard/developer.png" style="width:95%;">
                </div>
                <div id="pftitle"><h4>portfoliotitle</h4></div>
                <div id="pfviews"><h6>조회수</h6></div>
            </div>
            <div id="pfcontents">
                <div id="pfthumbnail">
                    <img src="${contextPath}/resources/img/freeboard/developer.png" style="width:95%;">
                </div>
                <div id="pftitle"><h4>portfoliotitle</h4></div>
                <div id="pfviews"><h6>조회수</h6></div>
            </div>
            <div id="pfcontents">
                <div id="pfthumbnail">
                    <img src="${contextPath}/resources/img/freeboard/developer.png" style="width:95%;">
                </div>
                <div id="pftitle"><h4>portfoliotitle</h4></div>
                <div id="pfviews"><h6>조회수</h6></div>
            </div>
            <div id="pfcontents">
                <div id="pfthumbnail">
                    <img src="${contextPath}/resources/img/freeboard/developer.png" style="width:95%;">
                </div>
                <div id="pftitle"><h4>portfoliotitle</h4></div>
                <div id="pfviews"><h6>조회수</h6></div>
            </div>
            <div id="pfcontents">
                <div id="pfthumbnail">
                    <img src="${contextPath}/resources/img/freeboard/developer.png" style="width:95%;">
                </div>
                <div id="pftitle"><h4>portfoliotitle</h4></div>
                <div id="pfviews"><h6>조회수</h6></div>
            </div>
            <div id="pfcontents">
                <div id="pfthumbnail">
                    <img src="${contextPath}/resources/img/freeboard/developer.png" style="width:95%;">
                </div>
                <div id="pftitle"><h4>portfoliotitle</h4></div>
                <div id="pfviews"><h6>조회수</h6></div>
            </div>
            <div id="pfcontents">
                <div id="pfthumbnail">
                    <img src="${contextPath}/resources/img/freeboard/developer.png" style="width:95%;">
                </div>
                <div id="pftitle"><h4>portfoliotitle</h4></div>
                <div id="pfviews"><h6>조회수</h6></div>
            </div>
            <div id="pfcontents">
                <div id="pfthumbnail">
                    <img src="${contextPath}/resources/img/freeboard/developer.png" style="width:95%;">
                </div>
                <div id="pftitle"><h4>portfoliotitle</h4></div>
                <div id="pfviews"><h6>조회수</h6></div>
            </div>
            <div id="pfcontents">
                <div id="pfthumbnail">
                    <img src="${contextPath}/resources/img/freeboard/developer.png" style="width:95%;">
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
        <div class="finclude">
			<jsp:include page="../common/footer.jsp"/>
        </div>
    
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>proposals_list</title>
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

    <%-- <link rel = "stylesheet" type = "text/css" href = "${contextPath}/resources/css/proposals_list.jsp.css"> --%>

</head>
<body>
    <div class="ppcontainer">
        <div class="pptitle">
            <h3 id="proposalstitle">제안서</h3>
        </div>
        <div class="ppsort">
            <select id="ppsort" name="ppsort">
                <option name="sort" value="최신순">최신순</option>
                <option name="sort" value="경력">경력</option>
                <option name="sort" value="언어">언어</option>
            </select>
        </div>
        <div class="ppboardcontents">
            <div id="ppcontents">
                <div id="ppthumbnail">
                    <img src="images/developer.png" style="width:200px;">
                </div>
                <div id="pptitle"><h4>proposalstitle</h4></div>
                <div id="ppviews"><h6>조회수</h6></div>
            </div>
            <div id="ppcontents">
                <div id="ppthumbnail">
                    <img src="images/developer.png" style="width:200px;">
                </div>
                <div id="pptitle"><h4>proposalstitle</h4></div>
                <div id="ppviews"><h6>조회수</h6></div>
            </div>
            <div id="ppcontents">
                <div id="ppthumbnail">
                    <img src="images/developer.png" style="width:200px;">
                </div>
                <div id="pptitle"><h4>proposalstitle</h4></div>
                <div id="ppviews"><h6>조회수</h6></div>
            </div>
            <div id="ppcontents">
                <div id="ppthumbnail">
                    <img src="images/developer.png" style="width:200px;">
                </div>
                <div id="pptitle"><h4>proposalstitle</h4></div>
                <div id="ppviews"><h6>조회수</h6></div>
            </div>
            <div id="ppcontents">
                <div id="ppthumbnail">
                    <img src="images/developer.png" style="width:200px;">
                </div>
                <div id="pptitle"><h4>proposalstitle</h4></div>
                <div id="ppviews"><h6>조회수</h6></div>
            </div>
            <div id="ppcontents">
                <div id="ppthumbnail">
                    <img src="images/developer.png" style="width:200px;">
                </div>
                <div id="pptitle"><h4>proposalstitle</h4></div>
                <div id="ppviews"><h6>조회수</h6></div>
            </div>
            <div id="ppcontents">
                <div id="ppthumbnail">
                    <img src="images/developer.png" style="width:200px;">
                </div>
                <div id="pptitle"><h4>proposalstitle</h4></div>
                <div id="ppviews"><h6>조회수</h6></div>
            </div>
            <div id="ppcontents">
                <div id="ppthumbnail">
                    <img src="images/developer.png" style="width:200px;">
                </div>
                <div id="pptitle"><h4>proposalstitle</h4></div>
                <div id="ppviews"><h6>조회수</h6></div>
            </div>
            <div id="ppcontents">
                <div id="ppthumbnail">
                    <img src="images/developer.png" style="width:200px;">
                </div>
                <div id="pptitle"><h4>proposalstitle</h4></div>
                <div id="ppviews"><h6>조회수</h6></div>
            </div>
            <div id="ppcontents">
                <div id="ppthumbnail">
                    <img src="images/developer.png" style="width:200px;">
                </div>
                <div id="pptitle"><h4>proposalstitle</h4></div>
                <div id="ppviews"><h6>조회수</h6></div>
            </div>
            <div id="ppcontents">
                <div id="ppthumbnail">
                    <img src="images/developer.png" style="width:200px;">
                </div>
                <div id="pptitle"><h4>proposalstitle</h4></div>
                <div id="ppviews"><h6>조회수</h6></div>
            </div>
            <div id="ppcontents">
                <div id="ppthumbnail">
                    <img src="images/developer.png" style="width:200px;">
                </div>
                <div id="pptitle"><h4>proposalstitle</h4></div>
                <div id="ppviews"><h6>조회수</h6></div>
            </div>
            <div id="ppcontents">
                <div id="ppthumbnail">
                    <img src="images/developer.png" style="width:200px;">
                </div>
                <div id="pptitle"><h4>proposalstitle</h4></div>
                <div id="ppviews"><h6>조회수</h6></div>
            </div>
            <div id="ppcontents">
                <div id="ppthumbnail">
                    <img src="images/developer.png" style="width:200px;">
                </div>
                <div id="pptitle"><h4>proposalstitle</h4></div>
                <div id="ppviews"><h6>조회수</h6></div>
            </div>
            <div id="ppcontents">
                <div id="ppthumbnail">
                    <img src="images/developer.png" style="width:200px;">
                </div>
                <div id="pptitle"><h4>proposalstitle</h4></div>
                <div id="ppviews"><h6>조회수</h6></div>
            </div>

        </div>
        <div class="pppaging">
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


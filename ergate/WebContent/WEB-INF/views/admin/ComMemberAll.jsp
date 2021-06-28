<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:include page="../common/side.jsp"></jsp:include> 
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <title>html문서 제목</title>
     <style>
       .but-style{
            background-color: white; color:rgb(166  , 206, 231); font-weight: bold;
            border-color: rgb(166  , 206, 231);
            border-radius: 12px;
        }
         #main-Member-All{
         float:left;
             width: 85%;
             height: 70%;
         }
     </style>
     
</head>
<body>
    <div id="main-Member-All">
 
    <table class="table">
      <thead style="background-color: rgb(166  , 206, 231); color: white; font-weight: bold;">
        
          <tr><th>회원번호</th><th>기업이름</th><th>사업자 번호</th><th>아이디</th><th>가입 날짜</th><th>이메일</th><td>탈퇴 여부</td><td>상세조회</td></>
      </thead>
      <tbody>
        <tr><td>01</td><td>컴퍼니</td><td>415-456-12345</td><td>acnb37</td><td>21-01-01</td><td>acnb37@naver.com</td><td>N</td><td><button><a href="${contextPath}/admin/ComMemberSel">상세보기</a></button></td></tr>
        <tr><td>02</td><td>컴퍼니</td><td>415-456-12345</td><td>acnb37</td><td>21-01-01</td><td>acnb37@naver.com</td><td>N</td><td><button onclick="location.href='기업상세페이지.html'">상세보기</button></td></tr>
        <tr><td>03</td><td>컴퍼니</td><td>415-456-12345</td><td>acnb37</td><td>21-01-01</td><td>acnb37@naver.com</td><td>N</td><td><button onclick="location.href='기업상세페이지.html'">상세보기</button></td></tr>
        <tr><td>04</td><td>컴퍼니</td><td>415-456-12345</td><td>acnb37</td><td>21-01-01</td><td>acnb37@naver.com</td><td>N</td><td><button onclick="location.href='기업상세페이지.html'">상세보기</button></td></tr>
        <tr><td>05</td><td>컴퍼니</td><td>415-456-12345</td><td>acnb37</td><td>21-01-01</td><td>acnb37@naver.com</td><td>N</td><td><button onclick="location.href='기업상세페이지.html'">상세보기</button></td></tr>
        <tr><td>06</td><td>컴퍼니</td><td>415-456-12345</td><td>acnb37</td><td>21-01-01</td><td>acnb37@naver.com</td><td>N</td><td><button onclick="location.href='기업상세페이지.html'">상세보기</button></td></tr>
        <tr><td>07</td><td>컴퍼니</td><td>415-456-12345</td><td>acnb37</td><td>21-01-01</td><td>acnb37@naver.com</td><td>N</td><td><button onclick="location.href='기업상세페이지.html'">상세보기</button></td></tr>
        <tr><td>08</td><td>컴퍼니</td><td>415-456-12345</td><td>acnb37</td><td>21-01-01</td><td>acnb37@naver.com</td><td>N</td><td><button onclick="location.href='기업상세페이지.html'">상세보기</button></td></tr>
        <tr><td>09</td><td>컴퍼니</td><td>415-456-12345</td><td>acnb37</td><td>21-01-01</td><td>acnb37@naver.com</td><td>N</td><td><button onclick="location.href='기업상세페이지.html'">상세보기</button></td></tr>
        <tr><td>10</td><td>컴퍼니</td><td>415-456-12345</td><td>acnb37</td><td>21-01-01</td><td>acnb37@naver.com</td><td>N</td><td><button onclick="location.href='기업상세페이지.html'">상세보기</button></td></tr>
        
      </tbody>
    </table>
    <nav aria-label="Page navigation example">
        <ul class="pagination justify-content-center">
          <li class="page-item disabled">
            <a class="page-link" href="#" tabindex="-1" aria-disabled="true">Previous</a>
          </li>
          <li class="page-item"><a class="page-link" href="#">1</a></li>
          <li class="page-item"><a class="page-link" href="#">2</a></li>
          <li class="page-item"><a class="page-link" href="#">3</a></li>
          <li class="page-item">
            <a class="page-link" href="#">Next</a>
          </li>
        </ul>
      </nav>
      <div>
        <select aria-label="Default select example" style="margin-left: 35%;">
          <option value="1" selected>회원 번호</option>
          <option value="2">기업 이름</option>
          <option value="3">사업자 번호</option>
          <option value="4">아이디</option>
          <option value="5">가입 날짜</option>
          <option value="6">이메일</option>
          <option value="7">탈퇴여부</option>
        </select>
      <input type="search"> <button id="searchbtn" class=" but-style">검색</button>
    </div>
    
    
    
    </div>




<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
</body>
</html>
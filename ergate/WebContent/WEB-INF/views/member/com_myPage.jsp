<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>기업 내 정보</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
        integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
        crossorigin="anonymous"></script>
    <style>
        input[type="number"]::-webkit-outer-spin-button,
        input[type="number"]::-webkit-inner-spin-button {
            -webkit-appearance: none;
            margin: 0;
        }
        .btn {
            background-color: #e1e1e1;
            color: black;
            border-radius: 3px;
            border: 2px solid rgb(107, 140, 172);

        }

        .btn:hover {
            background-color: #e1e1e1;
            border: 2px solid rgb(107, 140, 172);
            color: black;
            box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24), 0 17px 50px 0 rgba(0,0,0,0.19);
        }
    </style>
</head>

<body>
        <div class="container">
		<jsp:include page="../common/header.jsp"></jsp:include>
        
		
		<c:set var="phone" value="${ fn:split( comLoginMember.comPhone, '-' ) }"/>
		<div class="row my-5">
             <jsp:include page="com_sideMenu.jsp"></jsp:include>
             <div class="col-sm-8">
                    <h4 class="mb-3">내 정보</h4>
                    <br>
                    <hr>
                    <form class="validation-form" method="POST" action="com_update">
                        <!-- 아이디 -->
                        <div class="row mb-5 form-row">
                            <div class="col-md-3">
                                <label for="id">아이디</label>
                            </div>
                            <div class="col-md-6">
                            <h5 id="id"> ${ comLoginMember.comId } </h5>
                            </div>
                        </div>
                        <!-- 담당자 -->
                        <div class="row mb-3 form-row">
                            <div class="col-md-3">
                                <label for="name">담당자</label>
                            </div>
                            <div class="col-md-6">
								<h5 id="name"> ${ comLoginMember.manager }</h5>
							</div>
                        </div>
                        
                        <!-- 전화번호 -->
                        <div class="row mb-3 form-row">
                            <div class="col-md-3">
                                <label for="phone1">전화번호</label>
                            </div>
                            <!-- 전화번호1 -->
                            <div class="col-md-3">
                                <select class="custom-select" id="phone1" name="phone">
                                    <option>010</option>
                                    <option>011</option>
                                    <option>016</option>
                                    <option>017</option>
                                    <option>019</option>
                                </select>
                            </div>
                            
                            <!-- 전화번호2 -->
                            <div class="col-md-3">
                                <input type="number" class="form-control phone" id="phone2" name="phone" value="${phone[1]}">
                            </div>
                            
                            <!-- 전화번호3 -->
                        <div class="col-md-3">
                            <input type="number" class="form-control phone" id="phone3" name="phone" value="${phone[2]}">
                        </div>
                        
                        <div class="col-md-6 offset-md-3">
                            <span id="checkPhone">&nbsp;</span>
                        </div>
                    </div>
                    
                    <!-- 이메일 -->
                    <div class="row mb-3 form-row">
                        <div class="col-md-3">
                            <label for="email">Email</label>
                        </div>
                        <div class="col-md-6">
								<input type="email" class="form-control" id="email" name="email" value=" ${comLoginMember.comEmail} ">
						</div>
                        
                    </div>
                    
                    <!-- 기업명 -->
                    <div class="row mb-3 form-row">
                        <div class="col-md-3">
                            <label for="company">기업 명</label>
                        </div>
                        <div class="col-md-6">
								<h5 id="name"> ${ comLoginMember.companyName }</h5>
						</div>
                    </div>
                    
                    <!-- 사업자 번호 -->
                    <div class="row mb-3 form-row">
                        <div class="col-md-3">
                            <label for="companyNo">사업자 번호</label>
                        </div>
                       <div class="col-md-6">
								<h5 id="name"> ${ comLoginMember.companyNo }</h5>
						</div>
                    </div>
                    <hr>
                    <div class="mb-4"></div>
                    <button class="btn btn-primary btn-lg btn-block" type="submit">수정하기</button>
                </form>
            </div>
        </div>
    <jsp:include page="../common/footer.jsp"/>
    </div>
</body>

</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>posting</title>

	<%-- <link rel = "stylesheet" type = "text/css" href = "${contextPath}/resources/css/posting.css"> --%>

    <style>
        div{
        /* border : 1px solid rgb(49, 124, 236); */
        box-sizing: border-box;
        }
        .pcontainer{
            width:716px;
            height:1120px;
        }
        .posting{
            width:100%;
            height:6%;
            text-align:center;
        }
        .cborder{
            width:100%;
            height:3%;
        }
        /************* 카테고리 *************/   
        
        /************* 제목 *************/   
        .title{
            
        }
        /************* 내용 *************/   
        .contents{
            height:40%;
        }
        .cbselect{
            height:100%;
        }
        #contents{
            height:430px;
        }
        /************* 파일업로드 *************/   
        .uploadfile{
            
        }
        /************* 버튼 *************/   
        .write{
            
        }
        .sbutton{
            width:250px;
            float:left;
        }


        .label{
            width:12%;
            height:30px;
            float:left;
        }
        #select{
           width:85%;
           height:3%;
           float:left;
        }
        .complet{
            width:500px;
            float:left;
        }
        select{
            width:510px;
        }
        input{
            width:500px;
        }
        button{
            width : 100%;
            height : 100%;
            box-sizing : border-box;

            background-color:rgb(166,206,231);
            color: white;
            border-radius: 3px;
            border: 2px solid white;
        }
        button:hover{
            background-color: rgb(132, 176, 204);
        }
        input:focus, select:focus{
            outline:none;
            border-radius;
            border: 3px solid rgb(132, 176, 204);
        }
        input, select, option{
            border: 2px solid rgb(166,206,231);
            
        }


    </style>
</head>
<body>
    <div class="pcontainer">
        <div class="posting">
            <h3>게시글 작성</h3>
        </div>
        <div class="pcategory cborder">
            <div class="label">
                <label for="category">카테고리*</label>
            </div>
            <div class="select">
                <select id="category" name="category">
                    <option>웹 개발자</option>
                    <option>앱 개발자</option>
                </select>
            </div>
        </div>
        <div class="title cborder">
            <div class="label">
                <label for="category">제목*</label>
            </div>
            <div class="select">
                <input name="category" id="category" type="text" placeholder = "제목을 입력해주세요">  
            </div>
        </div>
        <div class="contents cborder">
            <div class="label">
                <label for="contents">내용*</label>
            </div>
            <div class="cbselect">
                <input name="contents" id="contents" type="text" placeholder = "내용을 입력해주세요">
            </div>
        </div>
        <div class="uploadfile cborder">
            <div class="label">
                <label for="uploadfile">첨부파일</label>
            </div>
            <div class="select">
                <input name="uploadfile" id="uploadfile" type="file">
                <!-- <img src="images/file.png" style="width:100px;" border="0" onclick='document.all.uploadfile.click(); document.all.uploadfile2.value=document.all.uploadfile.value'> -->
                <!-- <input name="uploadfile2" id="uploadfile2" type="text" style="display:none;"> -->
            </div>
        </div>
        <div class="uploadfile cborder">
            <div class="label">
                <label for="thumbnail">썸네일</label>
            </div>
            <div class="select">
                <input name="uploadfile" id="uploadfile" type="file">
                <!-- <img src="images/file.png" style="width:100px;" border="0" onclick='document.all.uploadfile.click(); document.all.uploadfile2.value=document.all.uploadfile.value'> -->
                <!-- <input name="uploadfile2" id="uploadfile2" type="text" style="display:none;"> -->
            </div>
        </div>
        <div class="write cborder">
            <div class="label"></div>
            <div class="select">
                <div class="sbutton">
                    <button type="button">작성취소</button>
                </div>
                <div class="sbutton">
                    <button type="button">내용초기화</button>
                </div>
            </div>
        </div>
        <div>
            <div class="label"></div>
            <div class="complet">
                <button type="button">작성완료</button>
            </div> 
        </div>
    </div>

</body>
</html>
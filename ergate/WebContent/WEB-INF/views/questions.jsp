<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의 사항 작성</title>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<style>
	/* div{
		border:1px solid black
	} */
	#container{
		margin: auto;
		width: 1200px;
		height: 1000px;
	}
	#content{
		width: 100%;
	}
	#main{
		font-weight: bold;
		text-align: center;
		font-family: 'MaplestoryOTFBold';
		font-size: 40px;
	}
	table{
		margin: auto;
	}
	label{
		font-size:25px;
		font-weight: bold;
		text-align: left;
	}
	#title{
		font-size:25px;
	}
	#contents{
		font-size:20px;
	}
	#sub-btn{
		width: 10%;
		float: right;
	}
	#sub-btn> button{
         background-color: rgb(166, 206, 231);
         border: 0px;
         padding: 15px;
         font-size:20px;
         width: 90%;
         height: 50%;
         font-family: 'MaplestoryOTFBold';
         text-shadow: 1px 1px 5px #000;
         color: white;
         display: block; 
         margin: 0px auto; 
     }
     #sub-btn> button:hover{
		background-color: rgb(152, 203, 235);
		text-shadow: -2px 0 black, 0 2px black, 2px 0 black, 0 -2px black;
		border:3px outset rgb(152, 203, 235);
     }
</style>

</head>
<body>
	<jsp:include page="common/header.jsp"/>
	<div id="container">
		<form id="content" method="POST" action="questions">
				<br>
			<table>
				<div id="main">문의사항</div>
				<tr>
					<td><label>제목*</label></td>
					<td><textarea rows = "1" cols = "80" name = "title" id="title"
					    style="resize: none" placeholder = "제목을 입력해주세요"></textarea></td>
				</tr>
				<tr>
				    <td><label>내용*</label></td>
				    <td><textarea rows = "25" cols = "110" name = "contents"  id="contents"
				        style="resize: none" placeholder = "내용을 입력해주세요"></textarea></td>
				</tr>
			</table>
			<br>
			<div id="sub">
				<div id="sub-btn">
					<button id="qusetion-btn" onclick="subClick();">작성완료</button>
				</div>
           </div>
           <br>
		</form>
	</div>
	<jsp:include page="common/footer.jsp"/>
</body>
</html>
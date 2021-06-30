<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>채팅창</title>

    <style>
        
        div{
            border : 1px solid rgb(166,206,231);
            box-sizing: border-box;
        }
        .container {
            width: 500px;
            height: 700px;
            margin: auto;

        }
        .body{
            width : 100%;
            height : 80%;
            background :rgb(166,206,231);
            border : 1px solid silver;
        }
        .footer{
            width:100%;
            height:20%;
        }
        .input{
            width:80%;
            height:100%;
            float:left;
        }
        .send{
            width:20%;
            height:100%;
            float:left;
        }
        textarea{
            width : 100%;
            height : 100%;
            box-sizing: border-box;
    
            border : 1px solid silver;
            font-size : 16px;            
        }

        button{
            width : 100%;
            height : 100%;
            box-sizing: border-box;

            border : 1px solid silver;
            font-size : 16px;
        }
        #chatting{
            overflow : auto; 
        }
        #chatting > p{
            background-color : rgb(255, 247, 177);
            margin : 10px;
            border-radius : 5px; 
            margin-bottom : 20px;
        }

    </style>
</head>
<body>
    <div class="container">
        <div class="body" id = "chatting">

        </div>
        <div class="footer">
            <div class="input">
                <textarea type="text" id="input-box" name = "input-box" size="50" onkeyup="inputEnter();" name = "message" 
                    style="resize: none" placeholder = "메시지를 입력해주세요"></textarea>
            </div>
                <div class="send">
                    <button type = "button" onclick="readValue();">전송</button>
            </div>
        </div>
    </div>

    <script>
        function readValue(){
            var area6 = document.getElementById("chatting");
            var inputBox = document.querySelector("#input-box");

            console.log(inputBox.value);
            console.log(inputBox.value.length);

            if(inputBox.value.trim().length == 0){
                window.alert("내용 입력 후 버튼을 클릭해주세요.");

            }else{
                area6.innerHTML +="<p>" + inputBox.value + "</p>";
                
            }
            inputBox.value = "";
            inputBox.focus();
        }

        function inputEnter(){

            console.log(window.event.key); 
            console.log(window.event.keyCode); 
            if(window.event.keyCode == 13){
                
                readValue();
            }
        }
    </script>
    
</body>
</html>
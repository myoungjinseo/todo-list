<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>할 일 등록</title>
<h1 id="title1">할 일 등록</h1>
<link rel="stylesheet" href="addForm.css">

</head>

<body>
	<div class="main">
        <form action="./add" method="post">
            <div style="margin-top: 20px; margin-bottom: 15px;">
                어떤 일인가요?<br>
                <input type="text" name="title" placeholder="자바 스크립트 공부하기(24자까지)"
                    maxlength="24" size="40" class="input-text" required>
            </div>

            <div style="margin: 15px 0px">
                누가 할 일인가요?<br>
                <input type="text" name="name" placeholder="홍길동" size="25"
                    class="input-text" required>
            </div>

            <div style="margin: 15px 0px">
                우선순위를 선택하세요<br> 
                <input type="radio" name="sequence" value="1" required> 1순위
                <input type="radio" name="sequence" value="2"  required> 2순위
                <input type="radio" name="sequence" value="3" required> 3순위 <br>
            </div>

                <input type="button" value="< 이전" class="back-btn"
                    onclick="location.href='MainServlet'">
                <input type="submit" value="제출" class="submit-btn" 
                    style="margin-left:30px; margin-bottom:20px;">
                <input type="reset" value="내용 지우기" class="submit-btn">
        </form>
    </div>


    </div>
</body>
</html>
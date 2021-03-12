<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;600;700&display=swap" rel="stylesheet">
    <!-- fontawesome-->
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/style.css"  />
</head>
<body>
 <header class="login__header">
        <h1>게시판 로그인</h1>
    </header>
        <div class="login__content">
            <fieldset id="login" class="login__fieldset">
                <form action="memberlogin" method="post">
                    <div class="login__fieldset__id">
                    <input type="text" name="memberId" class="fieldset__textbox" placeholder="아이디">
                    </div>
                    <div class="login__fieldset__pw">
                    <input type="password" name="memberPw" class="fieldset__textbox" placeholder="패스워드">
                    </div>
                    <div class="joingo"><a href="join.html">회원가입</a></div>
                    <div class="login__fieldset__btn">
                <input class="fieldset__submit" type="submit" value="로그인">
                    </div>   
                    </form>
            </fieldset>
            
        </div>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <header class="join__header">
        <h1>게시판 회원가입</h1>
    </header>
        <div class="join">
            <fieldset id="join" class="login__fieldset">
                <form action="memberjoin" method="post">
                    <div class="join__fieldset__id">
                        <div class="join__head">아이디</div>
                        <input type="text" name="joinId" class="fieldset__textbox">
                        </div>
                        <div class="join__fieldset__pw">
                        <div class="join__head">패스워드</div>
                        <input type="password" name="joinPw" class="fieldset__textbox">
                        <div class="join__head">패스워드 확인</div>
                        <input type="password" name="joinPwcheck" class="fieldset__textbox">
                        </div>
                        <div class="join__fieldset">
                        <div class="join__head">이름</div>
                        <input type="text" name="joinName" class="fieldset__textbox">
                        </div>
                        <div class="join__fieldset__pw">
                        <div class="join__head">이메일</div>
                        <input type="text" name="joinEmail" class="fieldset__textbox">
                        </div>
                        <div class="join__fieldset__btn">
                        <input class="fieldset__submit" type="submit" value="회원가입">
                        </div>   
                        </form>
            </fieldset>
        </div>

</body>
</html>
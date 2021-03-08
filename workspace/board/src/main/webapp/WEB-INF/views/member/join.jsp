<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/style.css"  />
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
                        <input type="text" name="memberId" class="fieldset__textbox">
                        </div>
                        <div class="join__fieldset__pw">
                        <div class="join__head">패스워드</div>
                        <input type="password" name="memberPw" class="fieldset__textbox">
                   <!--      <div class="join__head">패스워드 확인</div>
                        <input type="password" name="joinPwcheck" class="fieldset__textbox"> -->
                        </div>
                        <div class="join__fieldset__name">
        <!--                 <div class="join__head">이름</div>
                        <input type="text" name="memberName" class="fieldset__textbox">-->
                        </div> 
                        <div class="join__fieldset__email">
                        <div class="join__head">이메일</div>
                        <input type="text" name="memberEmail" class="fieldset__textbox">
                        </div>
                        <div class="join__fieldset__btn">
                        <input class="membersubmit" type="submit" value="회원가입">
                        </div>   
                        </form>
            </fieldset>
        </div>

</body>
</html>
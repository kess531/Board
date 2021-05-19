<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시판</title>
	<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon">
	<link rel="icon" href="/favicon.ico" type="image/x-icon">
    <!-- 구글 폰트 사용 -->
	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;600;700&display=swap" rel="stylesheet">
    <!-- fontawesome-->
    <script src="https://kit.fontawesome.com/26b2ef94cb.js" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/style.css?ver=56"/>
	<script src="<%=request.getContextPath() %>/resources/js/main.js?ver=135" defer ></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-3.6.0.min.js"></script>
</head>
<body>
<c:if test="${msg==false}">
<script>alert('유효하지 않은 아이디/비밀번호입니다.');</script>
</c:if>
<header class="login__header">
   <div class="header__logo">
        <i class="fas fa-code">
        <a href="/board/bulletin/index">게시판</a>
        </i>
    </div>
    <h1>게시판 로그인</h1>
</header>
 



    <div class="login__content">
        <fieldset id="login" class="login__fieldset">
            <form action="memberLogin" method="post">
                <div class="login__fieldset__id">
                <input type="text" name="memberId" class="fieldset__textbox" placeholder="아이디">
                </div>
                <div class="login__fieldset__pw">
                <input type="password" name="memberPw" class="fieldset__textbox" placeholder="패스워드">
                </div>
                <div class="joingo"><a href="join.do">회원가입</a></div>
                <div class="login__fieldset__btn">
            <input class="fieldset__submit" type="submit" value="로그인">
                </div>   
                </form>
        </fieldset>
        
    </div>
    <c:if test="${msg==false}">
        <script>
 <script>alert('유효하지 않은 아이디/비밀번호입니다.');</script>
        </script>
    </c:if>
</body>
</html>
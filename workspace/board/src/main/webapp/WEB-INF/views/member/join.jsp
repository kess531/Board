<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
  <header class="join__header">
          <div class="header__logo">
                  <i class="fas fa-code">
        <a href="/board/bulletin/index">게시판</a>
        </i>
        </div>
        <h1>게시판 회원가입</h1>
    </header>
        <div class="join">
            <fieldset id="join" class="login__fieldset">
                <form:form modelAttribute="memberDTO" method="post" action="memberJoin">
                    <div class="join__fieldset__id">
                        <div class="join__head">
                        <span>아이디</span>
                        <span>                                  
            			<strong>
            			 <form:errors path="memberId" />
            			</strong>
                        </span>
                        </div>
                         <form:input path="memberId" class="fieldset__textbox" />
                        </div>
                        <div class="join__fieldset__pw">
                        <div class="join__head">
                        <span>패스워드</span>
                        <span>
                       <strong>
            			 <form:errors path="memberPw" />
            			</strong>
                        </span>
                        </div>
                        <form:password path="memberPw" class="fieldset__textbox" />
      					
                        </div>
                        <div class="join__fieldset__name">
        				<div class="join__head">
        				<span>닉네임</span>
        				<span>
                       <strong>
            			 <form:errors path="memberName" />
            			</strong>
                        </span>
        				</div>
                        <form:input path="memberName" class="fieldset__textbox" />
                        </div> 
                        <div class="join__fieldset__email">
                        <div class="join__head">
						<span>이메일</span>
                        <span>
                     <strong>
            			 <form:errors path="memberEmail" />
            			</strong>
                        </span>
                        </div>
                        <form:input path="memberEmail" class="fieldset__textbox" />
                        </div>
                        <div class="join__fieldset__btn">
                        <input class="fieldset__submit" type="submit" value="회원가입">
                        </div>   
                        </form:form>
            </fieldset>
        </div>

</body>
</html>
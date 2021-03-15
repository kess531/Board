<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
                <form:form modelAttribute="memberDTO" method="post" action="memberjoin">
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
      					<!--<div class="join__head">패스워드 확인</div>
                        <input type="password" name="joinPwcheck" class="fieldset__textbox"> -->
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
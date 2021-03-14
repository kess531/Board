<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
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
                        <div class="join__head">
                        <span>아이디</span>
                        <span>
                        <spring:hasBindErrors name="memberDTO">
            			<c:if test="${errors.hasFieldErrors('memberId')}">                                     
            			<strong>
            			<spring:message
            			code="${errors.getFieldError('memberId').codes[0]}"
            			text="${errors.getFieldError('memberId').defaultMessage}"
            			/>
            			</strong>
						</c:if>
						</spring:hasBindErrors>
                        </span>
                        </div>
                        <input type="text" name="memberId" class="fieldset__textbox">
                        </div>
                        <div class="join__fieldset__pw">
                        <div class="join__head">
                        <span>패스워드</span>
                        <span>
                        <spring:hasBindErrors name="memberDTO">
            			<c:if test="${errors.hasFieldErrors('memberPw')}">                                     
            			<strong>
            			<spring:message
            			code="${errors.getFieldError('memberPw').codes[0]}"
            			text="${errors.getFieldError('memberPw').defaultMessage}"
            			/>
            			</strong>
						</c:if>
						</spring:hasBindErrors>
                        </span>
                        </div>
                        <input type="password" name="memberPw" class="fieldset__textbox">
      					<!--<div class="join__head">패스워드 확인</div>
                        <input type="password" name="joinPwcheck" class="fieldset__textbox"> -->
                        </div>
                        <div class="join__fieldset__name">
        				<!--<div class="join__head">이름</div>
                        <input type="text" name="memberName" class="fieldset__textbox">-->
                        </div> 
                        <div class="join__fieldset__email">
                        <div class="join__head">
						<span>이메일</span>
                        <span>
                        <spring:hasBindErrors name="memberDTO">
            			<c:if test="${errors.hasFieldErrors('memberEmail')}">                                     
            			<strong>
            			<spring:message
            			code="${errors.getFieldError('memberEmail').codes[0]}"
            			text="${errors.getFieldError('memberEmail').defaultMessage}"
            			/>
            			</strong>
						</c:if>
						</spring:hasBindErrors>
                        </span>
                        </div>
                        <input type="text" name="memberEmail" class="fieldset__textbox">
                        </div>
                        <div class="join__fieldset__btn">
                        <input class="fieldset__submit" type="submit" value="회원가입">
                        </div>   
                        </form>
            </fieldset>
        </div>

</body>
</html>
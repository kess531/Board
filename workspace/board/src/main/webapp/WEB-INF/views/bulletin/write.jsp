<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>글작성</title>
    <!-- 구글 폰트 사용 -->
	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;600;700&display=swap" rel="stylesheet">
    <!-- fontawesome-->
    <script src="https://kit.fontawesome.com/26b2ef94cb.js" crossorigin="anonymous"></script>
    <script src="<%=request.getContextPath() %>/resources/js/main2.js?ver=8" defer></script>
    	<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/style.css?ver=3"/>
    </head>
<body>
   <div class="wrap">
    <header id="header">
        <div class="header__logo">
            <i class="fas fa-code"></i>
            <a href="/board/bulletin/index">게시판</a>
        </div>

        <ul class="header__navbar">
            <c:if test="${member!= null}">
            <li>${member}님 환영합니다.</li>
			<li class="navbar__menu__item" data-link="#logaut"><a href="member/logout">로그아웃</a></li>
			</c:if>
			<c:if test="${member==null}">
            <li class="navbar__menu__item" ><a href="member/login.do">로그인</a></li>
            <li class="navbar__menu__item" ><a href="member/join.do">회원가입</a></li>
			</c:if>

        </ul>
        </header>
        <div id="container">
            <div class="container__write">
                <form class="container__write__form" action="contentWrite" method="get" >
                    <div class="container__write__form__subject">
                        <input type="hidden" name="bltDate">
                        <input type="hidden" name="bltDate">
                    <select class="container__write__select" name="bltType" >
                        <option class="container__write__select__item" value="free">자유</option>
                        <option class="container__write__select__item" value="qna">질문</option>
                        <option class="container__write__select__item" value="jobs">구직</option>
                    </select>
                    <input class="container__write__text" type="text" placeholder="제목을 입력해주세요." name="bltTitle">
                    <input class="container__write__list" onclick="location.href='bulletin/index'"  type="button" value="목록">
                </div>
                <div class="container__write__form__writer">
                <c:if test="${member!= null}">
				<span class="container__write__writer">${member}</span>
                <input type="hidden" name="memberName" value='${member}'>
                </c:if>
                </div>

                <div class="container__write__form__textarea">
                    <textarea name="bltContent" class="container__write__textarea" ></textarea>
                </div>
                <div class="container__write__form__btn">
                    <input class="container__write__btn" type="submit" value="등록">
                    <input class="container__write__btn" type="reset" value="취소">
                </div>
                </form>
            </div>
        </div>


            
        </div>
        <button class="arrow-up__btn">
            <i class="fas fa-arrow-up"></i>
        </button>
    </div>



</body>
</html>
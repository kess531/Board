<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<script src="<%=request.getContextPath() %>/resources/js/main.js?ver=136" defer ></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-3.6.0.min.js"></script>
</head>
<body>
  
    <div class="wrap">
        <header id="header">
        <div class="header__logo">
                  <i class="fas fa-code">
        <a href="/board/bulletin/index">게시판</a>
        </i>
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
            <div class="container__subTitle">
                <section class="container__subTitle__search">
                    <form class="container__subTitle__form" method="GET" onsubmit="return false">
                    <select class="container__subTitle__select" name="clsfcselect">
                            <option class="container__subTitle__select__item" value="title">제목</option>
                            <option class="container__subTitle__select__item" value="content">내용</option>
                            <option class="container__subTitle__select__item" value="writer">작성자</option>
                            <option class="container__subTitle__select__item" value="total">제목+내용</option>
                        </select>
                        <input class="container__subTitle__text" type="text" placeholder="검색어를 입력해 주세요" name="keyword">
                        <input class="container__subTitle__btn" type="button" value="검색" pattern="[ㄱ-ㅎ|ㅏ-ㅣ|가-힣a-zA-Z0-9|\s]*$">
                    </form>
                </section>
            </div>
            
            <div class="container__board">
                
                <ul class="container__board__listview">
                
                </ul>
                <div class="container__board__bottom">
                    <div class="container__board__paging">
                    
                    </div>
                    <c:if test="${member!= null}">
                        <div class="container__board__bottom__btn">
                                <button class="container__board__wirte__btn" onclick="location.href='bulletin/write.do'">글쓰기</button>
                        </div>
                                </c:if>
                </div>
                </div>
        </div>
    </div>
    <div class="arrowup__btn"><i class="fas fa-arrow-alt-circle-up"></i></div>
    <c:if test="${msg==false}">
        <script>
            alert('로그인 후 이용해주세요');
        </script>
    </c:if>

</body>
</html>
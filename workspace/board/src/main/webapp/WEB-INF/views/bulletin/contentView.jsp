<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <script src="<%=request.getContextPath() %>/resources/js/main3.js?ver=56" defer></script>
    	<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/style.css?ver=43"/>
        <script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-3.6.0.min.js"></script>
</head>
<body>
    <div class="wrap">
            <header id="header">
            <div class="header__logo">
                <i class="fas fa-code"></i>
                <a href="/board/bulletin/index">게시판</a>
            </div>
    
            <ul class="header__navbar">
                <li class="navbar__menu__item active" data-link="#total">전체</li>
                <li class="navbar__menu__item" data-link="#free">자유</li>
                <li class="navbar__menu__item" data-link="#qna">질문</li>
                <li class="navbar__menu__item" data-link="#jobs">구직</li>
                <c:if test="${member!= null}">
                <li>${member}님 환영합니다. 이건 나중에 지우자</li>
                <li class="navbar__menu__item" data-link="#logaut"><a href="/board/member/logout">로그아웃</a></li>
                </c:if>
                <c:if test="${member==null}">
                <li class="navbar__menu__item" ><a href="/board/member/login.do">로그인</a></li>
                <li class="navbar__menu__item" ><a href="/board/member/join.do">회원가입</a></li>
                </c:if>
            </ul>
            </header>
            <div id="container">
                <div class="container__contentview">
                    <div class="container__contentview__board">
                        <div class="container__contentview__board__menu">
                            <div class="container__contentview__board__menu__btn">
                            <input class="container__write__btn" type="button" onclick="location.href='/board/bulletin/index'" value="목록">
                            <input class="container__write__btn" type="button" onclick="location.href='bulletin/write.do'" value="글쓰기">
                        </div>
                        </div>
                        <c:forEach items="${contentView}" var="contentView">
                        <div class="container__contentview__board__subject">
                            <div class="container__contentview__board__type">${contentView.bltType}</div> 
                            <div class="container__contentview__board__title">${contentView.bltTitle}</div>
                        </div>
                        <div class="container__contentview__board__info">
                            <div class="container__contentview__board__info__item"><i class="fas fa-user-circle"></i>${contentView.memberName}</div>
                            
                            <div class="container__contentview__board__info__item"><i class="fas fa-clock"></i>${contentView.bltDate}</div>
                       
                            <div class="container__contentview__board__info__item"><i class="fas fa-eye"></i>${contentView.bltCnt}</div>
                            <div class="container__contentview__board__info__item"><i class="fas fa-comment"></i>댓글개수</div>
                            </div>
                            
                                <div class="container__contentview__board__content">
                                ${contentView.bltContent}
                                </div>
                                <div class="container__contentview__board__content__btn">
                                    <div class="container__contentview__board__content__centerBtn">
                                    <button class="container__contentview__board__content__likeBtn" onclick="location.href='contentLike?bltNo=${contentView.bltNo}'"><i class="fas fa-grin-hearts"></i>${contentView.bltLike}</button>
                                </div>
                                  
                                </div>
                                <div class="container__contentview__board__content__rigthBtn">
                                    <button class="container__contentview__board__content__updateBtn" onclick="location.href='contentLike?bltNo=${contentView.bltNo}'">수정</button>
                                    <button class="container__contentview__board__content__deleteBtn" onclick="location.href='contentLike?bltNo=${contentView.bltNo}'">삭제</button>
                                </div>
                            </div>
                            
                            <div class="container__contentview__comment">
                                <div class="container__contentview__comment__header"><i class="fas fa-comment"></i><em>${cmtCount}</em>개의 댓글이 있습니다.</div>
                                <div class="container__contentview__comment__input">
                                    <div class="container__contentview__comment__write">
                                    <form action="commnetWrite" method="get">

                                        <input type="hidden" name="bltNo" class="bltNoClass" value="${contentView.bltNo}">
                                        <input type="hidden" name="memberName" value="${member}">
                                        <textarea name="cmtContent"  class="container__contentview__comment__commentText"></textarea>
                                        <input type="password"  name="cmtPassword" class="container__contentview__comment__commentPassword" placeholder="비밀번호" minlength="4" maxlength="20">
                                    </div>
                                    <div class="container__contentview__comment__writebtn">
                                        <input type="submit" class="container__contentview__comment__commentBtn" value="등록">
                                    </form>
                                </div>
                                </div>  
    
                                <!-- 댓글구현 -->
                                    <ul class="container__contentview__comment__content">

                                    </ul>     
                                            
                                    </div>
                         
                            
         
                        </c:forEach>
                        <div class="container__contentview__comment__paging">
                           
                        </div>
                        </div>
                    </div>
      
                   
    
                
            <button class="arrowup__btn">
                <i class="fas fa-arrow-up"></i>
            </button>
        </div>
    </body>
    </html>
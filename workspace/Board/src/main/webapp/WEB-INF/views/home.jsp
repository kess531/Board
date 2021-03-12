<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<c:if test="${rttr == false}}">
<h1>로그인 안됌</h1>
</c:if>

<c:if test="${rttr !=false} }">
${member.memberId}님 환영합니다.
</c:if>

</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>


<c:forEach var="item" items="${list}">

<tr>

<td>${item.memberNo}</td>

<td>${item.memberId}</td>

<td>${item.memberPw}</td>

<td>${item.memberEmail}</td>


</tr>

​

</c:forEach>

</table>
</body>
</html>
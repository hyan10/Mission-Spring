<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="${pageContext.request.contextPath}/board/list.do">게시판</a>
	<a href="${pageContext.request.contextPath}/board/write.do">새글등록</a>
	<c:if test="${empty member}">
		<a href="${pageContext.request.contextPath }/member/joinForm.do">가입</a>
		<a href="${pageContext.request.contextPath }/member/login.do">로그인</a>
	</c:if>
	
	<c:if test="${not empty member}">
		<a href="${pageContext.request.contextPath }/member/logout.do">로그아웃</a>
	</c:if>
	
</body>
</html>
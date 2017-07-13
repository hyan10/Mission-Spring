<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/resources/js/checkForm.js"></script>
<script>
	function check(){
		var form = document.loginForm;
		
		if(isNull(form.id, '아이디를 입력하세요.')){
			return false;
		}
		
		if(isNull(form.password, '비밀번호를 입력해주세요.')){
			return false;
		}
		
		return true;
	}
	
	function back(){
		location.href="${pageContext.request.contextPath}";
	}
</script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/layout.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/board.css"/>
</head>
<body>
<!-- html5 -->
	<%-- <header>
		<!-- xml, include, forward는 /가 Mission-Web/ 까지를 의미 -->
		<jsp:include page="/jsp/include/topMenu.jsp"/>
	</header> --%>
	
	<section>
		<div align="center">
		<br/>
		<hr width="80%"/>
		<h2>로그인</h2>
		<hr width="80%"/>
		<br/>
		
		<form action="${pageContext.request.contextPath}/member/login.do" method="post" name="loginForm" onsubmit="return check()">
		
			<input type="hidden" name="url" value="${param.url}"/>
			<input type="hidden" name="no" value="${param.no}"/>
			
			<table width="40%">
				<tr>
					<th>ID</th>
					<td><input type="text" name="id" size="20"/></td>
				</tr>
				<tr>
					<th>PASSWORD</th>
					<td><input type="password" name="password" size="20"/></td>
				</tr>
			</table>
					${msg}
			<br/>
			
			<input type="submit" value="로그인"/>&nbsp;&nbsp;
			<input type="button" value="돌아가기" onclick="back()"/>
			
		</form>
		
<%-- 		<form action="${pageContext.request.contextPath}/member/login.do" method="post" name="loginForm" onsubmit="return check()">
		
			<input type="hidden" name="url" value="${param.url}"/>
			<input type="hidden" name="no" value="${param.no}"/>
			
			<table width="40%">
				<tr>
					<th>ID</th>
					<td><input type="text" name="id" size="20"/></td>
				</tr>
				<tr>
					<th>PASSWORD</th>
					<td><input type="password" name="pw" size="20"/></td>
				</tr>
			</table>
			
			<br/>
			
			<input type="submit" value="로그인"/>&nbsp;&nbsp;
			<input type="button" value="돌아가기" onclick="back()"/>
			
		</form> --%>
	</div>
	</section>
	
<%-- 	<footer>
	<!-- action include 써도 된다.  -->
		<%@ include file="/jsp/include/bottom.jsp" %>
	</footer> --%>
</body>
</html>
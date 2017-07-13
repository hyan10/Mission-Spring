<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
	$(document).ready(function() {
		$('button').click(function() {
			var bno = $('#bno').val();
			$.ajax({
				url: "${pageContext.request.contextPath}/ajax/detail.do",
				data: JSON.stringify({no:bno}),
				type: "post",
				contentType: "application/json;charset=UTF-8", 
				 /* headers : {
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "POST"
				},  */
				success: function(data) {
					$('div').empty();
					$('div').append('번호 : ' + data.no + '<br/>');
					$('div').append('제목 : ' + data.title + '<br/>');
					$('div').append('글쓴이 : ' + data.writer + '<br/>');
					$('div').append('내용 : ' + data.content + '<br/>');
					$('div').append('조회수 : ' + data.viewCnt + '<br/>');
					$('div').append('등록일 : ' + data.regDate + '<br/>');
				}
			});
		});
	});
</script>
</head>
<body>
	검색할 게시판번호 : <input type="text" id="bno" />
	<button>클릭</button>
	<div align="center" >
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>${sessionID}님, 환영합니다!🤗 <a href="logout.do" style="font-size: 12px">로그아웃</a></h4>
<hr>
<form action="insertBoatd.do" method="post">
	<table border="1">
		<tr>
			<td>작성자</td>
			<td>${data.id}</td>
		</tr>
		<tr>
			<td>작성날짜</td>
			<td>${data.wdate}</td>
		</tr>
		<tr>
			<td>제목</td>
			<td>${data.title}</td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea>${data.content}</textarea></td>
		</tr>
	</table>
</form>
<hr>
<a href="main.do">전체목록</a><br>
<a href="insertBoard.jsp">글쓰기</a>
</body>
</html>
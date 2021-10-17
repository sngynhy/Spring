<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
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
</body>
</html>
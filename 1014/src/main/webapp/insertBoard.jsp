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
<form action="insertBoard.do" method="post">
	<table>
		<tr>
			<td>제목</td>
			<td><input type="text" name="title" required="required" style="width: 200px;"></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea name="content" style="width: 202px; height: 71px;"></textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="submit" value="글쓰기">
			</td>
		</tr>
	</table>
</form>
</body>
</html>
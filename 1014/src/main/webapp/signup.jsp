<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="insertMember.do" method="post">
	<table>
		<tr>
			<td>아이디</td>
			<td><input type="text" name="id" required></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="pw" required></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="name" required></td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="submit" value="가입하기">
			</td>
		</tr>
	</table>
</form>
</body>
</html>
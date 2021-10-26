<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- memberVO에 값이 저장되어 있는 경우에만 화면에 값을 출력함 - 포폴용 -->
<form action="login.do" method="post">
	<table>
		<tr>
			<td>아이디</td>
			<td><input type="text" name="id" value="${guest.id}" required="required"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="pw" value="${guest.pw}" required="required"></td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<a href="signup.jsp">회원가입</a>
				<input type="submit" value="로그인">
			</td>
		</tr>
	</table>
</form>
</body>
</html>
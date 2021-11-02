<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
		<tr><!-- 다국어 처리 부분 -->
			<td><spring:message code="message.login.id" /></td>
			<td><input type="text" name="id" value="${guest.id}" required="required"></td>
		</tr>
		<tr>
			<td><spring:message code="message.login.pw" /></td>
			<td><input type="password" name="pw" value="${guest.pw}" required="required"></td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<a href="signup.jsp"><spring:message code="message.login.join" /></a>
				<input type="submit" value="<spring:message code="message.login.login" />">
			</td>
		</tr>
	</table>
</form>
</body>
</html>
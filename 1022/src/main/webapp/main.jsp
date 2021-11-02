<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.board.*, java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<spring:message code="message.login.id" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>${sessionID}message.main.hello <a href="logout.do" style="font-size: 12px">message.main.logout</a></h4>
<hr>
<h1>message.main.list</h1>

<table border="1">
	<tr>
		<td>message.main.listnum</td><td>message.main.listtitle</td><td>message.main.listwriter</td>
	</tr>
	<c:choose>
		<c:when test="${empty datas}">
			<tr>
				<td colspan="3" align="center">message.main.searchresult</td>
			</tr>
		</c:when>
		<c:otherwise>
			<c:forEach var="v" items="${datas}">
				<tr>
					<td>${v.wpk}</td><td><a href="selectBoard.do?wpk=${v.wpk}" style="text-decoration: none;">${v.title}</a></td><td>${v.id}</td>
				</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</table>
<form action="searchBoard.do" method="post">
	<select name="type">
		<c:forEach var="op" items="${sm}">
			<option value="${op.value}">${op.key}</option>
		</c:forEach>
		<!-- <option selected value="title">제목</option>
		<option value="content">내용</option>
		<option value="id">작성자</option> -->
	</select>
	<input type="text" name="keyword" placeholder="message.main.searchkeyword">
	<input type="submit" value="message.main.search">
</form>
<hr>
<a href="main.do">message.main.boardlist</a><br>
<a href="insertBoard.jsp">message.main.insert</a>

</body>
</html>
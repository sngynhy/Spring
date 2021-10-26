<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.board.*, java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>${sessionID}님, 환영합니다!🤗 <a href="logout.do" style="font-size: 12px">로그아웃</a></h4>
<hr>
<h1>게시글 목록</h1>

<table border="1">
	<tr>
		<td>번호</td><td>제목</td><td>작성자</td>
	</tr>
	<c:choose>
		<c:when test="${empty datas}">
			<tr>
				<td colspan="3" align="center">등록된 게시글이 없습니다.</td>
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
	<input type="text" name="keyword" placeholder="검색어를 입력하세요.">
	<input type="submit" value="검색">
</form>
<hr>
<a href="main.do">전체목록</a><br>
<a href="insertBoard.jsp">글쓰기</a>

</body>
</html>
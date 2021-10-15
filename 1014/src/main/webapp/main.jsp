<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.board.*, java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	BoardDAO bDAO = new BoardDAO();
	List<BoardVO> datas = bDAO.getBoardList(new BoardVO());
%>
<body>
<h3><a href="logout.jsp">로그아웃</a></h3>
<h1>글 목록</h1>
<hr>

<table border="1">
	<tr>
		<td>번호</td><td>제목</td><td>작성자</td>
	</tr>
	<c:forEach var="v" item="${datas}">
		<tr>
			<td>${v.wpk}</td><td><a href="getBoard.jsp?wpk=${wpk}>${v.title}</a></td><td>${v.writer}</td>
		</tr>
	</c:forEach>
</table>

<hr>
<a href="insertBoard.jsp">글쓰기</a>

</body>
</html>
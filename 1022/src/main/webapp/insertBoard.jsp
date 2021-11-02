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
<h4>${sessionID}message.main.hello <a href="logout.do" style="font-size: 12px">message.main.logout</a></h4>
<hr>										<!-- 파일 입출력을 위해 encoding type설정 -->
<form action="insertBoard.do" method="post" enctype="multipart/form-data">
	<table>
		<tr>
			<td>message.main.listtitle</td>
			<td><input type="text" name="title" required="required" style="width: 200px;"></td>
		</tr>
		<tr>
			<td>message.insert.content</td>
			<td><textarea name="content" style="width: 202px; height: 71px;"></textarea></td>
		</tr>
		<tr>
			<td>message.insert.fileupload</td>
			<td><input type="file" name="fileUpload"></td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="submit" value="message.insert.upload">
			</td>
		</tr>
	</table>
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form action="board_write_ok.do" method="post">
			<table align="center" border="1">
				<tr>
					<th>이름</th>
					<td><input type="text" name="board_name" size="14" /></td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input type="text" name="board_title" size="14" /></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea rows="8" cols="36" name="board_cont"></textarea></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="board_pwd" /></td>
				</tr>

			</table>
			<div align="center">
				<input type="submit" value="전송" /> <input type="reset" value="취소" />
			</div>
		</form>

	</div>
</body>
</html>
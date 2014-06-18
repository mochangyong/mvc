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
		<form action="bbs_edit_ok.do" method="post">
		<input type ="hidden" name="bbs_no" value="${bcont.bbs_no}" />
			<table align="center" border="1">
				<tr>
					<th>작성자</th>
					<td><input type="text" name="bbs_name" id="bbs_name" size="14" value="${bcont.bbs_name }" /></td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input type="text" name="bbs_title" id="bbs_title"
						size="14" value="${bcont.bbs_title }" /></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea rows="8" cols="36" name="bbs_cont" id="bbs_cont">${bcont.bbs_cont }</textarea></td>
				</tr>
				<tr>
					<th>비밀 번호</th>
					<td><input type="password" name="bbs_pwd" id="bbs_pwd"
						size="14" /></td>
				</tr>
			</table>
			<div align="center">
				<input type="submit" value="수정" /> <input type="reset" value="취소" />
			</div>
		</form>
	</div>
</body>
</html>
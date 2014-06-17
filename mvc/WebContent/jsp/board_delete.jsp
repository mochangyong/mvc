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
<form action="board_delete_ok.do" method="post">
<input type="hidden" name="board_no"  value="${bcont.board_no }" />
<table align ="center" border="1">
<tr>
<th>비밀번호</th>
<td><input type ="password" name="del_pwd" /></td>
</tr>

</table>
<div align ="center">
<input type="submit" value="삭제" "/>
<input type="reset" value="취소"/>
</div>
</form>

</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table align="center" border="1">
<tr>
<th>이름</th>
<td>${bcont.bbs_name }</td>
</tr>
<tr>
<th>제목</th>
<td>${bcont.bbs_title }</td>
</tr>
<tr>
<th>내용</th>
<td>${bbs_cont }</td>
</tr>
<tr>
<th>조회수</th>
<td>${bcont.bbs_hit }</td>
</tr>
<tr>
<td colspan="2">
<input type="button" value="수정" onclick="location='bbs_cont.do?bbs_no=${bcont.bbs_no}&state=edit'" />
<input type="button" value="삭제" onclick="location='bbs_cont.do?bbs_no=${bcont.bbs_no}&state=del'" />
<input type="button" value="목록" onclick="location='bbs_list.do'" />
</td>
</tr>

</table>
</body>
</html>
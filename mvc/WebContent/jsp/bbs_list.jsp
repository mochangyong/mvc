<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>총게시물수:${listcount}</h2>
<table align="center" border="1">
<tr>
<th>번호</th> <th>작성자</th> <th> 제목</th> <th>조회수</th> <th>등록날짜</th>
</tr>
<c:if test="${!empty blist}">
<c:forEach var="b" items="${blist}">
<tr>
<th>${b.bbs_no }</th> <th>${b.bbs_name }</th>
<th><a href ="bbs_cont.do?bbs_no=${b.bbs_no}&state=cont">${b.bbs_title}</a></th>
<th>${b.bbs_hit }</th><th>${b.bbs_date}</th>
</tr>
</c:forEach>
</c:if>
<c:if test ="${empty blist}">
<tr>
<td colspan="5">목록이 없습니다.</td>
</tr>
</c:if>
</table>
<div align="center">
<input type ="button" value ="글쓰기" onclick="location='bbs_write.do'" />
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
<h3>게시판 목록</h3>
<div>${listcount}</div>
<table align ="center" border="1" >
<tr>
<th>번호</th><th>이름</th><th>제목</th><th>조회수</th><th>등록 날짜</th>
</tr>
<c:if test="${!empty blist}">
<c:forEach var="b" items="${blist}">
<tr>
<th>${b.board_no }</th>
<th>${b.board_name }</th>
<th><a href ="board_cont.do?board_no=${b.board_no}&state=cont">${b.board_title}</a></th>
<th>${b.board_hit }</th>  <th>${b.board_date}</th>
</tr>
</c:forEach>
</c:if>
<c:if test="${empty blist}" >
<tr>
<th colspan="5">목록이 없습니다.</th>
</tr>

</c:if>

</table>
<div align="center" >
 <input type="button" value="글쓰기" class="input_b"
   onclick="location='board_write.do'" />

</div>


</div>
</body>
</html>
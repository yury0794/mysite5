<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("newLine", "\n");
%>
<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/mysite5/assets/css/board.css" rel="stylesheet"
	type="text/css">
</head>
<body>
	<div id="container">
		<c:import url='/WEB-INF/views/include/header.jsp' />
		<div id="content">
			<div id="board" class="board-form">
				<form method="post" action="delete">
					<table class="tbl-ex">
						<tr>
							<th colspan="2">글보기</th>
						</tr>
						<tr>
							<td class="label">제목</td>
							<td>${BoardVO.title }</td>
						</tr>
						<tr>
							<td class="label">내용</td>
							<td>
								<div class="view-content">${BoardVO.content }</div>
							</td>
						</tr>
						<tr>
							<td class="label">첨부파일</td>
							<td id="attachFile"></td>
						</tr>
					</table>
					<input type="hidden" name="no" value="${BoardVO.no }"/>
					<div class="bottom">
						<a href="modify?no=${BoardVO.no }">글수정</a>
						<input type="submit" value="삭제">
					</div>
				</form>
			</div>
		</div>
		<c:import url='/WEB-INF/views/include/navi.jsp' />
		<c:import url='/WEB-INF/views/include/footer.jsp' />
	</div>
</body>
</html>



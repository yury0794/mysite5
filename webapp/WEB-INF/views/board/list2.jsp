<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/mysite5/assets/css/board.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<c:import url='/WEB-INF/views/include/header.jsp'/>
		<div id="content">
			<div id="board">
				<form id="search_form" action="/mysite5/board" method="get">
					<input type="text" id="kwd" name="kwd" value="${keyword }">
					<input type="submit" value="찾기">
				</form>
				
				
				<table class="tbl-ex" id="listArea">
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성일</th>
					</tr>
					<!-- 리스트영역 -->					
				</table>
				<div class="bottom">
					<input type="button" id="btn_list" value="리스트불러오기">
				</div>	
			</div>
		</div>
		<c:import url='/WEB-INF/views/include/navi.jsp'/>
		<c:import url='/WEB-INF/views/include/footer.jsp'/>
	</div>
</body>
</html>

<script>
$("#btn_list").on("click", function(){
	var trString="";
	var url ="listAjax";
	var title="황일영";
	var content="01032865102";
	
	$.ajax({
        type : 'POST',
        url : url,
        data :{"title": title, "content": content},
        /* contentType: "application/json", */
        success : function (listBoard) {
        	$.each(listBoard, function(index, boardVO) {
        		trString += "<tr>";
        		trString += "	<td>" + boardVO.no + "</td>";
        		trString += "	<td>" + boardVO.title + "</td>";
        		trString += "	<td>" + boardVO.regDate + "</td>";
        		trString += "</tr>";
        	});
        	$("#listArea").append(trString);
        	console.log(trString)
        }
    });

});

</script>
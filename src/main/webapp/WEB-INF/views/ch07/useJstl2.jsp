<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%><!-- url이 아닌 경로로 접근하기 위해 사용 -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="card m-2">
	<div class="card-header">JSTL을 이용해서 List 반복 처리</div>
	<div class="card-body">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>No</th>
					<th>Title</th>
					<th>Content</th>
					<th>Writer</th>
					<th>Date</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${boardList}" var="board" varStatus="status">
					<tr>
						<td>${board.no}</td>
						<td>${board.title}</td>
						<td>${board.content}</td>
						<td>${board.writer}</td>
						<td><fmt:formatDate value="${board.date}" pattern="yyyy-MM-dd"/></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>



<%@ include file="/WEB-INF/views/common/footer.jsp"%>
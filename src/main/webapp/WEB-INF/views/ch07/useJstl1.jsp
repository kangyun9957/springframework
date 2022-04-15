<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%><!-- 태그라이브러리 ,  c는 core태그의 약자 -->

<%@ include file="/WEB-INF/views/common/header.jsp"%><!-- url이 아닌 경로로 접근하기 위해 사용 -->
<!-- var 저장 변수, items는 배열, varStatus는 변수상태-->
<div class="card m-2">
	<div class="card-header">배열 반복 처리</div>
	<div class="card-body">
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">No</th>
					<th scope="col">Language</th>
				</tr>
			</thead>
			<tbody>
					<c:forEach items="${langs}" var="lang" varStatus="status">
						<tr>
								<td>${status.count }</td>
								<td>${lang }</td>
						</tr>
					</c:forEach>
			</tbody>
		</table>
	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp"%>
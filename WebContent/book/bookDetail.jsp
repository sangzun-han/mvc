<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ include file="../include/head.jsp"%>
<body>
	<%@ include file="../include/nav.jsp"%>
	<div class="container mt-5">
		<table class="table">
			<thead>
				<tr>
					<th scope="col">ISBN</th>
					<th scope="col">제목</th>
					<th scope="col">작가</th>
					<th scope="col">가격</th>
					
				</tr>
			</thead>
			<tbody>
					<tr>
						<th scope="row">${book.isbn}</th>
						<td>${book.title}</td>
						<td>${book.author}</td>
						<td>${book.price}</td>
					</tr>
			</tbody>
		</table>
	</div>
	<%@ include file="../include/footer.jsp"%>
</body>
</html>
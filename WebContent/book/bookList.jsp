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
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="book">
					<tr>
						<th scope="row">${book.isbn}</th>
						<td><a href="${root}/book?action=detail&isbn=${book.isbn}">${book.title}</a></td>
						<td>${book.author}</td>
						<td>${book.price}</td>
						<td>
							<a href="#" class="deleteBtn">삭제</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<%@ include file="../include/footer.jsp"%>
</body>
<script>
	const deleteBtns = document.querySelectorAll(".deleteBtn");
	deleteBtns.forEach(function(element) {
		element.addEventListener("click", function(event) {
				const isbn = this.parentNode.parentNode.children[0].innerText;
				if(confirm("삭제?")) location.href="${root}/book?action=delete&isbn="+isbn;
		})
	})
</script>
</html>
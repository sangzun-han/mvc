<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ include file="../include/head.jsp"%>
<body>
	<%@ include file="../include/nav.jsp"%>
	<div class="container mt-5">
		<form action="${root}/book" method="POST">
		  <input type="hidden" name="action" value="regist" />
		  <div class="mb-3">
		    <label for="isbn" class="form-label">ISBN</label>
		    <input type="text" class="form-control" id="isbn" name="isbn" aria-describedby="isbnHelp">
		  </div>
		  <div class="mb-3">
		    <label for="title" class="form-label">제목</label>
		    <input type="text" class="form-control" id="title" name="title">
		  </div>
		  <div class="mb-3">
		    <label for="author" class="form-label">작가</label>
		    <input type="text" class="form-control" id="author" name="author">
		  </div>
		  <div class="mb-3">
		    <label for="price" class="form-label">가격</label>
		    <input type="text" class="form-control" id="price" name="price">
		  </div>
		  <div class="mb-3">
		    <label for="description" class="form-label">설명</label>
		    <input type="text" class="form-control" id="description" name="description">
		  </div>
		  <div class="mb-3">
		    <label for="img" class="form-label">이미지</label>
		    <input type="text" class="form-control" id="img" name="img">
		  </div>
		  <button type="submit" class="btn btn-primary">등록하기</button>
	    </form>
	</div>
	<%@ include file="../include/footer.jsp"%>
</body>
</html>
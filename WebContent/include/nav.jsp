<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<nav class="navbar navbar-expand-lg bg-light">
	<div class="container-fluid">
		<a class="navbar-brand" href="${root}/">Navbar</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="${root}/book?action=list">책목록</a></li>
				<c:choose>
					<c:when test="${empty sessionScope.id}">
						<li class="nav-item"><a class="nav-link" href="#" data-bs-toggle="modal" data-bs-target="#loginModal">로그인</a></li>
					</c:when>
					<c:otherwise>
						<li class="nav-item"><a class="nav-link"href="${root}/book?action=goRegist">책 등록</a></li>
						<li class="nav-item"><a href="#" class="nav-link" id="logout" onclick=logout()>로그아웃</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</div>
</nav>
<!-- Modal -->
<div class="modal fade" id="loginModal" tabindex="-1"
	aria-labelledby="loginModallLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="loginModalLabel">로그인</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			</div>
			<div class="modal-body">
				<form action="${root}/user" method="POST">
					<input type="hidden" name="action" value="login" />
 					<div class="mb-3">
						<label for="id" class="form-label">아이디</label> 
						<input type="text" class="form-control" id="email" aria-describedby="emailHelp" name="id" value="${cookie.saveId.value}">
					</div>
					<div class="mb-3">
						<label for="password" class="form-label">비밀번호</label>
						<input type="password" class="form-control" id="password" name="password">
					</div>
					<div class="mb-3 form-check">
						<label class="form-check-label" for="exampleCheck1" name="remember">아이디 기억하기</label>
						<input type="checkbox" class="form-check-input" id="exampleCheck1" name="remember">
					</div>
				<div class="modal-footer">
				<button type="button" class="btn btn-secondary"data-bs-dismiss="modal">Close</button">
				<button type="submit" class="btn btn-primary">로그인</button>
				</form>
			</div>
		  </div>
		</div>
	</div>
</div>


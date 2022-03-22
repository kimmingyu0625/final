<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/views/include/top.jsp" />
<div class="container-fluid pt-3">
	<div class="row p-3">
		<h4>${loginUser.userName }
			<small>(${loginUser.userId })</small>
		</h4>
	</div>
	<div class="row mt-2">
		<div class="col-3">
			<ul class="nav nav-pills flex-column">
				<li class="nav-item"><a class="nav-link active" href="#">내정보</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="/settings/auth">메일인증</a></li>
				<li class="nav-item"><a class="nav-link" href="/message">메세지</a>
					
				</li>
			</ul>
		</div>
		<div class="col-9">
			
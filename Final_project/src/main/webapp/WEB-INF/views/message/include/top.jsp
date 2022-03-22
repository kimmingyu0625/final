<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container-fluid pt-3">
	<div class="row pl-3">
		<h4>${loginUser.userName }
			<small>(#${loginUser.userId }) |</small>
				
		</h4>
	</div>
	<div class="pt-3">
		<ul class="nav nav-tabs">
			<li class="nav-item"><a class="nav-link active" href="/message">받은쪽지함<span class="badge badge-light">${count}</span></a>
			</li>
			<li class="nav-item"><a class="nav-link" href="/message/sent">보낸쪽지함</a></li>
			<li class="nav-item"><a class="nav-link" href="/message/write">쪽지보내기</a></li>
		</ul>
	</div>
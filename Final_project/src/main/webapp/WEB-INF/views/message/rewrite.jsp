<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/views/include/top.jsp" />
<jsp:include page="/WEB-INF/views/message/include/top.jsp" />

<div class="pt-3">
	<h5>답장보내기</h5>
</div>
<form  action="/message/insert" method="post" autocomplete="off">
	<div class="bg-secondary text-white p-2 mb-1" >
		<b>받을사람</b>
	</div>
	<div class="form-group">
		<div class="form-row">
			<div class="col-3">
				<input type="text" name="recipient" value="${list }" class="form-control" placeholder="받을사람 입력" />
			</div>
			<div class="col-9">
				<select multiple class="form-control" id="list"></select>
			</div>
		</div>
	</div>
	<div class="bg-secondary text-white p-2 mb-1" >
		<b>쪽지내용</b>
	</div>
	<div class="form-group">
		<div class="custom-file">
			<input type="file" class="custom-file-input" id="customFile">
			<label class="custom-file-label" for="customFile">첨부파일</label>
		</div>
		<div class="pl-1">
		<small class="text-danger" >첨부파일은 하나만 가능하고
			20MB이상은 삼가해주시기바랍니다.</small>
		</div>
	</div>
	<div class="form-group">
		<textarea class="form-control" rows="10" name="content" id="comment" placeholder="쪽지 내용.."></textarea>
	</div>
	<button type="button" class="btn btn-secondary btn-block mt-2" id="bt" onclick="$('form').submit()">쪽지보내기</button>
</form>
<script>
	$(".custom-file-input").on(
			"change",
			function() {
				var fileName = $(this).val().split("\\").pop();
				$(this).siblings(".custom-file-label").addClass("selected")
						.html(fileName);
			});
</script>


<jsp:include page="/WEB-INF/views/message/include/bottom.jsp" />
<jsp:include page="/WEB-INF/views/include/bottom.jsp" />
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="/WEB-INF/views/personal/include/top.jsp" />
<h5>프로필 사진 변경</h5>
<form action="/settings/profile" method="post" autocomplete="off" enctype="multpart/form-data">
	<div>
		<img src="/profiles/default-profile.png"
			class="mx-auto rounded d-block" style="width: 180px; height:180px" id="profile"/>
	<label class="text-info">권장 이미지 파일의 크기는 180 X 180 px 입니다.</label>
	</div>
	<div class="custom-file">
		<input type="file" class="custom-file-input" id="customFile"
			accept="image/*"> <label class="custom-file-label"
			for="customFile">파일 선택</label>
	</div>
	<button type="button" class="btn btn-secondary btn-block mt-2" id="bt">변경</button>
</form>
<script>
	$(".custom-file-input").on(
			"change",
			function() {
				var fileName = $(this).val().split("\\").pop();
				$(this).siblings(".custom-file-label").addClass("selected")
						.html(fileName);
				
				var reader = new FileReader();
				reader.onload = function(e) {
					$("#profile").attr("src", e.target.result);
				}
		
				reader.readAsDataURL(this.files[0]);
			});
	$("#profile").on("click", function(){
		$("#customFile").click();
	})
</script>
<h5>개인정보 변경</h5>
<form action="/settings/modify" method="post" autocomplete="off">
	<div class="form-group">
		<label for="zipcode">주소</label>
		<div class="form-row">
			<div class="col-3">
				<input type="text" class="form-control" placeholder="우편번호"
					id="zipcode" name="zipcode" value="${loginUser.zipcode }" />
			</div>
			<div class="col-9">
				<input type="text" class="form-control" placeholder="상세주소"
					name="address" id="address" value="${loginUser.address }" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<select class="form-control" id="sel1" name="sellist1"
			style="display: none;">
		</select>
	</div>
	<div class="form-group">
		<label for="email">이메일</label> <input type="email"
			class="form-control" name="email" value="${loginUser.email }"
			placeholder="등록할 이메일" id="email" />
	</div>
	<button type="button" class="btn btn-secondary btn-block mt-2" id="bt">변경</button>
</form>


<jsp:include page="/WEB-INF/views/personal/include/bottom.jsp" />
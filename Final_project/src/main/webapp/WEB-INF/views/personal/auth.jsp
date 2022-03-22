<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="/WEB-INF/views/personal/include/top.jsp" />
<h5>이메일 인증</h5>

<c:choose>
	<c:when test="${empty loginUser.email }">
		<div class="alert alert-danger">
			<strong>인증불가!</strong> 먼저 당신의 계정에 이메일 주소를 등록해주십시요.
		</div>
	</c:when>
	<c:when test="${loginUser.auth eq 'Y'}">
		<div class="alert alert-info">
			<strong>인증불가!</strong> 당신의 이메일 계정은 이미 인증을 받았습니다.
		</div>
	</c:when>
	<c:otherwise>
		<button type="button" class="btn btn-secondary mt-2" id="req">인증키 발송</button>
		<form action="/settings/verify" method="post" autocomplete="off">
			<div class="form-group">
				<label for="zipcode">인증코드</label> <input type="text"
					class="form-control" name="authKey" placeholder="등록할 이메일"
					id ="auth" />
			</div>
			<div class="form-group">
				<select class="form-control" id="sel1" name="sellist1"
					style="display: none;">
				</select>
			</div>
			<button type="button" class="btn btn-secondary  mt-2"
				id="bt" onclick="$('form').submit()">인증</button>

	<script >
		var code ="";
	
		$("#req").on("click",function(){
			$("#req").prop("disabled",true)
		
			
			 
			 
			$.ajax({
				url:"/settings/reqAuth",
				async :false,
				
				
				
			}).done(function(rst){
					
				console.log(rst);
				$("#req_result").html("등록된 이메일로 인증번호가 발생되었습니다.")
				code = rst;
			
			});
		
			
		});
				
		
		
		
		
	
	</script>

		</form>
	
	</c:otherwise>
</c:choose>


<jsp:include page="/WEB-INF/views/personal/include/bottom.jsp" />
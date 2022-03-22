<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<jsp:include page="/WEB-INF/views/include/top.jsp"></jsp:include>
<div class="container pt-3">

	

<h3>회원가입 <small>2단계(선택입력)</small></h3>

<form:form  action="/signupOk" method="post" autocomplete="off" modelAttribute="accountVo">
  <div class="form-group">
    <label for="email">이메일</label>
    <form:input type="text" class="form-control" path="email" placeholder="Email" id="email"/>
  
  </div>
  <div class="form-group">
    <label for="zipcode">주소</label>
    
    <div class="form-row">
    <div class="col-3">
    <form:input type="text" path="zipcode" class="form-control" placeholder="우편주소" id="zipcode"/>
    </div>
    <div class="col-9">
    <form:input type="text" path="address" class="form-control" placeholder="상세주소" id="address"/>
    </div>
    </div>
  </div>
  
  	 <div class="form-group">
  
  		<select class="form-control" id="sel1" name="sellist1" style="display: none;">
  
  
  		</select>
	</div>
  
  
  	<script >
  	$("#address").on("change",function(){
  		
  			$.ajax({
  				
  				url : "/find/zipcode",
  				data: {
  					data : $(this).val()
  					
  		

  			
  				}
  				
  				
  			}).done(function(rst){
  				var _html ="";
  	  			
  	  			for(var i=0; i<rst.length; i++){
  	  				
  	  				_html += "<option>"+rst[i].zipNo+"|" + rst[i].roadAddr+"</option>";
  	  				
  	  			}
  	  			$("#sel1").html(_html);
  	  			$("#sel1").show();
  				
  			});
  		
  		
  	}).on("keydown",function(){
  		
  			$("#sel1").hide();
  		
  	});
  	
  	
  	</script>
  
  
  <button type="button" class="btn btn-primary" onclick="$('form').submit()" >Next</button>
</form:form>






<script type="text/javascript">
	function valid_form(){
		
			if($("#id").val().length >=4){
				
				$("#id").addClass("is-valid");
			}
			if($("#pwd").val() != $("#pwd_confirm").val()){
				$("#pwd_confirm").addClass("is-invalid");
				$("#pwd_confirm").focus();
				
				return false;
			}
		
	}

	
	
	

</script>



</div>
<jsp:include page="/WEB-INF/views/include/bottom.jsp"></jsp:include>



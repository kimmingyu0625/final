<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<jsp:include page="/WEB-INF/views/include/top.jsp"></jsp:include>
<div class="container pt-3">

	

<h3>회원가입 <small>1단계(필수입력)</small></h3>

<form:form  action="/signup" method="post" autocomplete="off" onsubmit="return valid_form();"
	modelAttribute="accountVo">
  <div class="form-group">
    <label for="id">아이디</label>
    <form:input type="text" class="form-control" path="userId" placeholder="Id" id="id"/>
    <b> <form:errors path="userId"/> </b>
  </div>
  <div class="form-group">
    <label for="name">이름</label>
    <form:input type="text" path="userName" class="form-control" placeholder="name" id="name"/>
    <b> <form:errors path="userName"/> </b>
  </div>
  <div class="form-group">
    <label for="pwd">Password:</label>
    <form:input type="password" path="userPass" class="form-control" placeholder="Enter password" id="pwd"/>
  </div>
  <div class="form-group">
    <label for="pwd">Password confirm:</label>
    <input type="password"  class="form-control" placeholder="Enter password confirm" id="pwd_confirm"/>
  </div>
  
  <button type="submit" class="btn btn-primary" >Next</button>
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



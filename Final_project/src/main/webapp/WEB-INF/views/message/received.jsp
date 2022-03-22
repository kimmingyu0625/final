<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/views/include/top.jsp" />
<jsp:include page="/WEB-INF/views/message/include/top.jsp" />

<div class="pt-3">
	<h5>받은쪽지함()</h5>
</div>
<div class="table-responsive-sm">

	<form action="/message/delete" method="post">
	<table class="table table-success">
		<thead class="thead-light">
			<tr>
				<th>#</th>
				<th>내용</th>
				<th>보낸사람</th>
				<th>상태</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><input type="checkbox" /></td>
				<td class="white-space: nowrap;overflow:hidden;text-overflow: ellipsis;">
				스프링 프레임워크(영어: Spring Framework)는 자바 플랫폼을 위한 오픈 소스 애......
				</td>
				<td>관리자(admin)</td>
				<td class="text-error">읽지않음</td>
			</tr>
			<tr>
				<td><input type="checkbox" /></td>
				<td class="white-space: nowrap;overflow:hidden;text-overflow: ellipsis;">
				제어 반전(IoC: Inversion of Control) 컨테이너는 스프링의 가장 중요하고 핵심적.....
				</td>
				<td>관리자(admin)</td>
				<td class="text-error">읽지않음</td>
			</tr>
			<c:forEach items="${list }" var ="list">
			
			<tr>
				<td><input type="checkbox" name="ch" value="${list.no }"/></td>
				<td class="white-space: nowrap;overflow:hidden;text-overflow: ellipsis;">
				<a href="/message/detail?no=${list.no }&writer=${list.recipient}">${ list.content }</a>
				</td>
				<td>${list.user_name }</td>
				<td class="text-error" id="ee">${list.readdate eq null ? "읽지않음" :"읽음"} </td>
			</tr>
				
			
			
			
			</c:forEach>
			
			
		</tbody>
	</table>
			
			<input type="submit" id="bt" value="삭제"> 
		</form>
	
	
	
</div>

<div>
	
		<script >
		
		
		
		
	
	$("#bt").on("click",function(){
		
		
		var checkarr =[];
		
		
		$("input[name='ch']:checked").each(function(){
			
			checkarr.push($(this).val());
		});
			
		
			
		$.ajax({
			
			url:'/message/delete',
			type:'post',
			
			data:{
				checkarr : checkarr 
				
			}
			
		}).done(function(rst){
			
			
			
			
		})
		
		
		
		
		
		
	});

	
	
	
	
	
		
	
	</script>

</div>




<jsp:include page="/WEB-INF/views/message/include/bottom.jsp" />
<jsp:include page="/WEB-INF/views/include/bottom.jsp" />
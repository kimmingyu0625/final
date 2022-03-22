<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="table-responsive-sm">
	
	<table class="table table-success">
		<thead class="thead-light">
			<tr>
				<th>#</th>
			
				<th>보낸사람</th>
				<th>상태</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				
				<td class="white-space: nowrap;overflow:hidden;text-overflow: ellipsis;">
				<a href="message/detail">${ list.content }</a>
				</td>
				<td id=db>${list.writer }</td>
				<td class="text-error">${list.readdate eq null ? "읽지않음" :"읽음"}</td>
			</tr>
				
			
		</tbody>
	</table>
			<a href="/message/rewrite?writer=${ list.writer }" >답장</a> 
	
			

	
		
			
</div>




</body>
</html>
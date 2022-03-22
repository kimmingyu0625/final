<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

	
<div class="container">
		<div class="toast" data-autohide="false">
    <div class="toast-header">
      <strong class="mr-auto text-primary">Toast Header</strong>
      <small class="text-muted">5 mins ago</small>
      <button type="button" class="ml-2 mb-1 close" data-dismiss="toast">&times;</button>
    </div>
    <div class="toast-body">
      Some text inside the toast body
    </div>
  </div>
</div>	
	

	
	
<script>

	var serverName = location.host;
	var ws =  new WebSocket("ws://"+serverName+"/ws/alert");
	
	ws.onmessage = function(recv){
	
			console.log(recv.data);
		
			var obj = JSON.parse(recv.data);
			
			$(".toast").toast("show");
		
	}	
	
	
		

</script>

<body>



</body>
</html>
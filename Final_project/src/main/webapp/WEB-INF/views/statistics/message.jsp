<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<jsp:include page="/WEB-INF/views/include/top.jsp"></jsp:include>
<div class="container">
	<div id="chart_div" style="width: 100%; height: 500px;"></div>

<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {
    	  $.ajax({
    		  url:"/message/data"
    		  
    		  
    	  }).done(function(rst){
    		  
    		  var data = google.visualization.arrayToDataTable(rst
    	          );

    	        var options = {
    	          title: 'Company Performance',
    	          hAxis: {title: 'Year',  titleTextStyle: {color: '#333'}},
    	          vAxis: {minValue: 0}
    	        };

    	        var chart = new google.visualization.AreaChart(document.getElementById('chart_div'));
    	        chart.draw(data, options);
    	  })
    		  
      }
    	  
       
    </script>





</div>
<jsp:include page="/WEB-INF/views/include/bottom.jsp"></jsp:include>
    
    
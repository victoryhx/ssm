<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>json交互页面</title>

<script type="text/javascript" src="<%=basePath%>style/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
	//请求json,输出json
	function requestJson() {
        $.ajax({
        	type:'post',
        	url:'${pageContext.request.contextPath }/Json/requestJson.action',
        	contentType:'application/json;charset=utf-8',
        	//数据格式是json串
        	data:'{"name":"wuyuelong666","age":111}',
        	success:function(data){
        		alert(data.name);
        	}
        	});
	}
	//请求key/value,输出json
	function responseJson() {
		 $.ajax({
	        	type:'get',
	        	url:'${pageContext.request.contextPath }/Json/responseJson.action?name=Tom',
	        	success:function(data){
	        		  for(var i=0; i<data.length; i++)  
	        		  {  
	        		     alert(data[i].name+" " + data[i].age)  
	        		  }
	        	}
	        	});
	}
	//restful
	function responseJson() {
		 $.ajax({
	        	type:'get',
	        	url:'${pageContext.request.contextPath }/Json/restfull/Tom',
	        	success:function(data){
	        		  for(var i=0; i<data.length; i++)  
	        		  {  
	        		     alert(data[i].name+" " + data[i].age)  
	        		  }
	        	}
	        	});
	}
</script>
</head>
<body>
	<input type="button" onclick="requestJson()" value="请求json,输出json" />
	<input type="button" onclick="responseJson()" value="请求key/value,输出json" />
	<input type="button" onclick="responseJson()" value="请求restful类型参数传递,输出json" />
</body>
</html>
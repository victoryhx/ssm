<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>修改页面</title>
</head>

<body>
	<form action="editInfo.action">
		<table>
			<tr>
				<td>用户姓名:<input type="text" name="name" id="name"
					value="${ edit.name}" /> <br />
				</td>
			</tr>
			<tr>
				<td>用户年龄:<input type="text" name="age" id="age" 
				    value="${edit.age }" /><br />
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="修改" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>

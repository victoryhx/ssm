<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>系统登录</title>
</head>

<body>
	<form action="${pageContext.request.contextPath }/Login/login.action">
		<table>
			<tr>
				<td>用户账号：<input type="text" name="username" /><br /></td>
			</tr>
			<tr>
			    <td>用户密码：<input type="text" name="password" /><br /></td>
			</tr>
			<tr>
				<td><input type="submit" value="登录" /></td>
			</tr>
		</table>
	</form>
</body>
</html>

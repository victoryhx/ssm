<%@page import="org.omg.CORBA.portable.OutputStream"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>首页面</title>
<link href="<%=request.getContextPath() %>/style/css/page.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript"
	src="<%=request.getContextPath() %>/style/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {

	});
	function queryAllPerson(pageNum, pageSize) {
		$("#edit_area_div").load(
				"${pageContext.request.contextPath }/Index/index.action?pageNum="
						+ pageNum + "&pageSize=" + pageSize);
	}
</script>

</head>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<div id="edit_area_div">
					<div>
						欢迎您,${username }
						<c:if test="${username!=null }">
							<a href="${pageContext.request.contextPath }/Login/logout.action">退出</a>
						</c:if>
					</div>
					<div>
						<a href="${pageContext.request.contextPath }/User/add.action">添加</a><br />
					</div>
					<div>
						<a href="${pageContext.request.contextPath }/Json/jsonIndex.action">json交互测试</a><br />
					</div>
					<form action="${pageContext.request.contextPath }/Index/index.action">
						<div>
							<input id="textInput" name="textInput" type="text"
								placeholder="请输入用户名">
							<button id="queryButton" type="submit" class="button">查询</button>
						</div>
					</form>
					
					<table class="table" id="personList_table">
						<thead>
							<tr>
								<td width="60px">id</td>
								<td width="120px">name</td>
								<td width="60px">age</td>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="user" items="${pagehelper.list}"
								varStatus="status">
								<tr>
									<td>${user.id}</td>
									<td>${user.name}</td>
									<td>${user.age}</td>
									<td><a
										href="${pageContext.request.contextPath }/User/edit.action?id=${user.id}">修改</a>
									</td>
									<td><a
										href="${pageContext.request.contextPath }/User/delete.action?id=${user.id}">删除</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
						<!-- <tr>
							<td>翻到第一页:${page.firstPage } 翻到上一页:${page.prePage} 翻到下一页:
								${page.nextPage} 翻到最后一页:${page.lastPage }</td>
						</tr> -->
					</table>
					<div id="page_div">
						<%@ include file="/WEB-INF/jsp/common/pagehelper.jsp"%>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
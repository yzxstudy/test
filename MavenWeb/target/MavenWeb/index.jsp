<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>studentList</title>
</head>
<body>

<p><a href="<%=request.getContextPath()%>/student/add">增加学生</a></p>
	<table>
	
		<tr>
			<th>ID</th>
			<th>姓名</th>
			<th>成绩</th>
			<th>性别</th>
			<th>学号</th>
			<th>操作</th>
		</tr>
		
		
		
		
		<c:forEach items="${students}" var="stu">
		<tr>
			<td>${stu.studentId}</td>
			<td>${stu.studentName}</td>
			<td>${stu.studentScore}</td>
			<td>
			<c:if test="${stu.studentSex==0}">女</c:if>
			<c:if test="${stu.studentSex==1}">男</c:if>
			</td>
			<td>${stu.studentNumber}</td>
			<td><a href="<%=request.getContextPath()%>/student/delete?studentId=${stu.studentId}">删除</a></td>
		</tr>
		</c:forEach>
		
	</table>
</body>
</html>
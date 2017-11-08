<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

<form action="<%=request.getContextPath()%>/student/add" method="post">

	<table>
		<tr>
			<td>学生姓名:</td>
			<td><input type="text" name="studentName" id="studentName"/></td>
		</tr>
		<tr>
			<td>学生学号:</td>
			<td><input type="text" name="studentNumber" id="studentNumber"/></td>
		</tr>
		<tr>
			<td>学生分数:</td>
			<td><input type="text" name="studentScore" id="studentScore"/></td>
		</tr>
		<tr>
			<td>学生性别:</td>
			<td>
				<select id="studentSex" name="studentSex">
					<option value="1">男</option>
					<option value="0">女</option>
				</select>
			</td>
		</tr>
		
		<tr>
			<td><input type="submit" value="提交"/></td>
			<td><input type="reset" value="取消"/></td>
		</tr>
	</table>
</form>
</body>
</html>
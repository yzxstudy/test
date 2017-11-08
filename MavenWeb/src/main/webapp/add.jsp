<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="<%=request.getContextPath()%>/ajax/jquery.js"></script>
<script type="text/javascript">


function isEmptyString(str)
{
	if(str=="" || str.length<1)
	{
		return true;
	}
	return false;
}

$(function(){
	$('#tijiaobtn').bind('click',function(){
		alert('begin');
		var student = {};
		student.studentId=1;
		student.studentName = $('#studentName').val();
		student.studentNumber = $('#studentNumber').val();
		student.studentScore = parseInt($('#studentScore').val());
		student.studentSex = parseInt($('#studentSex').val());
		
		alert(JSON.stringify(student));
		if (isEmptyString(student.studentName)) {
			alert('学生姓名不能为空');
			return;
		}
		if (isEmptyString(student.studentNumber)) {
			alert('学号不能为空');
			return;
		}
		if (isEmptyString(student.studentScore)) {
			alert('分数不能为空');
			return;
		}
		if (isEmptyString(student.studentSex)) {
			alert('性别不能为空');
			if(student.studentSex!='1' && student.studentSex!='2')
				{
				alert('性别只能是男和女');
				return ;
				}
			return;
		}

		
		$.ajax({
			async : true,
			success : function(result) {
				if (result.code == '0000') {
					alert('添加成功');
				} else {
					alert(result.msg);
				}
			},
			contentType : "application/json; charset=utf-8",
			data : JSON.stringify(student),
			dataType : "json",
			type : "post",
			url : "<%=request.getContextPath()%>/student/add"
		});
	});
	
	
});
</script>

<body>



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
			<td><input type="button" value="提交" id='tijiaobtn'/></td>
			<td><input type="reset" value="取消"/></td>
		</tr>
	</table>
</body>
</html>
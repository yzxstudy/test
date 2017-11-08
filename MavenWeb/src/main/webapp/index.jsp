<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>studentList</title>
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
	
	$('#addStudent').hide();
	$('#listInfo').show();
	$('#addBtn').bind('click',function(){
		$('#addStudent').show();
		$('#listInfo').hide();
	});
	
	$('#listBtn').bind('click',function(){
		$('#addStudent').hide();
		$.ajax({
			async : true,
			success : function(result) {
				$('#listInfo').html('');
				$('#listInfo').html('<tr>'+
						"<th>ID</th>"+
						"<th>姓名</th>"+
						"<th>成绩</th>"+
						"<th>性别</th>"+
						"<th>学号</th>"+
						"<th>操作</th>"+
					'</tr>');
			
				$(result).each(function(index)
						{
							var delUrl = '<td><a class="student_del" studentId="'+this.studentId+'" href="#">删除</a></td>';
							$('#listInfo').append('<tr>'+
									'<td>'+this.studentId+'</td>'+
									'<td>'+this.studentName+'</td>'+
									'<td>'+this.studentScore+'</td>'+
									'<td>'+this.studentSex+'</td>'+
									'<td>'+this.studentNumber+'</td>'+
									delUrl+
							'</tr>');
						});
				
				$('.student_del').click(function(){
					var sid = $(this).attr("studentId");
					alert(sid);
				});
			},
			error:function()
			{
				alert('后台发生异常或无连接');
			},
			//contentType : "application/json; charset=utf-8",
			dataType : "json",
			type : "post",
			url : "<%=request.getContextPath()%>/student/list"
		});
		$('#listInfo').show();
	});
	
	
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

<p><a href="#" id="addBtn" >增加学生</a></p>
<p><a href="#" id="listBtn" >学生列表</a></p>
<table id="addStudent">
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

	<table id="listInfo">
	
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
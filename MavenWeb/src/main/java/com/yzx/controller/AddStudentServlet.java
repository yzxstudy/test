package com.yzx.controller;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.yzx.bean.ResponseResult;
import com.yzx.bean.Student;
import com.yzx.dao.IStudentDao;
import com.yzx.dao.impl.StudentDaoImpl;


/**
 * 使用注解描述Servlet
 * @author Luxh
 */

/**
 * 注解WebServlet用来描述一个Servlet
 * 属性name描述Servlet的名字,可选
 * 属性urlPatterns定义访问的URL,或者使用属性value定义访问的URL.(定义访问的URL是必选属性)
 */
@WebServlet(name="AddstudentServlet",urlPatterns="/student/add")
public class AddStudentServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	IStudentDao studentDao = new StudentDaoImpl();
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    		request.getServletContext().getRequestDispatcher("/add.jsp").forward(request, response);
    }
    
    private void goIndex(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	List<Student> stus = studentDao.queryAllStudents();
		request.setAttribute("students", stus);
		request.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	ResponseResult result = new ResponseResult();
    	result.setCode("0001");
    	result.setMsg("未知错误,请联系开发管理员");
    	try {
    		request.setCharacterEncoding("utf-8");
    		response.setCharacterEncoding("utf-8");
    		
    		InputStream is = request.getInputStream();
    		
    		InputStreamReader reader = new InputStreamReader(is,"utf-8");
    		
    		StringBuffer json = new StringBuffer();
    		int b = -1;
    		
    		while((b=reader.read())!=-1)
    		{
    			json.append((char)b);
    		}
    		String jsonString = json.toString();
			
			Student student = JSON.parseObject(jsonString, Student.class);
			int rowCount = this.studentDao.insertStudent(student);
			
			if(rowCount>=1)
			{
				result.setCode("0000");
		    	result.setMsg("插入学生成功");
		    	
			}else
			{
				result.setCode("0002");
	    		result.setMsg("插入学生失败");
			}
		}  catch (Exception e) {
			result.setCode("0003");
	    	result.setMsg("后台发生异常:"+e.getMessage());
			e.printStackTrace();
		} 
    	
    	response.getOutputStream().write(JSON.toJSONString(result).getBytes("utf-8"));
    	
    	response.getOutputStream().flush();
    	
    }

}

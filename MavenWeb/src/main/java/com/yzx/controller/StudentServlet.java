package com.yzx.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
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
@WebServlet(name="delStudentServlet",urlPatterns="/student/list")
public class StudentServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	IStudentDao studentDao = new StudentDaoImpl();
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   
    	System.out.println("doget...");
    	
    	System.out.println(request.getContextPath());
    	try {
			List<Student> stus = studentDao.queryAllStudents();
			request.setAttribute("students", stus);
			
			request.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    	
    	
    	
    	
    	
    }
    
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   
	    request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/json; charset=utf-8");
    	try {
			List<Student> stus = studentDao.queryAllStudents();
			response.getOutputStream().write(JSON.toJSONString(stus).getBytes("utf-8"));
	    	
	    	response.getOutputStream().flush();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    	
    }

}

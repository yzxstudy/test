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

import com.yzx.bean.Student;
import com.yzx.dao.IStudentDao;
import com.yzx.dao.impl.StudentDaoImpl;


/**
 * ʹ��ע������Servlet
 * @author Luxh
 */

/**
 * ע��WebServlet��������һ��Servlet
 * ����name����Servlet������,��ѡ
 * ����urlPatterns������ʵ�URL,����ʹ������value������ʵ�URL.(������ʵ�URL�Ǳ�ѡ����)
 */
@WebServlet(name="delstudentServlet",urlPatterns="/student/delete")
public class DelStudentServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	IStudentDao studentDao = new StudentDaoImpl();
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	try {
    		int studentId = Integer.parseInt(request.getParameter("studentId"));
        	studentDao.deleteStudent(studentId);
			List<Student> stus = studentDao.queryAllStudents();
			request.setAttribute("students", stus);
			
			request.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    	
    	
    }

}

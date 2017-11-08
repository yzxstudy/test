package com.yzx.controller;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
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
 * Servlet implementation class TestAjax
 */
@WebServlet("/ajax")
public class TestAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestAjax() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	IStudentDao studentDao = new StudentDaoImpl();
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			String userName = request.getParameter("un");
			
			System.out.println(userName);
			List<Student> stus = studentDao.queryAllStudents();

			String json = JSON.toJSONString(stus);
			
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/json;charset=utf-8");
			response.getOutputStream().write(json.getBytes("utf-8"));
			response.getOutputStream().flush();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	public static void main(String[] args) throws SQLException, IOException {
		URL url = new URL("http://localhost:8080/MavenWeb/ajax");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoInput(true);
		conn.setDoOutput(true);
		
		
		conn.setRequestMethod("POST");
		conn.setRequestProperty("content-type", "application/x-www-form-urlencoded");
		conn.getOutputStream().write("un=123".getBytes());
		conn.getOutputStream().close();
		InputStream is = conn.getInputStream();
		
		if(conn.getResponseCode()==200)
		{
			byte[] b = new byte[is.available()];
			
			is.read(b);
			
			System.out.println(new String(b));
		}
		
		is.close();
		conn.disconnect();
		
	}

}

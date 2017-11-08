package com.yzx.controller;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 使用注解描述Servlet
 * @author Luxh
 */

/**
 * 注解WebServlet用来描述一个Servlet
 * 属性name描述Servlet的名字,可选
 * 属性urlPatterns定义访问的URL,或者使用属性value定义访问的URL.(定义访问的URL是必选属性)
 */
@WebServlet(name="AonServlet",urlPatterns="/testImage")
public class TestServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FileInputStream fis;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userName = request.getParameter("studentName");
        
        System.out.println(userName);
        response.setCharacterEncoding("utf-8");
        response.setContentType("image/jpeg");
        OutputStream out  = response.getOutputStream();
        File file = new File("e:/a.jpg");
        fis = new FileInputStream(file);
        int i = -1;
        while((i=fis.read())!=-1)
        {
        	out.write(i);
        }
        out.flush();
        out.close();
    }

}

package com.yzx.dao.impl;
import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;

import com.yzx.bean.Student;


public class StudentDaoImplTest {



	@Test
	public void testInsertStudent() throws SQLException {
		Student student = new Student();
		student.setStudentName("test1");
		student.setStudentNumber("test1");
		student.setStudentSex(1);
		student.setStudentScore(100);
		StudentDaoImpl dao = new StudentDaoImpl();
		
		int inserCount = dao.insertStudent(student);
		
		Assert.assertTrue(inserCount==1);
		
		Student find = dao.queryStudentByNumber(student.getStudentName());
		
		Assert.assertTrue(find!=null);
		
		Assert.assertEquals(find.getStudentName(), student.getStudentName());
		
		dao.deleteStudent(find.getStudentId());
		
		find = dao.queryStudentByNumber(student.getStudentName());
		
		Assert.assertTrue(find==null);
		
	}

}

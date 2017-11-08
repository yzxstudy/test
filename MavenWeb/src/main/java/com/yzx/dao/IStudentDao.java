package com.yzx.dao;

import java.sql.SQLException;
import java.util.List;

import com.yzx.bean.Student;

public interface IStudentDao {

	/**
	 * 插入单个学生
	 * @param student 要插入的学生对象
	 * @return 插入的个数
	 */
	public int insertStudent(Student student);
	
	public int updateStudent(Student student);
	
	public int deleteStudent(int studentId);
	
	public int deleteStudent(int[] studentIds);
	
	public int insertStudents(List<Student> list);
	
	public Student queryStudentById(int studentId);
	
	public Student queryStudentByNumber(String studentNumber) throws SQLException;
	
	public List<Student> queryAllStudents() throws SQLException;
	
	public List<Student> queryStudentByName(String name);
	
	
}

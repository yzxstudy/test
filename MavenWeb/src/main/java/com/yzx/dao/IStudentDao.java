package com.yzx.dao;

import java.sql.SQLException;
import java.util.List;

import com.yzx.bean.Student;

public interface IStudentDao {

	/**
	 * ���뵥��ѧ��
	 * @param student Ҫ�����ѧ������
	 * @return ����ĸ���
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

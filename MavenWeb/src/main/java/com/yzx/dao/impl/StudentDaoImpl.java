package com.yzx.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.yzx.bean.Student;
import com.yzx.dao.BaseDao;
import com.yzx.dao.IStudentDao;

public class StudentDaoImpl extends BaseDao implements IStudentDao{

	@Override
	public int insertStudent(Student student) {
		String sql = "INSERT INTO student(student_id,student_name, student_number, student_score, student_sex) "
				+ "values(student_id_seq.nextval,?,?,?,?)";
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			conn = BaseDao.ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, student.getStudentName());
			ps.setString(2, student.getStudentNumber());
			ps.setInt(3, student.getStudentScore());
			ps.setInt(4, student.getStudentSex());
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public int updateStudent(Student student) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteStudent(int studentId) {
		String sql = "delete from student where student_id=?";
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			conn = BaseDao.ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, studentId);
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public int deleteStudent(int[] studentIds) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertStudents(List<Student> list) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Student queryStudentById(int studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student queryStudentByNumber(String studentNumber) throws SQLException {
		String sql = "SELECT student_id,student_name," + "student_number,student_score,"
				+ "student_sex FROM student where student_number=?";
		
		System.out.println(sql);
		Connection conn = BaseDao.ds.getConnection();
		PreparedStatement st = conn.prepareStatement(sql);	
		st.setString(1, studentNumber);
		ResultSet rs = st.executeQuery();
		List<Student> stus =  this.mapRowToStudent(rs);
		st.close();
		rs.close();
		conn.close();
		if(stus!=null && !stus.isEmpty())
			return stus.get(0);
		else
			return null;

	}

	public List<Student> mapRowToStudent(ResultSet rs) throws SQLException
	{
		List<Student> stus = new ArrayList<Student>();
		while(rs.next())
		{
			int studentId = rs.getInt("student_id");
			String studentName = rs.getString("student_name");
			String studentNumber = rs.getString("student_number");
			int studentScore = rs.getInt("student_score");
			int studentSex = rs.getInt("student_sex");
			
			Student s = new Student();
			s.setStudentId(studentId);
			s.setStudentName(studentName);
			s.setStudentNumber(studentNumber);
			s.setStudentScore(studentScore);
			s.setStudentSex(studentSex);
			
			stus.add(s);
		}
		return stus;
	}
	@Override
	public List<Student> queryAllStudents() throws SQLException {
		String sql = "SELECT student_id,student_name," + "student_number,student_score,"
				+ "student_sex FROM student ";
		Connection conn = BaseDao.ds.getConnection();
		Statement st = conn.createStatement();	
		ResultSet rs = st.executeQuery(sql);
		List<Student> stus =  this.mapRowToStudent(rs);
		st.close();
		rs.close();
		conn.close();
		return stus;
	}

	@Override
	public List<Student> queryStudentByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}

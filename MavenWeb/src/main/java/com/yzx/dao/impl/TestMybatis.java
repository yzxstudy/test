package com.yzx.dao.impl;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.yzx.bean.Student;
import com.yzx.mapper.StudentMapper;



public class TestMybatis {

	
	public static void main(String[] args) throws IOException {
		// ʹ�����ķ�ʽ��ȡ��������
				InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
				// ��ȡSqlSessionFactory
				SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
				// ����SqlSessionFactory��ȡSqlSession
				SqlSession sqlSession = sessionFactory.openSession();
				// BookDTO book = sqlSession.selectOne("test.findBookById", 2);
				// ��ȡ�����ӿ�
				StudentMapper bookMapper = sqlSession.getMapper(StudentMapper.class);
				// ִ�з����ӿڣ�����ӳ�����е�findBookById����BookDTO����
				Student student = bookMapper.findStudentByid(1);
				System.out.println(student.toString());
	}
}

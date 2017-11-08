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
		// 使用流的方式获取整体配置
				InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
				// 获取SqlSessionFactory
				SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
				// 根据SqlSessionFactory获取SqlSession
				SqlSession sqlSession = sessionFactory.openSession();
				// BookDTO book = sqlSession.selectOne("test.findBookById", 2);
				// 获取方法接口
				StudentMapper bookMapper = sqlSession.getMapper(StudentMapper.class);
				// 执行方法接口，调用映射器中的findBookById返回BookDTO对象
				Student student = bookMapper.findStudentByid(1);
				System.out.println(student.toString());
	}
}

package com.study.zxxz.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.study.zxxz.dto.BookDTO;
import com.study.zxxz.dto.BookTypeDTO;
import com.study.zxxz.dto.TB_BookDTO;
import com.study.zxxz.mapper.BookMapper;

public class BookDao {

	// 根据ID查询方法测试
	@Test
	public void findBookById() throws IOException {
		// 使用流的方式获取整体配置
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		// 获取SqlSessionFactory
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 根据SqlSessionFactory获取SqlSession
		SqlSession sqlSession = sessionFactory.openSession();
		// BookDTO book = sqlSession.selectOne("test.findBookById", 2);
		// 获取方法接口
		BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
		// 执行方法接口，调用映射器中的findBookById返回BookDTO对象
		BookDTO book = bookMapper.findBookById(2);
		System.out.println(book.toString());
	}

	@Test
	public void findBooks() throws IOException {
		// 使用流的方式获取整体配置
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		// 获取SqlSessionFactory
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 根据SqlSessionFactory获取SqlSession
		SqlSession sqlSession = sessionFactory.openSession();
		// 根据id查询单个图书
		BookTypeDTO bookTypeDTO = sqlSession.selectOne("findBookType", 2);
		System.out.println("bookTypeDTO=" + bookTypeDTO.toString());
		for (BookDTO bookDTO : bookTypeDTO.getBookList()) {
			System.out.println("bookDTO=" + bookDTO.toString());
		}
		System.out.println(bookTypeDTO.getShelfDTO().toString());
	}

	@Test
	public void addBook() throws IOException {
		// 使用流的方式获取整体配置
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		// 获取SqlSessionFactory
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 根据SqlSessionFactory获取SqlSession
		SqlSession sqlSession = sessionFactory.openSession();
		// 设置新增图书参数
		BookDTO bookDTO = new BookDTO();
		bookDTO.setName("倚天屠龙记1");
		bookDTO.setBookTypeID(2);
		bookDTO.setPrice(58.8);
		bookDTO.setImg("55.png");
		bookDTO.setDescription("这是二本书");
		try {
			sqlSession.update("addBook", bookDTO);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		} finally {
			sqlSession.close();
		}
	}

	@Test
	public void findBookByName() throws IOException {
		// 使用流的方式获取整体配置
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		// 获取SqlSessionFactory
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 根据SqlSessionFactory获取SqlSession
		SqlSession sqlSession = sessionFactory.openSession();
		List<BookDTO> bookList = sqlSession.selectList("findBookByName", "九天");
		for (BookDTO bookDTO : bookList) {
			System.out.println(bookDTO.toString());
		}
	}

	@Test
	public void addBookReturnId() throws Exception {
		// 使用流的方式获取整体配置
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		// 获取SqlSessionFactory
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 根据SqlSessionFactory获取SqlSession
		SqlSession sqlSession = sessionFactory.openSession();
		BookDTO bookDTO = new BookDTO();
		bookDTO.setName("倚天屠龙记12");
		bookDTO.setBookTypeID(2);
		bookDTO.setPrice(58.8);
		bookDTO.setImg("57.png");
		bookDTO.setDescription("这是12本书");
		try {
			sqlSession.insert("addBookReturnId", bookDTO);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		} finally {
			sqlSession.close();
		}
		System.out.println(bookDTO.getBookID());
	}

	//新增图书，返回id
	@Test
	public void addNewBook() throws Exception {
		// 使用流的方式获取整体配置
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		// 获取SqlSessionFactory
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 根据SqlSessionFactory获取SqlSession
		SqlSession sqlSession = sessionFactory.openSession();
		TB_BookDTO bookDTO = new TB_BookDTO();
		bookDTO.setBookName("九鼎记");
		try {
			sqlSession.insert("addNewBook", bookDTO);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		} finally {
			sqlSession.close();
		}
		System.out.println(bookDTO.getBookID());
	}

	//删除图书
	@Test
	public void delBook() throws Exception {
		// 使用流的方式获取整体配置
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		// 获取SqlSessionFactory
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 根据SqlSessionFactory获取SqlSession
		SqlSession sqlSession = sessionFactory.openSession();
		try {
			// 调用delete执行删除
			sqlSession.delete("delBook", 14);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		} finally {
			sqlSession.close();
		}
	}

	//修改图书
	@Test
	public void modifyBook() throws Exception {
		// 使用流的方式获取整体配置
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		// 获取SqlSessionFactory
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 根据SqlSessionFactory获取SqlSession
		SqlSession sqlSession = sessionFactory.openSession();
		// 设置要修改的对象
		TB_BookDTO bookDTO = new TB_BookDTO();
		bookDTO.setBookID("bffde556-b7c4-11e7-b54f-20cf305fb5ca");
		bookDTO.setBookName("九鼎记1");
		try {
			// 调用update方法执行修改
			sqlSession.update("modifyBook", bookDTO);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		} finally {
			sqlSession.close();
		}
	}

	//查看图书信息，返回类型为resultMap
	@Test
	public void findBookMap() throws IOException {
		// 使用流的方式获取整体配置
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		// 获取SqlSessionFactory
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 根据SqlSessionFactory获取SqlSession
		SqlSession sqlSession = sessionFactory.openSession();
		BookDTO book = sqlSession.selectOne("findBookMap", 2);
		System.out.println(book.toString());
	}
}

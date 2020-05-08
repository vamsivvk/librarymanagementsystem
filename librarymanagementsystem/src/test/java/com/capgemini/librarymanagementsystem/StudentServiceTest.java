package com.capgemini.librarymanagementsystem;

import java.util.LinkedList;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.capgemini.librarymanagementsystem.dto.BookBean;
import com.capgemini.librarymanagementsystem.dto.RequestBean;
import com.capgemini.librarymanagementsystem.dto.StudentBean;
import com.capgemini.librarymanagementsystem.service.StudentServiceImp;

public class StudentServiceTest {
	private StudentServiceImp dao = new StudentServiceImp();
	@Test
	public void testRegister() {
		StudentBean bean = new StudentBean();
		bean.setId(10);
		bean.setName("krishna");
		bean.setEmail("krishna@gmail.com");
		bean.setPassword("Krish@123");
		bean.setPhone("996688775");
		bean.setSdepartment("ece");
		bean.setBooksBorrowed(5);
		boolean status = dao.register(bean);
		Assertions.assertEquals(true, status);	
	}
	
	@Test
	public void testAuth() {
		StudentBean bean1 = dao.auth("krishna@gmail.com","Krish@123");
		Assertions.assertNotNull(bean1);
	}    
	
	@Test
	public void testSearchBookByAuthor() {
		LinkedList<BookBean> bean1 = dao.searchBookAuthor("pawankalyan");
		Assertions.assertNotNull(bean1);
	}
	
	@Test
	public void testSearchBookByAuthor1() {
		LinkedList<BookBean> bean1 = dao.searchBookAuthor("messages");
		Assertions.assertNotNull(bean1);
	}
	
	@Test
	public void testSearchBookByName() {
		LinkedList<BookBean> bean1 = dao.searchBookTitle("janasena");
		Assertions.assertNotNull(bean1);
	}
	
	@Test
	public void testSearchBookByName1() {
		LinkedList<BookBean> bean1 = dao.searchBookTitle("srm");
		Assertions.assertNotNull(bean1);
	}
	@Test
	public void testSearchBookById() {
		LinkedList<BookBean> bean1 = dao.searchBookType(26);
		Assertions.assertNotNull(bean1);
	}
	
	@Test
	public void testSearchBookById1() {
		LinkedList<BookBean> bean1 = dao.searchBookType(29);
		Assertions.assertNotNull(bean1);
	}
	
	@Test
	public void testGetId() {
		List<Integer> bean1 = dao.getBookIds();
		Assertions.assertNotNull(bean1);
	}
	
	@Test
	public void testGetId1() {
		List<Integer> bean1 = dao.getBookIds();
		Assertions.assertEquals(1, bean1.size());
	}
	
	@Test
	public void testGetInfo() {
		List<BookBean> bean1 = dao.getBooksInfo();
		Assertions.assertNotNull(bean1);
	}
	
	@Test
	public void testGetInfo1() {
		List<BookBean> bean1 = dao.getBooksInfo();
		Assertions.assertEquals(1, bean1.size());
	}
	
	@Test
	public void testBookRequest() {
		BookBean bean1 = new BookBean();
		bean1.setId(26);
		StudentBean bean = new StudentBean();
		bean.setId(10);
		StudentBean student = null;
		BookBean book = null;
		RequestBean status = dao.bookRequest(student, book);
		Assertions.assertNotNull(status);	 
		}
	
	@Test
	public void testBookReturn() {
		BookBean bean1 = new BookBean();
		bean1.setId(26);
		StudentBean bean = new StudentBean();
		bean.setId(10);
		StudentBean student = null;
		BookBean book = null;
		RequestBean status = dao.bookRequest(student, book);
		Assertions.assertNotNull(status);	 
		}
	
}


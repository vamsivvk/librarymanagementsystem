package com.capgemini.librarymanagementsystem;

import java.util.LinkedList;
import java.util.List;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.capgemini.librarymanagementsystem.dao.AdminDAO;
import com.capgemini.librarymanagementsystem.dao.AdminDAOImp;
import com.capgemini.librarymanagementsystem.dto.AdminBean;
import com.capgemini.librarymanagementsystem.dto.BookBean;
import com.capgemini.librarymanagementsystem.dto.RequestBean;
import com.capgemini.librarymanagementsystem.dto.StudentBean;



public class AdminDaoTest {
	private AdminDAO dao = new AdminDAOImp();
	@Test
	public void testRegister() {
		AdminBean bean = new AdminBean();
		bean.setAid(9);
		bean.setAname("vamsi");
		bean.setEmail("vamsi@gmail.com");
		bean.setMobile(994806829);
		bean.setPassword("Vvk@12345");
		boolean status = dao.register(bean);
		Assertions.assertEquals(true, status);
	}
	
	@Test
	public void testAuth() {
		AdminBean bean1 = dao.auth("vamsi@gmail.com", "Vvk@12345");
		Assertions.assertNotNull(bean1);
	}    
	
	@Test
	public void testAddBook() {
		BookBean bean = new BookBean();
		bean.setId(26);
		bean.setName("prajakeeya");
		bean.setAuthor("upendra");
		bean.setCategory("politicalparty");
		bean.setPublishername("uppiboss");
		AdminDAOImp dao = new AdminDAOImp();
		boolean status = dao.addBook(bean);
		Assertions.assertEquals(1,status);
	}
	
	@Test
	public void testAddBook1() {
		BookBean bean = new BookBean();
		bean.setId(27);
		bean.setName("janasena");
		bean.setAuthor("pawankalayan");
		bean.setCategory("politics");
		bean.setPublishername("powerstar");
		AdminDAOImp dao = new AdminDAOImp();
		boolean status = dao.addBook(bean);
		Assertions.assertEquals(1,status);
	}
	
	@Test
	public void testUpdateBook() {
		BookBean bean = new BookBean();
		bean.setId(27);
		bean.setName("janasenani");
		boolean status = dao.updateBook(bean);
		Assertions.assertEquals(1,status);
	}
	
	@Test
	public void testDeleteBook() {
		BookBean bean = new BookBean();
		bean.setId(27);
		boolean status = dao.delete(27);
		Assertions.assertEquals(1, status);
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
	public void testIssueBook() {
		BookBean bean  = new BookBean();
		StudentBean bean1 = new StudentBean();
		bean.setId(26);
		bean.setId(10);
		boolean status = dao.issueBook(26);
		Assertions.assertFalse(status);
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
	public void testShowRequests() {
		List<RequestBean> bean1 = dao.showRequests();
		Assertions.assertNotNull(bean1);		
	}
	
	@Test
	public void testShowUsers() {
		List<StudentBean> bean1 = dao.showUsers();
		Assertions.assertNotNull(bean1);
	}
	
	@Test
	public void testIsBookRecieved() {
		BookBean bean1 = new BookBean();
		StudentBean bean = new StudentBean();
		bean1.setId(26);
		bean.setId(10);
		StudentBean student = null;
		BookBean book = null;
		boolean status = dao.isBookReceived(student, book);
		Assertions.assertTrue(status);	
	}	
	
	@Test
	public void testIsBookRecieved1() {
		BookBean bean1 = new BookBean();
		StudentBean bean = new StudentBean();
		bean1.setId(25);
		bean.setId(10);
		StudentBean student = null;
		BookBean book = null;
		boolean status = dao.isBookReceived(student, book);
		Assertions.assertFalse(status);	
	}	
}

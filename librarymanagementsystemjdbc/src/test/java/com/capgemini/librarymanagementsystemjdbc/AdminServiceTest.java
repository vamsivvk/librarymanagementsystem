package com.capgemini.librarymanagementsystemjdbc;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.capgemini.librarymanagementsystemjdbc.dao.AdminDAOImp;
import com.capgemini.librarymanagementsystemjdbc.dto.BookBean;
import com.capgemini.librarymanagementsystemjdbc.dto.StudentBean;
import com.capgemini.librarymanagementsystemjdbc.service.AdminServiceImp;

public class AdminServiceTest {
	BookBean bean = new BookBean();
	AdminServiceImp dao = new AdminServiceImp();
	@Test
	public void testAddBook() {
		BookBean bean = new BookBean();
		bean.setId(26);
		bean.setName("prajakeeya");
		bean.setAuthor("upendra");
		bean.setCategory("politicalparty");
		bean.setPublishername("uppiboss");
		AdminDAOImp dao = new AdminDAOImp();
		int status = dao.addBook(bean);
		Assertions.assertEquals(26,status);
	}
	
	@Test
	public void testAddBook1() {
		BookBean bean = new BookBean();
		bean.setId(25);
		bean.setName("janasena");
		bean.setAuthor("politics");
		bean.setCategory("pawankalyan");
		bean.setPublishername("powerstar");
		AdminDAOImp dao = new AdminDAOImp();
		int status = dao.addBook(bean);
		Assertions.assertEquals(25,status);
	}
	
	
	@Test
	public void testUpdateBook() {
		bean.setId(24);
		bean.setName("janasenani");
		int status = dao.update(bean);
		Assertions.assertEquals(24,status);
	}
	
	@Test
	public void testUpdateBook1() {
		bean.setId(27);
		bean.setName("Hero");
		int status = dao.update(bean);
		Assertions.assertEquals(27,status);
	}
	
	@Test
	public void testDeleteBook() {
		BookBean bean = new BookBean();
		bean.setId(25);
		int status = dao.delete(25);
		Assertions.assertEquals(25, status);
	}
	
	@Test
	public void testDeleteBook1() {
		BookBean bean = new BookBean();
		bean.setId(55);
		int status = dao.delete(55);
		Assertions.assertEquals(55,status);
	}

	@Test
	public void testSearchBookByAuthor() {
		BookBean bean1 = dao.searchBookAuthor("socialmessage");
		Assertions.assertNotNull(bean1);
	}
	
	@Test
	public void testSearchBookByAuthor1() {
		BookBean bean1 = dao.searchBookAuthor("messages");
		Assertions.assertNotNull(bean1);
	}
	
	@Test
	public void testSearchBookByName() {
		BookBean bean1 = dao.searchBookTitle("srimanthudu");
		Assertions.assertNotNull(bean1);
	}
	
	@Test
	public void testSearchBookByName1() {
		BookBean bean1 = dao.searchBookTitle("srm");
		Assertions.assertNotNull(bean1);
	}
	@Test
	public void testSearchBookById() {
		BookBean bean1 = dao.searchBookType(25);
		Assertions.assertNotNull(bean1);
	}
	
	@Test
	public void testSearchBookById1() {
		BookBean bean1 = dao.searchBookType(29);
		Assertions.assertNotNull(bean1);
	}
	@Test
	public void testIssueBook() {
		StudentBean bean1 = new StudentBean();
		bean.setId(25);
		bean1.setId("66");
		boolean status = dao.issueBook(25, "66");
		Assertions.assertTrue(status);
	}
	
	@Test
	public void testIssueBook1() {
		StudentBean bean1 = new StudentBean();
		bean.setId(29);
		bean1.setId("66");
		boolean status = dao.issueBook(29,"66");
		Assertions.assertFalse(status);
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
}

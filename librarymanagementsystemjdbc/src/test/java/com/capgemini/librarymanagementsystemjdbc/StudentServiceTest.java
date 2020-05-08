package com.capgemini.librarymanagementsystemjdbc;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.capgemini.librarymanagementsystemjdbc.dao.StudentDAOImp;
import com.capgemini.librarymanagementsystemjdbc.dto.BookBean;
import com.capgemini.librarymanagementsystemjdbc.dto.StudentBean;
import com.capgemini.librarymanagementsystemjdbc.service.StudentServiceImp;

public class StudentServiceTest {
StudentServiceImp dao = new StudentServiceImp();
	
	@Test
	public void testSearchBookByName() {
		BookBean bean1 = dao.searchBookTitle("janasena");
		Assertions.assertNotNull(bean1);
	}

	@Test
	public void testSearchBookByName1() {
		BookBean bean1 = dao.searchBookTitle("charlie");
		Assertions.assertNotNull(bean1);
	}
	
	@Test
	public void testSearchBookByAuthor() {
		BookBean bean1 = dao.searchBookAuthor("thriller");
		Assertions.assertNotNull(bean1);
	}

	@Test
	public void testSearchBookByAuthor1() {
		BookBean bean1 = dao.searchBookAuthor("ravindra");
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
	public void testRequestBook() {
		BookBean bean = new BookBean();
		StudentBean bean1 = new StudentBean();
		bean.setId(456789);
		bean1.setId("66");
		boolean status = dao.req(456789,"66");
		Assertions.assertTrue(status);
	}
	
	@Test
	public void testRequestBook1() {
		BookBean bean = new BookBean();
		StudentBean bean1 = new StudentBean();
		bean.setId(23);
		bean1.setId("66");
		boolean status = dao.req(23,"66");
		Assertions.assertFalse(status);
	}
	@Test
	public void testReturnRequestBook() {
		BookBean bean = new BookBean();
		bean.setId(456789);
		boolean status = dao.returnBook(456789);
		Assertions.assertTrue(status);
	}
	
	@Test
	public void testReturnRequestBook1() {
		BookBean bean = new BookBean();
		bean.setId(29);
		boolean status = dao.returnBook(29);
		Assertions.assertFalse(status);
	}

}

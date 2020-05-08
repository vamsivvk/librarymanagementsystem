package librarymanagementsystemspring;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.capgemini.librarymanagementsystemspring.dto.BookBean;
import com.capgemini.librarymanagementsystemspring.dto.UserBean;
import com.capgemini.librarymanagementsystemspring.service.StudentServiceImp;

public class StudentServiceTest {
private StudentServiceImp dao = new StudentServiceImp();
	
	@Test
	public void testSearchBookByAuthor() {
		BookBean bean1 = dao.searchBookAuthor("pawankalyan");
		Assertions.assertNotNull(bean1);
	}
	
	@Test
	public void testSearchBookByAuthor1() {
		BookBean bean1 = dao.searchBookAuthor("messages");
		Assertions.assertNotNull(bean1);
	}
	
	@Test
	public void testSearchBookByName() {
		BookBean bean1 = dao.searchBookTitle("janasena");
		Assertions.assertNotNull(bean1);
	}
	
	@Test
	public void testSearchBookByName1() {
		BookBean bean1 = dao.searchBookTitle("srm");
		Assertions.assertNotNull(bean1);
	}
	@Test
	public void testSearchBookById() {
		BookBean bean1 = dao.searchBookType(26);
		Assertions.assertNotNull(bean1);
	}
	
	@Test
	public void testSearchBookById1() {
		BookBean bean1 = dao.searchBookType(29);
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
		bean1.setBid(234567);
		UserBean bean = new UserBean();
		bean.setId(10);
		@SuppressWarnings("unused")
		UserBean student = null;
		@SuppressWarnings("unused")
		BookBean book = null;
		boolean status = dao.req(10, 234567);
		Assertions.assertTrue(status);	 
		}
	@Test
	public void testBookRequest1() {
		BookBean bean1 = new BookBean();
		bean1.setBid(345678);
		UserBean bean = new UserBean();
		bean.setId(10);
		@SuppressWarnings("unused")
		UserBean student = null;
		@SuppressWarnings("unused")
		BookBean book = null;
		boolean status = dao.req(10, 345678);
		Assertions.assertFalse(status);	 
		}
	
	@Test
	public void testBookReturn() {
		BookBean bean1 = new BookBean();
		bean1.setBid(234567);
		UserBean bean = new UserBean();
		bean.setId(10);
		@SuppressWarnings("unused")
		UserBean student = null;
		@SuppressWarnings("unused")
		BookBean book = null;
		boolean status = dao.reqReturnBook(10,234567);
		Assertions.assertTrue(status);	
		}
	@Test
	public void testBookReturn1() {
		BookBean bean1 = new BookBean();
		bean1.setBid(456789);
		UserBean bean = new UserBean();
		bean.setId(10);
		@SuppressWarnings("unused")
		UserBean student = null;
		@SuppressWarnings("unused")
		BookBean book = null;
		boolean status = dao.reqReturnBook(10,456789);
		Assertions.assertFalse(status);	
		}

}

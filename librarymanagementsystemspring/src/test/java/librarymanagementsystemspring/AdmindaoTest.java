package librarymanagementsystemspring;

import java.util.List;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.capgemini.librarymanagementsystemspring.dao.AdminDAOImp;
import com.capgemini.librarymanagementsystemspring.dto.BookBean;
import com.capgemini.librarymanagementsystemspring.dto.UserBean;

public class AdmindaoTest {
	@SuppressWarnings("unused")
	private BookBean bean = new BookBean();
	private AdminDAOImp dao = new AdminDAOImp();
	@Test
	public void testAddBook() {
		BookBean bean = new BookBean();
		bean.setBid(28);
		bean.setBook_title("srimanthudu");
		bean.setCategory("movie");
		bean.setAuthor("koratalasiva");
		bean.setBook_publisher("mythrimoviemakers");
		bean.setCopies(10);
		bean.setCopyright_year(2015);
		bean.setISBN(35);
		bean.setPublisher_name("gmbentertainments");
		bean.setStatus("available");
		AdminDAOImp dao = new AdminDAOImp();
		boolean status = dao.addBook(bean);
		Assertions.assertEquals(1,status);
	}
	
	@Test
	public void testAddBook1() {
		BookBean bean = new BookBean();
		bean.setBid(28);
		bean.setBook_title("janasena");
		bean.setCategory("politics");
		bean.setAuthor("pawankalyan");
		bean.setBook_publisher("powerstar");
		bean.setCopies(10);
		bean.setCopyright_year(2014);
		bean.setISBN(35);
		bean.setPublisher_name("janasenani");
		bean.setStatus("available");
		AdminDAOImp dao = new AdminDAOImp();
		boolean status = dao.addBook(bean);
		Assertions.assertEquals(1,status);
	}
		
	@Test
	public void testUpdateBook() {
		BookBean bean = new BookBean();
		bean.setBid(123456);
		bean.setBook_title("powerofyouth");
		boolean status = dao.update(bean);
		Assertions.assertEquals(1,status);
	}
	
	@Test
	public void testUpdateBook1() {
		BookBean bean = new BookBean();
		bean.setBid(345678);
		bean.setBook_title("power");
		boolean status = dao.update(bean);
		Assertions.assertEquals(1,status);
	}
	
	@Test
	public void testDeleteBook() {
		@SuppressWarnings("unused")
		BookBean bean = new BookBean();
		boolean status = dao.delete(234567);
		Assertions.assertEquals(1, status);
	}
	
	@Test
	public void testDeleteBook1() {
		@SuppressWarnings("unused")
		BookBean bean = new BookBean();
		boolean status = dao.delete(345678);
		Assertions.assertEquals(1, status);
		
	}

	@Test
	public void testSearchBookByAuthor() {
		BookBean bean1 = dao.searchBookAuthor("upendra");
		Assertions.assertNotNull(bean1);
	}
	
	@Test
	public void testSearchBookByAuthor1() {
		BookBean bean1 = dao.searchBookAuthor("uppiboss");
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
		BookBean bean1 = dao.searchBookType(234567);
		Assertions.assertNotNull(bean1);
	}
	
	@Test
	public void testSearchBookById1() {
		BookBean bean1 = dao.searchBookType(345678);
		Assertions.assertNotNull(bean1);
	}
	@Test
	public void testIssueBook() {
		UserBean bean1 = new UserBean();
		bean1.setId(10);
		BookBean bean = new BookBean();
		bean.setBid(234567);
		boolean status = dao.issueBook(10,234567);
		Assertions.assertTrue(status);
	}
	
	@Test
	public void testIssueBook1() {
		UserBean bean1 = new UserBean();
		bean1.setId(11);
		BookBean bean = new BookBean();
		bean.setBid(345678);
		boolean status = dao.issueBook(11,345678);
		Assertions.assertTrue(status);
		
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
	public void testReturnBook() {
		BookBean bean = new BookBean();
		bean.setBid(234567);
		UserBean bean1 = new UserBean();
		bean1.setId(10);
		boolean status = dao.returnBook(10, 234567);
		Assertions.assertEquals(1, status);
		
	}
	
}

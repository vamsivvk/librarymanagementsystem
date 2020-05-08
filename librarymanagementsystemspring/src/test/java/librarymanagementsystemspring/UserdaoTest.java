package librarymanagementsystemspring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.capgemini.librarymanagementsystemspring.dao.UserDAOImp;
import com.capgemini.librarymanagementsystemspring.dto.UserBean;

public class UserdaoTest {
	private UserDAOImp dao = new UserDAOImp();
	 private UserBean bean = new UserBean();
			@Test
			public void testRegister() {
				bean.setEmail("mahesh@gmail.com");
				bean.setId(65);
				bean.setMobile(908765432);
				bean.setName("mahesh");
				bean.setPassword("Mahesh@123");
				bean.setRole("admin");
				boolean status = dao.register(bean);
				Assertions.assertEquals(true,status);
			}
			
			@Test
			public void testRegister1() {
				bean.setEmail("babu@gmail.com");
				bean.setId(66);
				bean.setMobile(898765432);
				bean.setName("babu");
				bean.setPassword("babu123@");
				bean.setRole("student");
				boolean status = dao.register(bean);
				Assertions.assertEquals(true,status);
			}
			
			@Test
			public void testAuth() {
				UserBean bean1 = dao.auth("mahesh@gmail.com", "Mahesh@123");
				Assertions.assertNotNull(bean1);
			}
			
			@Test
			public void testAuth1() {
				UserBean bean1 = dao.auth("jeniffer@gmail.com", "Jennifer@123");
				Assertions.assertNotNull(bean1);
			}

}

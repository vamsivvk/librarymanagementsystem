package com.capgemini.librarymanagementsystemjdbc;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;
import com.capgemini.librarymanagementsystemjdbc.dto.UserBean;
import com.capgemini.librarymanagementsystemjdbc.service.UserServiceImp;

public class UserServiceTest {
	 UserServiceImp dao = new UserServiceImp();
	   UserBean bean = new UserBean();
		@Test
		public void testRegister() {
			bean.setEmail("mahesh@gmail.com");
			bean.setId(65);
			bean.setMobile(908765432);
			bean.setName("mahesh");
			bean.setPassword("Mahesh@123");
			bean.setRole("admin");
			int status = dao.register(bean);
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
			int status = dao.register(bean);
			Assertions.assertEquals(true,status);
		}
		
		@Test
		public void testLogin() {
			String bean1 = dao.auth("mahesh@gmail.com", "Mahesh@123");
			Assertions.assertNotNull(bean1);
		}
		
		@Test
		public void testLogin1() {
			String bean1 = dao.auth("jeff@gmail.com", "Jeff123@");
			Assertions.assertNotNull(bean1);
		}

}

package com.capgemini.librarymanagementsystemhibernate.controller;

import java.util.List;
import java.util.Scanner;
import com.capgemini.librarymanagementsystemhibernate.dao.AdminDAO;
import com.capgemini.librarymanagementsystemhibernate.dao.AdminDAOImp;
import com.capgemini.librarymanagementsystemhibernate.dto.BookBean;
import com.capgemini.librarymanagementsystemhibernate.dto.UserBean;
import com.capgemini.librarymanagementsystemhibernate.factory.AdminFactory;
import com.capgemini.librarymanagementsystemhibernate.factory.StudentFactory;
import com.capgemini.librarymanagementsystemhibernate.factory.UserFactory;
import com.capgemini.librarymanagementsystemhibernate.service.AdminService;
import com.capgemini.librarymanagementsystemhibernate.service.StudentService;
import com.capgemini.librarymanagementsystemhibernate.service.UserService;


public class LibraryController {
public static void main(String[] args) {
doReg();	
}
public static void doReg() {

	Scanner scanner = new Scanner(System.in);
	do {
		System.out.println("Press 1 to register");
		System.out.println("Press 2 to login");
		UserService service1 = UserFactory.getUserService();
		AdminService service = AdminFactory.getAdminService();

		int i = scanner.nextInt();
		switch(i) {
		case 1:
			System.out.println("Enter Id");
			int regId = scanner.nextInt();
			System.out.println("Enter Name");
			String regName = scanner.next();
			System.out.println("Enter Email");
			String regEmail = scanner.next();
			System.out.println("Enter Password");
			String regPassword = scanner.next();
			System.out.println("Enter Mobile");
			long regMobile = scanner.nextLong();
			System.out.println("Enter Role");
			String regRole = scanner.next();
			
			
			UserBean bean = new UserBean();
			bean.setId(regId);
			bean.setName(regName);
			bean.setEmail(regEmail);
			bean.setPassword(regPassword);
			bean.setMobile(regMobile);
			bean.setRole(regRole);
					try {
					boolean check = service1.register(bean);
					if(check==false) {
						System.out.println("Email already exist");
					} else {
						System.out.println("Registered");
					}}catch(Exception e) {
					System.out.println("invalid");
					}
					break;
			case 2:
				System.out.println("Enter email");
				String email = scanner.next();
				System.out.println("Enter Password");
				String password = scanner.next();
				try {
					UserBean auth = service1.auth(email, password);
					
					  if(auth.getRole().equalsIgnoreCase("admin")) {
					  
					  admin();
					  
					  }else if(auth.getRole().equalsIgnoreCase("student")){ 
						  student();
					  }
				else {
					System.out.println("invalid email and password");
				}
				}catch(Exception e) {
					e.printStackTrace();
					//System.out.println("invalid credentials");
				}
				break;
				}
				//break;
		}while(true);	
}

				public static void admin() {
					UserService service1 = UserFactory.getUserService();
					AdminService service = AdminFactory.getAdminService();
					BookBean bean = new BookBean();
					AdminDAO dao = new AdminDAOImp();
					Scanner scanner = new Scanner(System.in);
				System.out.println("Press 1 to Add Books");
				System.out.println("Press 2 to update");
				System.out.println("Press 3 to Search the Book by Author");
				System.out.println("Press 4 to Search the Book by Title");
				System.out.println("Press 5 to Search the Book by Id");
				System.out.println("Press 6 to remove the Books");
				System.out.println("Press 7 to Get the Book Id's");
				System.out.println("Press 8 to Get the Book Information");
				System.out.println("Press 9 to Issue book");
				System.out.println("Press 10 to Return book");
				System.out.println("Press 11 to Main");
				
				int choice1 = scanner.nextInt();
				switch (choice1) {
				case 1:
					
					System.out.println("Enter BOOK ID");
					int bookId = scanner.nextInt();
					System.out.println("Enter Book Title"); 
					String bookTitle = scanner.next();
					System.out.println("Enter Category");
					String category = scanner.next();
					System.out.println("Enter Author"); 
					String author = scanner.next();
					System.out.println("Enter Book Publisher");
					String bookPub =  scanner.next();
					System.out.println("Enter Publisher Name");
					String PubName =  scanner.next();
					System.out.println("Enter number of copies");
					int copies = scanner.nextInt();
					System.out.println("Enter ISBN");
					int isbn = scanner.nextInt();
					System.out.println("Enter Copyright year");
					int year = scanner.nextInt();
					System.out.println("Enter Status");
					String status = scanner.next();
					
					bean.setBid(bookId);
					bean.setBook_title(bookTitle);
					bean.setCategory(category);
					bean.setAuthor(author);
					bean.setBook_publisher(bookPub);
					bean.setPublisher_name(PubName);
					bean.setCopies(copies);
					bean.setISBN(isbn);
					bean.setCopyright_year(year);
					bean.setStatus(status);
					
					boolean check = service.addBook(bean);
					if(check == false) {
						System.out.println("Book already exists");
					} else {
						System.out.println("Book added");
					}
					
					break;
					
				case 2:
					System.out.println("enter id");
					int bId = scanner.nextInt();
					System.out.println("enter bookName");
					String name = scanner.next();
					bean.setBid(bId);
					bean.setBook_title(name);
					boolean updated = service.update(bean);
					if(updated == false) {
						System.out.println("book is not updated");
					}else {
						System.out.println("book  updated");
					}
					
					break;
				case 3:
					
					System.out.println("Enter Book author");
					String author1 = scanner.next();
					BookBean bean4 = new BookBean();
					bean4.setAuthor(author1);
					BookBean list1 = service.searchBookAuthor(author1);
					if(list1!=null) {
						System.out.println(list1.getBid());
						System.out.println(list1.getBook_title());
						System.out.println(list1.getCategory());
						System.out.println(list1.getAuthor());
						System.out.println(list1.getCopies());
						System.out.println(list1.getBook_publisher());
						System.out.println(list1.getPublisher_name());
						System.out.println(list1.getISBN());
						System.out.println(list1.getCopyright_year());
						System.out.println(list1.getStatus());
						System.out.println(list1);
					} else {
						System.out.println("Book Not Found");
					}
					break;
					
				case 4:
					System.out.println("Enter book Name");
					String bookName1 = scanner.next();
					BookBean bean3 = new BookBean();
					bean3.setBook_title(bookName1);
					BookBean list = service.searchBookTitle(bookName1);
					if(list!=null) {
						System.out.println(list.getBid());
						System.out.println(list.getBook_title());
						System.out.println(list.getCategory());
						System.out.println(list.getAuthor());
						System.out.println(list.getCopies());
						System.out.println(list.getBook_publisher());
						System.out.println(list.getPublisher_name());
						System.out.println(list.getISBN());
						System.out.println(list.getCopyright_year());
						System.out.println(list.getStatus());
						System.out.println(list);
					} else {
						System.out.println("Book Not Found");
					}
					break;
					
				case 5:
					System.out.println("Enter Book id");
					int id = scanner.nextInt();
					BookBean bean5 = new BookBean();
					bean5.setBid(id);
					BookBean list2 = service.searchBookType(id);
					if(list2!=null) {
						System.out.println(list2.getBid());
						System.out.println(list2.getBook_title());
						System.out.println(list2.getCategory());
						System.out.println(list2.getAuthor());
						System.out.println(list2.getCopies());
						System.out.println(list2.getBook_publisher());
						System.out.println(list2.getPublisher_name());
						System.out.println(list2.getISBN());
						System.out.println(list2.getCopyright_year());
						System.out.println(list2.getStatus());
						System.out.println(list2);
					} else {
						System.out.println("Book Not Found");
					}
					break;
				case 6:
					System.out.println("Enter the book_Id:");
					int book_Id = scanner.nextInt();
					if (book_Id == 0) {
						System.out.println("Enter the Valid Book_Id");
					} else {
						BookBean bean6 = new BookBean();

						bean6.setBid(book_Id);
						boolean remove = service.delete(book_Id);
						if (remove == false) {
							System.out.println("The Book is not removed");
						} else {
							System.out.println("The Book is removed");
						}
					}
					
					break;
				case 7:
					List<Integer> ids = service.getBookIds();
					try {
					for (Integer books : ids) {
						if (books != null) {
							System.out.println(books);
						} else {
							System.out.println("No Books Ids are available");
						}
					}
					}catch(Exception e) {
						e.printStackTrace();
					}
					
					break;
				case 8:

					List<BookBean> info = service.getBooksInfo();
					for (BookBean bookBean : info) {

						if (bookBean != null) {
							System.out.println(bookBean);
						} else {
							System.out.println("Books info is not present");
						}
					}
					break;
					
				case 9 :
					System.out.println("Enter Book Id");
					int issueId=scanner.nextInt();
					System.out.println("Enter User Id");
					int userId = scanner.nextInt();
					boolean check4=service.issueBook(userId, issueId);
					if(check4) {
						System.out.println("-----------------------------------------------");
						System.out.println("Book Issued");
					}else {
						System.out.println("-----------------------------------------------");
						System.out.println("Book not issued");
					}
					break;
					
				case 10 :
					System.out.println("Enter book id");
					int bookId1 = scanner.nextInt();
					System.out.println("Enter user id");
					int userId1 = scanner.nextInt();
					boolean check5 = service.returnBook(userId1, bookId1);
					if(check5 == true) {
						System.out.println("Book Returned");
					}else {
						System.out.println("Book cannot be returned");
					}
					
				case 11 :
					doReg();	
					}
				}
				
				public static void student() {
					Scanner scanner = new Scanner(System.in);
					StudentService service2 = StudentFactory.getStudentService();
					do {
							try {
								System.out.println("Press 1 to Search the Book by Author");
								System.out.println("Press 2 to Search the Book by Title");
								System.out.println("Press 3 to Search the Book by Id");
								System.out.println("Press 4 to Get the Book Id's");
								System.out.println("Press 5 to Get the Book Information");
								System.out.println("Press 6 to Return the book");
								System.out.println("Press 7 to Request book");
								System.out.println("Press 8 to Main");


								int choice2 = scanner.nextInt();
								switch (choice2) {
								case 1:
									System.out.println("Enter Book author");
									String author = scanner.next();
									BookBean bean4 = new BookBean();
									bean4.setAuthor(author);
									BookBean list1 = service2.searchBookAuthor(author);
									if(list1!=null) {
										System.out.println(list1.getBid());
										System.out.println(list1.getBook_title());
										System.out.println(list1.getCategory());
										System.out.println(list1.getAuthor());
										System.out.println(list1.getCopies());
										System.out.println(list1.getBook_publisher());
										System.out.println(list1.getPublisher_name());
										System.out.println(list1.getISBN());
										System.out.println(list1.getCopyright_year());
										System.out.println(list1.getStatus());
										System.out.println(list1);
									} else {
										System.out.println("Book Not Found");
									}
									break;
									
								case 2:
									System.out.println("Enter book Name");
									String bookName1 = scanner.next();
									BookBean bean3 = new BookBean();
									bean3.setBook_title(bookName1);
									BookBean list = service2.searchBookTitle(bookName1);
									if(list!=null) {
										System.out.println(list.getBid());
										System.out.println(list.getBook_title());
										System.out.println(list.getCategory());
										System.out.println(list.getAuthor());
										System.out.println(list.getCopies());
										System.out.println(list.getBook_publisher());
										System.out.println(list.getPublisher_name());
										System.out.println(list.getISBN());
										System.out.println(list.getCopyright_year());
										System.out.println(list.getStatus());
										System.out.println(list);
									} else {
										System.out.println("Book Not Found");
									}
									break;
								case 3:
									
									System.out.println("Enter Book id");
									int id = scanner.nextInt();
									BookBean bean5 = new BookBean();
									bean5.setBid(id);
									BookBean list2 = service2.searchBookType(id);
									if(list2!=null) {
										System.out.println(list2.getBid());
										System.out.println(list2.getBook_title());
										System.out.println(list2.getCategory());
										System.out.println(list2.getAuthor());
										System.out.println(list2.getCopies());
										System.out.println(list2.getBook_publisher());
										System.out.println(list2.getPublisher_name());
										System.out.println(list2.getISBN());
										System.out.println(list2.getCopyright_year());
										System.out.println(list2.getStatus());
										System.out.println(list2);
									} else {
										System.out.println("Book Not Found");
									}
									break;
									
								case 4:
									List<Integer> ids = service2.getBookIds();
									for (Integer integer : ids) {

										if (integer != null) {
											System.out.println(integer);
										} else {
											System.out.println("No Books Ids are available");
										}
									}
									break;
									
								case 5:
									List<BookBean> info = service2.getBooksInfo();
									for (BookBean bookBean : info) {

										if (bookBean != null) {
											System.out.println(bookBean);
										} else {
											System.out.println("Books info is not presernt");
										}
									}
									break;
									
								case 6:
									System.out.println("enter student id");
									int returned = scanner.nextInt();
									System.out.println("enter book id");
									int book_id = scanner.nextInt();
									boolean returnBook = service2.reqReturnBook(returned, book_id);
									if(returnBook) {
										System.out.println("Book returned");
									}else {
										System.out.println("book not returned");
									}
									break;
									
								case 7:
									System.out.println("enter book id");
									int reqBook = scanner.nextInt();
									System.out.println("enter id");
									int  reqId = scanner.nextInt();
									boolean book = service2.req(reqId, reqBook);
									if(book == true) {
										System.out.println("requested successfully");
									}else {
										System.out.println("book not found");
									}
									break;
									
								case 8:
									doReg();
								default:
									break;
								}
							} catch (Exception e) {
								System.out.println("Invalid Credentials");
							}
							break;
							
						}while(true);
				}
				
}


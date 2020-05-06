package com.capgemini.librarymanagementsystem.service;


	import java.util.LinkedList;
	import com.capgemini.librarymanagementsystem.dto.BookBean;
	import com.capgemini.librarymanagementsystem.dto.RequestBean;
	import com.capgemini.librarymanagementsystem.dto.StudentBean;

	public interface StudentService {
		boolean register(StudentBean info);
		StudentBean auth(String email, String password);
		LinkedList<BookBean> searchBookTitle(String bname);
		LinkedList<BookBean> searchBookAuthor(String bAuthor);
		LinkedList<BookBean> searchBookType(int bookType);
		LinkedList<Integer> getBookIds();
		LinkedList<BookBean> getBooksInfo();
		public RequestBean bookRequest(StudentBean student, BookBean book);
		public RequestBean bookReturn(StudentBean student, BookBean book);
}

package com.capgemini.librarymanagementsystemspring.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.capgemini.librarymanagementsystemspring.dao.AdminDAO;
import com.capgemini.librarymanagementsystemspring.dto.BookBean;
@Service
public class AdminServiceImp implements AdminService{
	@Autowired
	private AdminDAO dao;
	@Override
	public boolean update(BookBean book) {
		return dao.update(book);
	}

	@Override
	public boolean delete(int bId) {
		return dao.delete(bId);
	}

	@Override
	public boolean addBook(BookBean info) {
		return dao.addBook(info);
	}

	@Override
	public List<Integer> getBookIds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookBean> getBooksInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean issueBook(int id, int book_id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public BookBean searchBookTitle(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookBean searchBookAuthor(String Author) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookBean searchBookType(int bookType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean returnBook(int id, int book_id) {
		// TODO Auto-generated method stub
		return false;
	}

}
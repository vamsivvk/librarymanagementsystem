package com.capgemini.librarymanagementsystemspring.dao;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import com.capgemini.librarymanagementsystemspring.dto.BookBean;
import com.capgemini.librarymanagementsystemspring.dto.BookIssueDetailsBean;
import com.capgemini.librarymanagementsystemspring.dto.BorrowedBookBean;
import com.capgemini.librarymanagementsystemspring.dto.RequestBookBean;
import com.capgemini.librarymanagementsystemspring.exceptions.LMSException;

@Repository
public class StudentDAOImp implements StudentDAO{
	EntityManager manager = null;
	EntityTransaction transaction = null;
	int noOfBooks;
	
@PersistenceUnit
 private EntityManagerFactory factory;
	@Override
	public BookBean searchBookTitle(String name) {
		BookBean res = null;
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			
			String jpql = "select m from BookBean m where m.book_title =:mbook_title";
			TypedQuery<BookBean> query = manager.createQuery(jpql, BookBean.class);
			query.setParameter("mbook_title", name);
			res=query.getSingleResult();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		manager.close();
		factory.close();	
	return  res;
	}

	@Override
	public BookBean searchBookAuthor(String Author) {
		BookBean res = null;
		try {
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			
			String jpql = "select m from BookBean m where m.author =:mauthor";
			TypedQuery<BookBean> query = manager.createQuery(jpql, BookBean.class);
			query.setParameter("mauthor", Author);
			res=query.getSingleResult();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		manager.close();
		factory.close();
			
		
	return  res;
	
	}

	@Override
	public List<Integer> getBookIds() {
		List<Integer> bookBeans = null;
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.getTransaction();
			Query q = manager.createQuery("select bid from BookBean b");
			bookBeans = q.getResultList();
			transaction.commit();
		
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		manager.close();
		factory.close();
			
		
		return bookBeans;
	
	}

	@Override
	public List<BookBean> getBooksInfo() {
		manager = factory.createEntityManager();
		String jpql = "select b from BookBean b";
		TypedQuery<BookBean> query = manager.createQuery(jpql,BookBean.class);
		List<BookBean> recordList = query.getResultList();
		factory.close();
		return recordList;
	}

	@Override
	public BookBean searchBookType(int bookType) {
		BookBean record = null;
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			 record = manager.find(BookBean.class, bookType);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		manager.close();
		factory.close();
		
		return record;
	
	}

	@Override
	public boolean req(int id, int book_id) {
		int count = 0;
		try {
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			String jpql = "select b from BookBean b where b.bId=:bId";
			TypedQuery<BookBean> query = manager.createQuery(jpql,BookBean.class);
			query.setParameter("bId", book_id);
			List rs = query.getResultList();
			if(rs != null) {
				String jpql1 = "select b from BorrowedBooksBean b where b.uId=:uId and b.bId=:bId";
				TypedQuery<BorrowedBookBean> query1 = (TypedQuery<BorrowedBookBean>) manager.createQuery(jpql1,BorrowedBookBean.class);
				query1.setParameter("uId", id);
				query1.setParameter("bId", book_id);
				List rs1 = query1.getResultList();
				if( rs1.isEmpty() || rs1==null ) {
					String jpql2 = "select b from BookIssueBean b where b.uId=:uId";
					TypedQuery<BookIssueDetailsBean> query2 = (TypedQuery<BookIssueDetailsBean>) manager.createQuery(jpql2,BookIssueDetailsBean.class);
					query2.setParameter("id", id);
					List<BookIssueDetailsBean> rs2 = query2.getResultList();
					for(BookIssueDetailsBean p : rs2) {
						noOfBooks = count++;
					}
					if(noOfBooks<3) {
						Query bookName = manager.createQuery("select b.bookName from BookBean b where b.bId=:bookId");
						bookName.setParameter("bookId", book_id);
						List book = bookName.getResultList();
						Query email = manager.createQuery("select u.email from UsersBean u where u.uId=:user_Id");
						email.setParameter("user_Id",id);
						List userEmail = email.getResultList();
						transaction.begin();
						RequestBookBean request = new RequestBookBean();
						request.setId(book_id);
						request.setBook_title("book_title");
						request.setName((book.get(0).toString()));
						manager.persist(request);
						transaction.commit();
						return true;

					}else {
						throw new LMSException("You have crossed the book limit");
					}
				}else {
					throw new LMSException("You have already borrowed the requested book");
				}
			}else {
				throw new LMSException("The book with requested id is not present");
			}

		} catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		} 
	}


	@Override
	public boolean reqReturnBook(int id, int book_id) {
		try {
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			Query q = manager.createQuery("select b from BorrowedBookBean b where b.borrowBookPK.bid = :bid");
			q.setParameter("bid", book_id);	
			List count = q.getResultList();
			int s = count.size();
			if(s >= 0) {
				Query q1 =	manager.createQuery("select u.name from UserBean u where id=:id");
				q1.setParameter("id", id);
				List qq =  q1.getResultList();
				Query q2 = manager.createQuery("select b.book_title from BookBean b where bid=:bid");
				q2.setParameter("bid", book_id);
				List qq1 = q2.getResultList();
				Query q3 = manager.createQuery("select e.email from UserBean e where id=:id");
				q3.setParameter("id", id);
				List qq3 = q3.getResultList();
				Query req = manager.createNativeQuery("insert into requestbook1 (bid,email,book_title,id,name,type) values (?,?,?,?,?,?)");
				req.setParameter(1, book_id);
				req.setParameter(2,qq3.get(0));
				req.setParameter(3, qq1.get(0));
				req.setParameter(4, id);
				req.setParameter(5, qq.get(0));
				req.setParameter(6, "return");
				int count1 = req.executeUpdate();
				transaction.commit();
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		manager.close();
		factory.close();
		return false;
	}

	

}

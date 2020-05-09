package com.capgemini.librarymanagementsystemspring.dao;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
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
import com.capgemini.librarymanagementsystemspring.exceptions.LMSException;
@Repository
public class AdminDAOImp implements AdminDAO{
	EntityManager manager=null;
	EntityTransaction transaction=null;
	int noOfBooks;
	
@PersistenceUnit
private EntityManagerFactory factory;
	
	
	@Override
	public boolean update(BookBean book) {
		try{
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			BookBean record = manager.find(BookBean.class, book.getBid());
			record.setBook_title(book.getBook_title());
			transaction.commit();
			return true;
		}catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean delete(int bId) {
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			BookBean record = manager.find(BookBean.class, bId);
			manager.remove(record);
			transaction.commit();
			return true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	
	}


	@Override
	public boolean addBook(BookBean info) {
		BookBean res = null;
			try {
				manager = factory.createEntityManager();
				transaction = manager.getTransaction();
				transaction.begin();
				manager.persist(info);
				transaction.commit();
				return true;
			}catch (Exception e) {
				System.err.println(e.getMessage());
				return false;
			}
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
			Query q = manager.createQuery("select b.bid from BookBean b");
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
		List<BookBean> bookBeans = null;
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.getTransaction();
			Query q = manager.createQuery("from BookBean");
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
	public boolean issueBook(int id , int book_id) {
		BookIssueDetailsBean b = new BookIssueDetailsBean();
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			Query q = manager.createQuery("select b from BookBean b where b.bid = :bbid and b.copies>=1");
			Query	ss = q.setParameter("bbid", book_id);
			List count = ss.getResultList();
			System.out.println(count);
			int S = count.size();
			if(S>=1) {
				Query q1 = manager.createQuery("select r from RequestBook r where r.id = :id and r.reqBookPK.bid = :bid");
				 q1.setParameter("id", id);
			 q1.setParameter("bid", book_id);
				List count1 = q1.getResultList();
				int s = count1.size();
				System.out.println(s);
				if(s>=1) {
					Query q2 = manager.createQuery("select count(id) as idCount from BorrowedBookBean b where id=:id");
					q2.setParameter("id", id);
					List count2 = q2.getResultList();
					int s1 = count2.size();
					if(s1>=1) {
						int noOfBooksBorrowed =  count2.indexOf(0);
						if(noOfBooksBorrowed<3) {
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
							LocalDate date = LocalDate.now();
							Calendar c = Calendar.getInstance();
								c.setTime(new java.util.Date());
								c.add(Calendar.DATE, 15);
								String date1 =	sdf.format(c.getTime());
								Query userEmail = manager.createQuery("select u.email from UserBean u  where id = :id");
								userEmail.setParameter("id", id);
								List userEmail1 = userEmail.getResultList();
							Query q3 = manager.createNativeQuery("insert into bookissue1 (id,bid,email,issueDate,returnDate) values (? , ? , ? , ? , ?) ");
							q3.setParameter(1, id);
							q3.setParameter(2 , book_id);
							q3.setParameter(3, userEmail1.get(0));
							q3.setParameter(4, date);
							q3.setParameter(5, date1);
							int count3 = q3.executeUpdate();
							if(count3 != 0) {
								Query userEmail4 = manager.createQuery("select u.email from UserBean u where id = :id");
								userEmail4.setParameter("id", id);
								List userEmail44 = userEmail4.getResultList();
								Query q4 = manager.createNativeQuery("insert into borrowbook1 (id,bid,email) values (?,?,?)");
								q4.setParameter(1, id);
								q4.setParameter(2, book_id);
								q4.setParameter(3, userEmail44.get(0));
								q4.executeUpdate();
							
							Query q5 = manager.createQuery("delete from RequestBook r where r.id = :id and r.reqBookPK.bid = :bid");
							q5.setParameter("id", id);
							q5.setParameter("bid", book_id);
							q5.executeUpdate();
							Query q6 = manager.createQuery("update BookBean b set b.copies = b.copies-1 where b.bid = :bid");
							q6.setParameter("bid", book_id);
							q6.executeUpdate();
							transaction.commit();
							return true;
							}
							
						}
						
						
					}
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		manager.close();
		factory.close();
		
		return false;
	}

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
			factory = Persistence.createEntityManagerFactory("TestPersistence");
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
	public boolean returnBook(int id, int book_id) {
		BookBean res = null;
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			Query q = manager.createQuery("select b from BookIssueDetails b where b.id = :id and b.issuePK.bid = :bid");
			q.setParameter("id", id);
			q.setParameter("bid", book_id);
			List count = q.getResultList();
			int i = count.size();
			if(i>=1) {
				Query q1 = manager.createQuery("select r from RequestBook r where r.id = :id and r.reqBookPK.bid = :bid and type = :type");
				q1.setParameter("id", id);
				q1.setParameter("bid", book_id);
				q1.setParameter("type", "return");
				List count1 = q1.getResultList();
				int i1 = count1.size();
				if(i1>=1) {
					Query q2 = manager.createQuery("update BookBean b  set b.copies = b.copies+1 where b.bid = :bid");
					q2.setParameter("bid", book_id);
					q2.executeUpdate();
					Query q3 = manager.createQuery("delete from BookIssueDetails b where b.issuePK.bid = :bid and id =:id");
					q3.setParameter("bid", book_id);
					q3.setParameter("id", id);
					q3.executeUpdate();
					Query q4 = manager.createQuery("delete from BorrowedBookBean b where b.borrowBookPK.bid = :bid and id = :id");
					q4.setParameter("bid", book_id);
					q4.setParameter("id", id);
					q4.executeUpdate();
					Query q5 = manager.createQuery("delete from RequestBook r where r.id = :id and r.reqBookPK.bid = :bid and type = :type");
					q5.setParameter("id", id);
					q5.setParameter("bid", book_id);
					q5.setParameter("type", "return");
					q5.executeUpdate();
					transaction.commit();
					return true;
				}
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

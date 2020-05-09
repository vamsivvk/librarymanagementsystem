package com.capgemini.librarymanagementsystemspring.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import com.capgemini.librarymanagementsystemspring.dto.UserBean;

@Repository
public class UserDAOImp implements UserDAO{
	
EntityManager manager = null;
EntityTransaction transaction = null;
int noOfBooks;

@PersistenceUnit
private EntityManagerFactory factory;


	@Override
	public boolean register(UserBean bean) {
	
		try {
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(bean);
			transaction.commit();
			return true;
		}catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}

	@Override
	public UserBean auth(String email, String password) {
		try {
			manager = factory.createEntityManager();
			String jpql="select u from UserBean u where u.email=:email and u.password=:password";
			TypedQuery<UserBean> query = manager.createQuery(jpql,UserBean.class);
			query.setParameter("email", email);
			query.setParameter("password", password);
			UserBean bean = query.getSingleResult();
			return bean;
		}catch(Exception e){
			System.err.println(e.getMessage());
			return null;
		}
	}


}

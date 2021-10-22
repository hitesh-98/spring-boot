package com.nagarro.productmanagementspringboot.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nagarro.productmanagementspringboot.models.LoginForm;

@Repository
public class LoginDao {

	@Autowired
	private SessionFactory sessionFactory;

	public boolean validateUser(LoginForm user) {

		Transaction transaction = null;
		LoginForm loginForm = null;
		boolean flag = false;

		Session session = sessionFactory.openSession();

		String username = user.getUsername();
		String password = user.getPassword();

		String query = "select * from users where username= :username and password= :password";
		try {

			// start a transaction
			transaction = session.beginTransaction();

			// get loginForm object
			@SuppressWarnings("rawtypes")
			NativeQuery nativeQuery = session.createSQLQuery(query);
			nativeQuery.addEntity(LoginForm.class);
			nativeQuery.setParameter("username", username);
			nativeQuery.setParameter("password", password);

			loginForm = (LoginForm) nativeQuery.uniqueResult();

			if (loginForm != null) {
				flag = true;
			}

			// commit transaction
			if (transaction.isActive()) {
				transaction.commit();
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (transaction.isActive()) {
				session.getTransaction().commit();
			}
			session.close();
		}

		return flag;
	}
}

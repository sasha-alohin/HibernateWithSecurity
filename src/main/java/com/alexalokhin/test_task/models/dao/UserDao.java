package com.alexalokhin.test_task.models.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.alexalokhin.test_task.models.enteties.User;
import com.alexalokhin.test_task.models.interfaces.UserInterface;

@Repository
public class UserDao implements UserInterface {

	private static SessionFactory sessionFactory;
	private Transaction tx;
	private Session session;
	private User user;
	private static Logger LOGGER = Logger.getLogger(UserDao.class);

	static {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}

	public void save(User user) {
		session = sessionFactory.openSession();
		try {
			tx = session.beginTransaction();
			session.save(user);
			tx.commit();
			LOGGER.info("User:"+user.toString()+" was saved to DB");
		} catch (HibernateException e) {
			tx.rollback();
		} finally {
			session.close();
		}
	}

	public List<User> list() {
		session = sessionFactory.openSession();
		List<User> users = null;
		try {
			tx = session.beginTransaction();
			users = session.createSQLQuery("SELECT * FROM users").list();
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
		} finally {
			session.close();
		}
		return users;

	}

	public void update(User userNew, Integer id) {
		session = sessionFactory.openSession();
		try {
			tx = session.beginTransaction();
			user = (User)session.get(User.class, id);
			user.setIsActive(userNew.getIsActive());
			user.setUserName(userNew.getUserName());
			user.setPassword(userNew.getPassword());
			user.setRole(userNew.getRole());
			session.update(user);
			tx.commit();
			LOGGER.info("User:"+user.toString()+" was updated");
		} catch (HibernateException e) {
			tx.rollback();
		} finally {
			session.close();
		}
	}

	public void delete(Integer id) {
		session = sessionFactory.openSession();
		try {
			tx = session.beginTransaction();
			user = (User)session.get(User.class, id);
			session.delete(user);
			tx.commit();
			LOGGER.info("User:"+user.toString()+" was deleted from DB");
		} catch (HibernateException e) {
			tx.rollback();
		} finally {
			session.close();
		}
	}

}
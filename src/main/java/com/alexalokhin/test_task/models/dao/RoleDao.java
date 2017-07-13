package com.alexalokhin.test_task.models.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.alexalokhin.test_task.models.enteties.Role;
import com.alexalokhin.test_task.models.interfaces.RoleInterface;

@Transactional
@Repository
public class RoleDao implements RoleInterface {
	private static SessionFactory sessionFactory;
	private Transaction tx;
	private Session session;
	private Role role;
	private static Logger LOGGER = Logger.getLogger(RoleDao.class);
	static {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}

	public void save(Role role) {
		session = sessionFactory.openSession();
		try {
			tx = session.beginTransaction();
			session.save(role);
			tx.commit();
			LOGGER.info("Role:" + role.toString() + " was saved to DB");
		} catch (HibernateException e) {
			tx.rollback();
		} finally {
			session.close();
		}
	}

	public List<Role> list() {
		session = sessionFactory.openSession();
		List<Role> roles = null;
		try {
			tx = session.beginTransaction();
			roles = session.createSQLQuery("SELECT * FROM roles").list();
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
		} finally {
			session.close();
		}
		return roles;

	}

	public void update(Role roleNew, Integer id) {
		session = sessionFactory.openSession();
		try {
			tx = session.beginTransaction();
			role = (Role) session.get(Role.class, id);
			role.setName(roleNew.getName());
			session.update(role);
			tx.commit();
			LOGGER.info("Role:" + roleNew.toString() + " was updated");
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
			role = (Role) session.get(Role.class, id);
			session.delete(role);
			tx.commit();
			LOGGER.info("Role:" + role.toString() + " was deleted from DB");
		} catch (HibernateException e) {
			tx.rollback();
		} finally {
			session.close();
		}
	}
}

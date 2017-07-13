package com.alexalokhin.test_task.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alexalokhin.test_task.models.dao.UserDao;
import com.alexalokhin.test_task.models.enteties.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public void save(User p) {
		userDao.save(p);
	}

	@Transactional
	public List<User> list() {
		return userDao.list();
	}

	public void update(User p, Integer id) {
		userDao.update(p, id);
	}

	public void delete(Integer id) {
		userDao.delete(id);
	}

}

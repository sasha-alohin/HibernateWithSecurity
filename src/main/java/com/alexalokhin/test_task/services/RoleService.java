package com.alexalokhin.test_task.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexalokhin.test_task.models.dao.RoleDao;
import com.alexalokhin.test_task.models.enteties.Role;

@Service
public class RoleService {

	@Autowired
	private RoleDao roleDao;

	public void save(Role role) {
		roleDao.save(role);
	}

	public List<Role> list() {
		return roleDao.list();
	}

	public void update(Role role, Integer id) {
		roleDao.update(role, id);
	}

	public void delete(Integer id) {
		roleDao.delete(id);
	}
}

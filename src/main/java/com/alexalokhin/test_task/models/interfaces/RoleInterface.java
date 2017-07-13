package com.alexalokhin.test_task.models.interfaces;

import java.util.List;

import com.alexalokhin.test_task.models.enteties.Role;

public interface RoleInterface {

	public void save(Role role);

	public List<Role> list();

	public void update(Role role, Integer id);

	public void delete(Integer id);
}

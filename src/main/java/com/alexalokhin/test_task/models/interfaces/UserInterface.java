package com.alexalokhin.test_task.models.interfaces;

import java.util.List;

import com.alexalokhin.test_task.models.enteties.User;

public interface UserInterface {
	
	public void save(User user);

	public List<User> list();

	public void update(User user,Integer id);

	public void delete(Integer id);
}

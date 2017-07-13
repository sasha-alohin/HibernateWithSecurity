package com.alexalokhin.test_task.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alexalokhin.test_task.models.enteties.User;
import com.alexalokhin.test_task.services.UserService;

@RequestMapping(value = "/user")
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = "application/json")
	public void save(@RequestBody User user) {
		userService.save(user);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<User> list() {
		return userService.list();

	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = "application/json")
	public void update(@RequestBody User user, @PathVariable("id") Integer id) {
		userService.update(user, id);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public void delete(@PathVariable("id") Integer id) {
		userService.delete(id);
	}
}

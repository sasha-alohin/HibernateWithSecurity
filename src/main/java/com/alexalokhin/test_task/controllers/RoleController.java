package com.alexalokhin.test_task.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alexalokhin.test_task.models.enteties.Role;
import com.alexalokhin.test_task.services.RoleService;

@RequestMapping(value = "/roles")
@RestController
public class RoleController {
	@Autowired
	private RoleService roleService;

	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = "application/json")
	public void save(@RequestBody Role role) {
		roleService.save(role);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
	public List<Role> list() {
		return roleService.list();
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = "application/json")
	public void update(@RequestBody Role role, @PathVariable("id") Integer id) {
		roleService.update(role, id);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public void delete(@PathVariable("id") Integer id) {
		roleService.delete(id);
	}
}

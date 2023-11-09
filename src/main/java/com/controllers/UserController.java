package com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.User;
import com.services.UserDao;

@RestController
public class UserController {
	private final UserDao userdao;

	@Autowired
	public UserController(UserDao userdao) {
		this.userdao = userdao;
	}

	@CrossOrigin(origins = "*")
	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@CrossOrigin
	@GetMapping("/User/get")
	public Iterable<User> GetUser() {
		return userdao.GetUser();
	}

	@CrossOrigin(origins = "*")
	@PostMapping("/User/add")
	public void AddUser(@RequestBody User user) {
		userdao.AddUser(user);
	}

	@CrossOrigin(origins = "*")
	@DeleteMapping("/User/delete/{id}")
	public void DeleteUser(@PathVariable Long id) {
		userdao.DeleteUser(id);
	}

}

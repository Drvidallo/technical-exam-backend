package com.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.User;
import com.repository.UserRepository;

@Service
public class UserDao {

	@Autowired
	UserRepository userRepository;

	public void AddUser(User user) {
		userRepository.save(user);
	}

	public Iterable<User> GetUser() {
		return userRepository.findAll();
	}

	public void DeleteUser(Long id) {
		userRepository.deleteById(id);
	}
}

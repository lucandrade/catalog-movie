package com.dromaskin.mc.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dromaskin.mc.entity.User;
import com.dromaskin.mc.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User findByName(String name) {
		return userRepository.findByUserName(name);
	}

	public User save(String userName) {
		User user;
		User savedUser = findByName(userName);
		if (savedUser == null) {
			user = new User();
			user.setUserName(userName);
			if (user.getCreatedAt() == null) {
				user.setCreatedAt(new Date());
			}
			if (user.getUpdatedAt() == null) {
				user.setUpdatedAt(new Date());
			}
		} else {
			user = savedUser;
		}
		userRepository.save(user);
		return user;
	}
}

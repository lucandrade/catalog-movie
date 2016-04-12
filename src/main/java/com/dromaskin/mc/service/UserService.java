package com.dromaskin.mc.service;

import java.util.Date;

import com.dromaskin.mc.entity.User;

public class UserService {
	
	private UserService userService;
	
	public User findByName(String name) {
		return userService.findByName(name);
	}

	public User save(User user) {
		User savedUser = findByName(user.getUserName());
		if (savedUser == null) {
			if (user.getCreatedAt() == null) {
				user.setCreatedAt(new Date());
			}
			if (user.getUpdatedAt() == null) {
				user.setUpdatedAt(new Date());
			}
		} else {
			user = savedUser;
		}
		userService.save(user);
		return user;
	}
}

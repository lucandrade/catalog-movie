package com.dromaskin.mc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dromaskin.mc.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByUserName(String userName);
}

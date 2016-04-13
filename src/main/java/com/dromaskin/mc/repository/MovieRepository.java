package com.dromaskin.mc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dromaskin.mc.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

	public Movie findByTitle(String title);
}

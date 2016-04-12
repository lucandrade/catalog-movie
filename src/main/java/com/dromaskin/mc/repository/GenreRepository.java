package com.dromaskin.mc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dromaskin.mc.entity.Genre;

public interface GenreRepository extends JpaRepository<Genre, Integer> {

	public Genre findByName(String name);
}

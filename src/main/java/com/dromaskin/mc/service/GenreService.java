package com.dromaskin.mc.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dromaskin.mc.entity.Genre;
import com.dromaskin.mc.repository.GenreRepository;

@Service
@Transactional
public class GenreService {

	@Autowired
	private GenreRepository genreRepository;
	
	public void save(Genre genre) {
		if (genre.getCreatedAt() == null) {
			genre.setCreatedAt(new Date());
		}
		
		if (genre.getUpdatedAt() == null) {
			genre.setUpdatedAt(new Date());
		}
		
		genreRepository.save(genre);
	}
}

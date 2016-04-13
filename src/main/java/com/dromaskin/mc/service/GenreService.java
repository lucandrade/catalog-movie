package com.dromaskin.mc.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dromaskin.mc.entity.Genre;
import com.dromaskin.mc.repository.GenreRepository;

import com.github.slugify.Slugify;

@Service
@Transactional
public class GenreService {
	
	@Autowired
	private Slugify slugify;

	@Autowired
	private GenreRepository genreRepository;
	
	public Genre findByTmdbId(int tmdbId) {
		return genreRepository.findByTmdbId(tmdbId);
	}
	
	public Genre findByName(String name) {
		return genreRepository.findByName(name);
	}
	
	public Genre save(Genre genre) {
		Genre savedGenre = findByName(genre.getName());
		if (savedGenre == null) {
			if (genre.getCreatedAt() == null) {
				genre.setCreatedAt(new Date());
			}
			if (genre.getUpdatedAt() == null) {
				genre.setUpdatedAt(new Date());
			}
		} else if (genre.getName().equals(savedGenre.getName())) {
			return genre;
		} else {
			genre = savedGenre;
		}
		genre.setSlug(slugify.slugify(genre.getName()));
		genreRepository.save(genre);
		return genre;
	}
	
	public List<Genre> all() {
		return genreRepository.findAll();
	}
}

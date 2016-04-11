package com.dromaskin.mc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.dromaskin.mc.entity.Genre;
import com.dromaskin.mc.repository.GenreRepository;

@Controller
@EnableWebMvc
@RequestMapping("/rest/genre")
public class GenreController {
	
	@Autowired
	private GenreRepository genreRepository;

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	@ResponseStatus(value = HttpStatus.ACCEPTED)
	public @ResponseBody List<Genre> index() {
		return genreRepository.findAll();
	}
}

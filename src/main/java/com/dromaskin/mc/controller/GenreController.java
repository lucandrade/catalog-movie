package com.dromaskin.mc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.dromaskin.mc.entity.Genre;
import com.dromaskin.mc.service.GenreService;

@Controller
@EnableWebMvc
@RequestMapping(value = "/rest/genre", produces = "application/json")
public class GenreController {
	
	@Autowired
	private GenreService genreService;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Genre> index() {
		return genreService.all();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Genre post(HttpServletRequest request) {
		Genre genre = new Genre();
		genre.setName(request.getParameter("name"));
		return genreService.save(genre);
	}
	
}

package com.dromaskin.mc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.dromaskin.mc.entity.Genre;
import com.dromaskin.mc.rest.Response;
import com.dromaskin.mc.service.GenreService;

@Controller
@EnableWebMvc
@RequestMapping(value = "/rest/genre", produces = "application/json")
@CrossOrigin(origins = "http://localhost")
public class GenreController {
	
	@Autowired
	private GenreService genreService;
	
	@Autowired
	Response response;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody Response index() {
		response.setData(genreService.all());
		return response;
	}
	
}
